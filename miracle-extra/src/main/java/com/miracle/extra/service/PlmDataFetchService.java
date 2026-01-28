package com.miracle.extra.service;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.miracle.extra.domain.PlmProject;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class PlmDataFetchService {

    private static final Logger logger = LoggerFactory.getLogger(PlmDataFetchService.class);


    @Autowired
    private IPlmProjectService plmProjectService;

    @Value("${plm.project_task.username}")
    String USERNAME;

    @Value("${plm.project_task.password}")
    String PASSWORD;

    @Value("${plm.project_task.windchill_base_url}")
    String WINDCHILL_BASE_URL;

    @Value("${plm.project_task.host}")
    String HOST;

    @Value("${plm.project_task.get_projectInfo_url}")
    String GET_PROJECTINFO_URL;

    @Value("${plm.project_task.get_token_url}")
    String GET_TOKEN_URL;

    @Value("${plm.project_task.auth}")
    String AUTH;


    public void fetchPlmProjectDataDaily() {
        logger.info("开始执行PLM项目数据定时抓取任务");
        try {
            // 获取Windchill认证令牌
            String token = getWindchillToken();
            if (token == null || token.isEmpty()) {
                logger.error("获取Windchill认证令牌失败");
                return;
            }

            // 调用Windchill接口获取项目数据
            String projectData = fetchProjectDataFromWindchill(token);
            if (projectData != null && !projectData.isEmpty()) {
                // 解析项目数据并保存到数据库
                List<PlmProject> projects = parseProjectData(projectData);

                if (projects != null && !projects.isEmpty()) {
                    // 先清空现有数据，再批量插入新数据
                    plmProjectService.clearAllProjects();

                    // 每批次插入200条数据
                    int batchSize = 200;
                    // 总批次
                    int totalBatches = projects.size() / batchSize + (projects.size() % batchSize == 0 ? 0 : 1);

                    logger.info("开始分批插入{}条数据，每批次{}条，共分{}批", projects.size(),batchSize,totalBatches);
                    for (int i = 0; i < totalBatches; i++) {
                        int fromIndex = i * batchSize;
                        int toIndex = Math.min(fromIndex + batchSize, projects.size());
                        List<PlmProject> batch = projects.subList(fromIndex, toIndex);

                        try {
                            plmProjectService.insertPlmProjectBatch(batch);
                            logger.debug("成功插入第{}批数据，共{}条记录", i + 1, batch.size());
                        } catch (Exception e) {
                            logger.error("第{}批数据插入失败: {}", i + 1, e.getMessage());

                        }
                    }
                    //plmProjectService.insertPlmProjectBatch(projects);
                    logger.info("成功抓取并保存{}条PLM项目数据", projects.size());
                }
            }
        } catch (Exception e) {
            logger.error("PLM项目数据抓取任务执行失败", e);
        }
    }

    /**
     * 获取Windchill认证令牌
     */
    private String getWindchillToken() {
        String token = "";
        try {
            String encoded = Base64.getEncoder().encodeToString(AUTH.getBytes());
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build();

            Request request = new Request.Builder()
                    .url(WINDCHILL_BASE_URL + GET_TOKEN_URL)
                    .get()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("CSRF_NONCE", "Fetch")
                    .addHeader("Authorization", "Basic " + encoded)
                    .addHeader("cache-control", "no-cache")
                    .build();

            Response response = client.newCall(request).execute();
            if (!response.header("CSRF_NONCE").equals("Fetch")) {
                token = response.header("CSRF_NONCE");
                logger.info("成功获取Windchill认证令牌");
            } else {
                logger.error("获取Windchill认证令牌失败，响应码: {}", response.code());
            }
        } catch (IOException e) {
            logger.error("获取Windchill认证令牌时发生IO异常", e);
        } catch (Exception e) {
            logger.error("获取Windchill认证令牌时发生异常", e);
        }
        return token;
    }

    /**
     * 从Windchill获取项目数据
     */
    private String fetchProjectDataFromWindchill(String token) {
        String projectData = null;
        try {
            String encoded = Base64.getEncoder().encodeToString(AUTH.getBytes());
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .writeTimeout(100, TimeUnit.SECONDS)
                    .build();

            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            RequestBody requestBody = RequestBody.create(JSON, "");

            Request request = new Request.Builder()
                    .url(WINDCHILL_BASE_URL + GET_PROJECTINFO_URL)
                    .addHeader("CSRF_NONCE", token)
                    .addHeader("Authorization", "Basic " + encoded)
                    .addHeader("Host", HOST)
                    .post(requestBody)
                    .build();

            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                projectData = response.body().string();
                logger.info("成功从Windchill获取项目数据");
            } else {
                logger.error("从Windchill获取项目数据失败，响应码: {}", response.code());
            }
        } catch (IOException e) {
            logger.error("从Windchill获取项目数据时发生IO异常", e);
        } catch (Exception e) {
            logger.error("从Windchill获取项目数据时发生异常", e);
        }
        return projectData;
    }

    /**
     * 解析项目数据
     */
    private List<PlmProject> parseProjectData(String projectData) {
        try {
            JSONObject jsonObject = JSON.parseObject(projectData);
            JSONArray projectsArray = jsonObject.getJSONArray("projectInfo"); // 根据实际JSON结构调整

            List<PlmProject> projects = JSON.parseArray(projectsArray.toJSONString(), PlmProject.class);
            logger.info("成功解析{}条项目数据", projects.size());
            return projects;
        } catch (Exception e) {
            logger.error("解析项目数据时发生异常", e);
            return null;
        }
    }
}
