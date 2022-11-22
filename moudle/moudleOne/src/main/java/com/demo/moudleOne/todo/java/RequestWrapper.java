package com.demo.moudleOne.todo.java;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.apache.commons.io.IOUtils;


public class RequestWrapper extends HttpServletRequestWrapper {

    private ByteArrayOutputStream cachedBytes;

    private static final String XSS_PATTERN = "(?i)script|window|location|alert|confirm|eval|onblur|onfocus|vbscript|document|cookie|iframe|function|href|input|javascript|onload|onclick|data:";
    private static final String SQL_PATTERN = "(?i)select|insert|delete|and|join|union|truncate|drop|merge|--";
    private static final String SPECIAL_CHARACTERS = "(?i)[`~!#$%^&*\\(\\)=+'<>?\\\\÷￠￡￥§±μàáèéêìíòóùúüàáèéêìíòóùúüŠ【】｛｝［］～｀！＠＃％＾＆＊（）＿－＋＝：；＂＇，．／＜＞？、。…“”‘’〝〞《》«»‹›〔〕〈〉〖〗『』︵︿︽﹁﹃︻︗﹏﹋﹍﹉¦︴¡¿¨·≦≧≮≯≡≤≥≈≒≠±∶∵∴∷]";
    private static final String ASCII_CHARACTERS = "(?i)%60|%7e|%21|%40|%23|%24|%25|%5e|%26|%2a|%28|%29|%2d|%5f|%3d|%2b|%7b|%7d|%3b|%3a|%27|%22|%3c|%2c|%2e|%3e|%2f|%3f|%7c|%5c|%22|%3A|%2C|%2E|%5C|%7B|%7D|%2D|%5F|%A2|%A3|%A5|%A7|%20|%B1|%B5|%C0|%C1|%C8|%C9|%CA|%CC|%CD|%D2|%D3|%D9|%DA|%DC|%E0|%E1|%E8|%E9|%EA|%EC|%ED|%F2|%F3|%F7|%F9|%FA|%FC|%8a|%E3%80%90|%E3%80%91|%EF%BD%9B|%EF%BD%9D|%EF%BC%BB|%EF%BC%BD|%EF%BD%9E|%EF%BD%80|%EF%BC%81|%EF%BC%A0|%EF%BC%83|%EF%BC%85|%EF%BC%BE|%EF%BC%86|%EF%BC%8A|%EF%BC%88|%EF%BC%89|%EF%BC%BF|%EF%BC%8D|%EF%BC%8B|%EF%BC%9D|%EF%BC%9A|%EF%BC%9B|%EF%BC%82|%EF%BC%87|%EF%BC%8C|%EF%BC%8E|%EF%BC%8F|%EF%BC%9C|%EF%BC%9E|%EF%BC%9F|%E3%80%82|%E2%80%A6|%E2%80%9C|%E2%80%9D|%E2%80%98|%E2%80%99|%E3%80%9D|%E3%80%9E|%E3%80%8A|%E3%80%8B|%C2%AB|%C2%BB|%E2%80%B9|%E2%80%BA|%E3%80%94|%E3%80%95|%E3%80%88|%E3%80%89|%E3%80%96|%E3%80%97|%E3%80%8E|%E3%80%8F|%EF%B8%B5|%EF%B8%BF|%EF%B8%BD|%EF%B9%81|%EF%B9%83|%EF%B8%BB|%EF%B8%97|%EF%B9%8F|%EF%B9%8B|%EF%B9%8D|%EF%B9%89|%C2%A6|%EF%B8%B4|%C2%A1|%C2%BF|%C2%A8|%C2%B7|%E2%89%A6|%E2%89%A7|%E2%89%AE|%E2%89%AF|%E2%89%A1|%E2%89%A4|%E2%89%A5|%E2%89%88|%E2%89%92|%E2%89%A0|%C2%B1|%E2%88%B6|%E2%88%B5|%E2%88%B4|%E2%88%B7";

    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    private String cleanSpecialCharacter(String value) {
        if (value != null && !value.isEmpty()) {
            String url = this.getRequestURI();
            int maxLength = 20000;
            String result = value.replaceAll(XSS_PATTERN, "").replaceAll(SQL_PATTERN, "").replaceAll(SPECIAL_CHARACTERS, "").replaceAll(ASCII_CHARACTERS, "").replaceAll(" ","");
            return result;
        } else {
            return value;
        }
    }

 /**
  * 获取指定参数名的值，如果有重复的参数名，则返回第一个的值 接收一般变量 ，如text类型
  * @param key 指定参数名
  * @return 指定参数名的值
  */
    @Override
    public String getParameter(String key) {
        String value = super.getParameter(key);
        return !"oldMap".equals(key) && !"ps".equals(key) ? this.cleanSpecialCharacter(value) : value;
    }

    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> parameterMap = super.getParameterMap();
        for (Entry<String, String[]> entry : parameterMap.entrySet()) {
            String[] values = entry.getValue();
            if( values == null || values.length == 0){
                continue;
            }
            for (int i = 0; i < values.length; i++) {
                values[i] = cleanSpecialCharacter(values[i]);
            }
        }
        return  parameterMap;
    }

 /**
   * 获取指定参数名的所有值的数组，如：checkbox的所有数据
   * 接收数组变量 ，如checkobx类型
  */
    @Override
    public String[] getParameterValues(String key) {
        String[] values = super.getParameterValues(key);
        if ("ps".equals(key)) {
            return values;
        } else if (values != null && values.length != 0) {
            int length = values.length;
            for (int i = 0; i < length; ++i) {
                values[i] = this.cleanSpecialCharacter(values[i]);
            }
            return values;
        } else {
            return values;
        }
    }

    public String getHeader(String key) {
        String header = super.getHeader(key);
        return this.cleanSpecialCharacter(header);
    }

    public Object getAttribute(String key) {
        Object value = super.getAttribute(key);
        if (value == null) {
            return value;
        } else {
            return value instanceof String ? this.cleanSpecialCharacter((String) value) : value;
        }
    }

    private void cacheInputStream() throws IOException {
        this.cachedBytes = new ByteArrayOutputStream();
        String contentType = this.getHeader("Content-Type");
        IOUtils.copy(super.getInputStream(), this.cachedBytes);
        boolean isJsonPayload = contentType != null && contentType.toLowerCase().contains("application/json");
        if (isJsonPayload) {
            String value = IOUtils.toString(new ByteArrayInputStream(this.cachedBytes.toByteArray()));
            value = this.cleanSpecialCharacter(value);
            this.cachedBytes = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(this.cachedBytes);
            IOUtils.write(value.getBytes(), out);
        }

    }
}

