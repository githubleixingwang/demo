package com.demo.test.util.rsa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

@Slf4j
public class RsaUtil {

    public static final String PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCe6AfokHbsELnUvJpkzZ/pY4JyF85KTVY6+IxrBDlDENw4ck/dxZ2CPTV3TqzOKR+bAEoDLCAAC0S15RMScKgDIwSBWnclyhZyS1hvapPys86U20cx6oNIGnap5V8GOqteOHrHQNDMUH1dtkhUAZy52zicCuggVHgdIepR9gPhKfuiokRuS8nTDYpobEYUPYC9nXyLsQrwWIJg6IVTeYXkt6Brm2LSz/hPnvrvHSsIIwMjDdzSAJX8v5NM2ziQUH+VS6+mFFnyL+Jh/+T96HpYYLy6q7cE3dcP/ZKLQ8rdgSzn67EqNR8i3a+9azUZEuTHYpVdHrqbj/jNsZE32JONAgMBAAECggEAfzpX2qSQEsHxh5raIwtflYXO03qr+GGjQOPvyV9AWaoOKEOeHnoyeix3umaLhST34SqCF7gkhuR+xwP6GTGJ07kdylOcQe1ju28IB2zVt+Su6hAHGLgjFH/bsnurcVlYC8A8zXvfsTZgqb9geaIw0b3rvUQeRoRbBzg4XBcVVBj+HlX8RWnxXPtJ8xU/EI/uGYjGVwvzlRwLiEyMcgPkDR36QLt6zIOlr0bEBDZLw3TsqgJrhuVQzIU/GD3wQd1Nxwp22RFSIz3R5LvOUp+V7kyu9kX9HR8Xi1kqaK5cyfoibHJcgc9auu6IATx4KoPxTDRtrSThcef8tBvPxiZMIQKBgQDKbrRbCHdPSkr15Fc+la39L+Bb1RN5h37XA3DL2v2TDQbBMxHYtfD+msFh211Yxx6Vk0CgsxwCnBKcPnaTcq3cTsvxqhWWUIwDyMhzOhn37FdgpZYOImlcnMmCV44xnJWiETTL7uuV7zxlms8QqNy5GLXRJJx4jbAYt28fhbMGmwKBgQDI9MIbYQm41Paw3CN1xAodXXa3uPw0KTGQBc4dUTfPoduw+eeV3GaEXfZdvItTW5f2SksKqa4/OCH128kHUSrQ/2xusk4Y4/PvSoDsceRnHHDhqzXN3sP/2APpKaLCY9GG01Wgjo8k1/ENo6lT53fhDjtzxYNRmBzs8m1bylDc9wKBgAGpav2cUi5qc7cVCspOvEDp1bOrSh+jRx1Iv/JMd+xvHPEVFD5tL+9HIfNFs7x41f1wWgV3svEqitSRhrOrK1Y1p2LyfH7hZmTZjxuzDGeGnykB8vtmuOqztsvFIDu0B15vObm62mA+uIY1ASIn4Lf8RfHTlR1APIPXbagalt+lAoGAbkOenldIdlqkYbbo3h2LT0GReo3OFPDleRk2V2/RJ+SwHxOAtwIQXmEQZa6m5D5Fy6ZINrmUGqw6NiU60QEAdV0xqiu8Hnw1xP8kbpivssQwTCMdirDI6wEkZDOsUu1icpBTU53lfVnfspQyvQ8tABhHFucxfvvwIzOCPfNtG1ECgYAY1JpyQ1m2xKCrsvDkssWDKt4KJi/0HKJarcU9SGp1eoR8V8dNj24m5seEOhYfJGJBorUfuFgcxHm1qRo7uNeB5Iwt6tolmmZS5gupn2q2xEHJeL1pWcIV7Tl2GYJCLcw93cPtY47yxPPaz/0eIga2NPjQGBNL1gSz2D2dGaQDEg==";
    public static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnugH6JB27BC51LyaZM2f6WOCchfOSk1WOviMawQ5QxDcOHJP3cWdgj01d06szikfmwBKAywgAAtEteUTEnCoAyMEgVp3JcoWcktYb2qT8rPOlNtHMeqDSBp2qeVfBjqrXjh6x0DQzFB9XbZIVAGcuds4nAroIFR4HSHqUfYD4Sn7oqJEbkvJ0w2KaGxGFD2AvZ18i7EK8FiCYOiFU3mF5Lega5ti0s/4T5767x0rCCMDIw3c0gCV/L+TTNs4kFB/lUuvphRZ8i/iYf/k/eh6WGC8uqu3BN3XD/2Si0PK3YEs5+uxKjUfIt2vvWs1GRLkx2KVXR66m4/4zbGRN9iTjQIDAQAB";

