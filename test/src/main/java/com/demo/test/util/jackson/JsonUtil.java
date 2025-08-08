package com.demo.test.util.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Slf4j
public class JsonUtil {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    ;

    static {
        /*objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);//允许在JSON中使用注释
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);//允许JSON字段名不使用引号
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);//允许使用单引号表示字符串
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);//允许将单个值当作只有一个元素的数组来处理
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);//当遇到空字符串（""）时，将其视为null*/
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//当遇到空字符串（""）时，将其视为null
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        objectMapper.setDateFormat(sdf);
    }

    /**
     * json字符串转json对象
     *
     * @param json json字符串
     * @return jsonNode
     */
    public static JsonNode toJsonNode(String json) {
        if (StringUtils.isEmpty(json)) return null;
        try {
            return objectMapper.readTree(json);
        } catch (IOException e) {
            log.error("JSON解析失败: {}", json, e);
            return null;
        }
    }

    /**
     * Java对象转Json字符串
     *
     * @param object java对象
     * @return json
     */
    public static String toJsonString(Object object) {
        if (object == null) return null;
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("JSON序列化失败", e);
            return null;
        }
    }

    /**
     * Json字符串转Java对象
     *
     * @param json json字符串
     * @param clazz      java类
     * @return java对象
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) return null;
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            log.error("JSON转换失败: {}", json, e);
            return null;
        }
    }

    /**
     * JSON字符串转换为Java泛型对象
     *
     * @param json json字符串
     * @param typeRef         java对象类型
     * @param <T>        需要转换的对象类型
     * @return Java泛型对象
     */
    public static <T> T fromJson(String json, TypeReference<T> typeRef) {
        if (StringUtils.isEmpty(json)) return null;
        try {
            return objectMapper.readValue(json, typeRef);
        } catch (IOException e) {
            log.error("JSON泛型转换失败: {}", json, e);
            return null;
        }
    }

    /**
     * 将Java对象转换为格式化的（美化后的）JSON字符串
     *
     * @param object
     * @return
     */
    public static String toPrettyJson(Object object) {
        if (object == null) return null;
        try {
            return objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("JSON美化失败", e);
            return toJsonString(object);
        }
    }
}
