package com.miracle.extra.service;

import com.miracle.extra.domain.SunwodaToolingMoldImport;
import com.miracle.extra.mapper.SunwodaToolingMoldImportMapper;
import com.miracle.extra.utils.SignatureUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class SunwodaToolingMoldImportService {
    private final RestTemplate restTemplate;

    @Resource
    private SunwodaToolingMoldImportMapper sunwodaToolingMoldImportMapper;

    @Value("${sunwoda.api.url}")
    private String targetUrl;
    @Value("${sunwoda.auth.appId}")
    private String appId;
    @Value("${sunwoda.auth.appSec}")
    private String appSec;
    @Value("${sunwoda.env}")
    private String environment;
    @Value("${sunwoda.vendorCode}")
    private String vendorCode;

    public SunwodaToolingMoldImportService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void pushData() {
        // 1. 生成时间戳（秒级）
        String timestamp = String.valueOf(Instant.now().toEpochMilli());

        // 2. 生成签名
        String sign = SignatureUtil.generateSign(appId, appSec, timestamp);
        System.out.println("sign: " + sign);
        System.out.println("timestamp: " + timestamp);
        System.out.println("appId: " + appId);
        // 3. 准备数据
        List<SunwodaToolingMoldImport> requestBody = prepareData();
        System.out.println("requestBody: " + requestBody);

        // 4. 设置认证请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("sign", sign);
        headers.add("appId", appId);
        headers.add("timestamp", timestamp);
        headers.add("env", environment);

        // 5. 构建请求
        HttpEntity<List<SunwodaToolingMoldImport>> requestEntity =
                new HttpEntity<>(requestBody, headers);

        // 6. 发送请求
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    targetUrl,
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );
            handleResponse(response);
        } catch (Exception e) {
            System.err.println("推送异常: " + e.getMessage());
        }
    }

    private List<SunwodaToolingMoldImport> prepareData() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.of("+08:00")).truncatedTo(ChronoUnit.MILLIS);
        List<SunwodaToolingMoldImport> result = getAllByDate(Date.from(yesterday.atStartOfDay().atZone(java.time.ZoneId.systemDefault()).toInstant()));
        System.out.println("yesterday: " + Date.from(yesterday.atStartOfDay().atZone(java.time.ZoneId.systemDefault()).toInstant()));
        for (SunwodaToolingMoldImport item : result){
            item.setProjectName("无");
            item.setVendorCode(vendorCode);
            item.setDataUploadTime(now);
        }
        System.out.println("result : " + result);

        return result;
    }

    public List<SunwodaToolingMoldImport> getAll(SunwodaToolingMoldImport sunwodaToolingMoldImport) {
        return sunwodaToolingMoldImportMapper.selectSunwodaToolingMoldImportList(sunwodaToolingMoldImport);
    }

    private void handleResponse(ResponseEntity<String> response) {
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("推送成功! 响应: " + response.getBody());
        } else {
            System.err.println("推送失败! 状态码: " + response.getStatusCode());
            System.err.println("错误详情: " + response.getBody());
        }
    }

    public List<SunwodaToolingMoldImport> getAllByDate(Date date){
        return sunwodaToolingMoldImportMapper.selectSunwodaToolingMoldImportListByDate(date);
    }

}