    /**
     * 生成一对密钥，以map形式返回，key为密钥名称(publicKey, privateKey)，
     * value为对应base64编码的密钥
     */
    public static Map<String, String> generateRSAKeys() {
        try {
            // 创建KeyPairGenerator 指定算法为RSA，用于生成对应的公钥和私钥
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            // 密钥长度，常用为2048
            keyPairGenerator.initialize(2048);
            // 生成密钥对
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
            // 进行Base64编码存入
            String publicKeyStr = Base64.getEncoder().encodeToString(publicKey.getEncoded());
            String privateKeyStr = Base64.getEncoder().encodeToString(privateKey.getEncoded());
            Map<String, String> keyMap = new HashMap<>();
            keyMap.put("publicKey", publicKeyStr);
            keyMap.put("privateKey", privateKeyStr);
            return keyMap;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取私钥
     *
     * @param privateKey 字符串形式私钥
     */
    public static PrivateKey getPrivateKey(String privateKey) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(privateKey.getBytes(StandardCharsets.UTF_8));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     * 获取公钥
     *
     * @param publicKey 字符串形式公钥
     */
    public static PublicKey getPublicKey(String publicKey) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(publicKey.getBytes(StandardCharsets.UTF_8));
        X509EncodedKeySpec encodedKeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(encodedKeySpec);
    }

    /**
     * 私钥签名，使用sha256摘要算法和RSA加密签名
     *
     * @param data 数据
     */
    public static String signSha256(String data) {
        // 签名
        try {
            // 创建key工厂
            PrivateKey priKey = getPrivateKey(PRIVATE_KEY);
            // 使用指定算法的密钥工厂
            Signature signature = Signature.getInstance("SHA256WithRSA");
            // 初始化签名
            signature.initSign(priKey);
            // 数据body带入
            signature.update(data.getBytes());
            byte[] sign = signature.sign();
            // 采用base64算法进行转码,避免出现中文乱码
            return Base64.getEncoder().encodeToString(sign);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    /**
     * 公钥验签，使用sha256摘要算法和RSA进行验签
     *
     * @param data 数据
     * @param sign 签名
     */
    public static Boolean validateSignSha256(JSONObject data, String sign) {
        try {
            JSONObject jsonObject = sortJsonObject(data);
            List<String> parameterList = new ArrayList<>(jsonObject.keySet());
            //   Collections.sort(parameterList);
            List<String> list = new ArrayList<>(jsonObject.size());
            for (String name : parameterList) {
                if (jsonObject.get(name)!=null) {
                    String value = jsonObject.get(name).toString();
                    if(StringUtils.isNotBlank(value)){
                        list.add(String.format("%s=%s", name, value));
                    }
                }
            }
            String publicReqStr = StringUtils.join(list, "&");
            PublicKey pubKey = getPublicKey(PUBLIC_KEY);
            Signature verifySignature = Signature.getInstance("SHA256WithRSA");
            // 带入公钥进行验证
            verifySignature.initVerify(pubKey);
            // 数据body带入
            verifySignature.update(publicReqStr.getBytes());
            // 验证签名
            boolean verify = verifySignature.verify(Base64.getDecoder().decode(sign));
            if (!verify) {
                log.error("签名验证失败，验签数据={},sign={}",publicReqStr,sign);
            }
            return verify;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public static JSONObject sortJsonObject(JSONObject source) {
        // 使用 TreeMap 对键进行自然排序
        TreeMap<String, Object> sortedMap = new TreeMap<>();

        source.forEach((key, value) -> {
            sortedMap.put(key, processValue(value));
        });

        // 将排序后的键值对转换为新的 JSONObject
        JSONObject sortedJson = new JSONObject(true); // 保持插入顺序
        sortedMap.forEach(sortedJson::put);
        return sortedJson;
    }

    private static Object processValue(Object value) {
        if (value instanceof JSONObject) {
            return sortJsonObject((JSONObject) value);
        } else if (value instanceof JSONArray) {
            return processJsonArray((JSONArray) value);
        }
        return value; // 保持基本类型不变
    }

    private static JSONArray processJsonArray(JSONArray array) {
        JSONArray sortedArray = new JSONArray();
        array.forEach(item -> {
            if (item instanceof JSONObject || item instanceof JSONArray) {
                sortedArray.add(processValue(item));
            } else {
                sortedArray.add(item); // 非结构化数据直接保留
            }
        });
        return sortedArray;
    }

    public static void main(String[] args) {
        String jsonStr = "{\"b\":2,\"a\":{\"c\":[{\"t\":30,\"e\":30},{\"y\":25,\"e\":30}]},\"d\":4,\"f\":[{\"g\":{\"h\":30,\"j\":30},\"k\":25}]}";
        JSONObject original = JSONObject.parseObject(jsonStr);

        JSONObject sorted = sortJsonObject(original);
        System.out.println(JSONObject.toJSONString(sorted, true));
    }

}
