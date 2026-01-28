package com.miracle.extra.config;

import io.minio.MinioClient;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MinIO 配置类
 *
 * @author miracle
 */
@Getter
@Configuration
public class MinioConfig {

    @Value("${minio.endpoint}")
    public String endpoint;

    @Value("${minio.accessKey}")
    public String accessKey;

    @Value("${minio.secretKey}")
    public String secretKey;

    @Value("${minio.bucketName}")
    public String bucketName;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }

}