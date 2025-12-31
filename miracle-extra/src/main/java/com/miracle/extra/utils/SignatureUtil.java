package com.miracle.extra.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SignatureUtil {
    public static String generateSign(String appId, String appSec, String timestamp) {
        try {
            // 第一重MD5：appId + timestamp
            String innerHash = md5(appId + timestamp);

            // 第二重MD5：appSec + innerHash
            String str = md5(appSec + innerHash);
            System.out.println("Generated Signature: " + str);
            return str;
            //return md5(appSec + innerHash);
        } catch (Exception e) {
            throw new RuntimeException("生成签名失败", e);
        }
    }

    private static String md5(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));

        // 转换为32位小写十六进制
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
