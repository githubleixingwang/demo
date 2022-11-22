package com.demo.moudleOne.todo.java;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
public class RequestKit {
    private static final String XSS_PATTERN = "(?i)script|window|location|alert|confirm|eval|onblur|onfocus|vbscript|document|cookie|iframe|function|href|input|javascript|onload|onclick|data:";
    private static final String SQL_PATTERN = "(?i)select|insert|delete|and|join|union|truncate|drop|merge|--";
    private static final String SPECIAL_CHARACTERS = "(?i)[`~!#$%^&*\\(\\)=+'<>?\\\\÷￠￡￥§±μàáèéêìíòóùúüàáèéêìíòóùúüŠ【】｛｝［］～｀！＠＃％＾＆＊（）＿－＋＝：；＂＇，．／＜＞？、。…“”‘’〝〞《》«»‹›〔〕〈〉〖〗『』︵︿︽﹁﹃︻︗﹏﹋﹍﹉¦︴¡¿¨·≦≧≮≯≡≤≥≈≒≠±∶∵∴∷]";
    private static final String ASCII_CHARACTERS = "(?i)%60|%7e|%21|%40|%23|%24|%25|%5e|%26|%2a|%28|%29|%2d|%5f|%3d|%2b|%7b|%7d|%3b|%3a|%27|%22|%3c|%2c|%2e|%3e|%2f|%3f|%7c|%5c|%22|%3A|%2C|%2E|%5C|%7B|%7D|%2D|%5F|%A2|%A3|%A5|%A7|%20|%B1|%B5|%C0|%C1|%C8|%C9|%CA|%CC|%CD|%D2|%D3|%D9|%DA|%DC|%E0|%E1|%E8|%E9|%EA|%EC|%ED|%F2|%F3|%F7|%F9|%FA|%FC|%8a|%E3%80%90|%E3%80%91|%EF%BD%9B|%EF%BD%9D|%EF%BC%BB|%EF%BC%BD|%EF%BD%9E|%EF%BD%80|%EF%BC%81|%EF%BC%A0|%EF%BC%83|%EF%BC%85|%EF%BC%BE|%EF%BC%86|%EF%BC%8A|%EF%BC%88|%EF%BC%89|%EF%BC%BF|%EF%BC%8D|%EF%BC%8B|%EF%BC%9D|%EF%BC%9A|%EF%BC%9B|%EF%BC%82|%EF%BC%87|%EF%BC%8C|%EF%BC%8E|%EF%BC%8F|%EF%BC%9C|%EF%BC%9E|%EF%BC%9F|%E3%80%82|%E2%80%A6|%E2%80%9C|%E2%80%9D|%E2%80%98|%E2%80%99|%E3%80%9D|%E3%80%9E|%E3%80%8A|%E3%80%8B|%C2%AB|%C2%BB|%E2%80%B9|%E2%80%BA|%E3%80%94|%E3%80%95|%E3%80%88|%E3%80%89|%E3%80%96|%E3%80%97|%E3%80%8E|%E3%80%8F|%EF%B8%B5|%EF%B8%BF|%EF%B8%BD|%EF%B9%81|%EF%B9%83|%EF%B8%BB|%EF%B8%97|%EF%B9%8F|%EF%B9%8B|%EF%B9%8D|%EF%B9%89|%C2%A6|%EF%B8%B4|%C2%A1|%C2%BF|%C2%A8|%C2%B7|%E2%89%A6|%E2%89%A7|%E2%89%AE|%E2%89%AF|%E2%89%A1|%E2%89%A4|%E2%89%A5|%E2%89%88|%E2%89%92|%E2%89%A0|%C2%B1|%E2%88%B6|%E2%88%B5|%E2%88%B4|%E2%88%B7";


    private String cleanSpecialCharacter(String value) {
        if (value != null && !value.isEmpty()) {
            int maxLength = 20000;
            String result = value.replaceAll(XSS_PATTERN, "").replaceAll(SQL_PATTERN, "").replaceAll(SPECIAL_CHARACTERS, "").replaceAll(ASCII_CHARACTERS, "").replaceAll(" ","");
            return result;
        } else {
            return value;
        }
    }
        public static String get(HttpServletRequest request, String key) {
            if (!"oldMap".equals(key) && !"ps".equals(key) && !"imageCode".equals(key) && !"verificationCode".equals(key) && !"un".equals(key)) {
                if (request instanceof RequestWrapper) {
                    RequestWrapper rw = (RequestWrapper)request;
                    return rw.getParameter(key);
                } else {
                    return (new RequestWrapper(request)).getParameter(key);
                }
            } else {
                return request.getParameter(key);
            }
        }


        public static Map<String, String[]> getParameterMap(HttpServletRequest request) {
            if (request instanceof RequestWrapper) {
                RequestWrapper rw = (RequestWrapper)request;
                return rw.getParameterMap();
            } else {
                return (new RequestWrapper(request)).getParameterMap();
            }
        }

        public static Map<String, Object> getParameMap(HttpServletRequest request) {
            Map<String, Object> result = new HashMap();
            Map<String, String[]> parameterMap = request.getParameterMap();
            Iterator var3 = parameterMap.entrySet().iterator();

            while(var3.hasNext()) {
                Entry<String, String[]> iterable_element = (Entry)var3.next();
                if (request instanceof RequestWrapper) {
                    RequestWrapper rw = (RequestWrapper)request;
                    result.put(iterable_element.getKey(), rw.getParameter((String)iterable_element.getKey()));
                } else {
                    result.put(iterable_element.getKey(), (new RequestWrapper(request)).getParameter((String)iterable_element.getKey()));
                }
            }

            return result;
        }

        public static String[] getValues(HttpServletRequest request, String key) {
            if (request instanceof RequestWrapper) {
                RequestWrapper rw = (RequestWrapper)request;
                return rw.getParameterValues(key);
            } else {
                return (new RequestWrapper(request)).getParameterValues(key);
            }
        }



        public static Object getAttribute(HttpServletRequest request, String key) {
            if (request instanceof RequestWrapper) {
                RequestWrapper rw = (RequestWrapper)request;
                return rw.getAttribute(key);
            } else {
                return (new RequestWrapper(request)).getAttribute(key);
            }
        }

        public static String[] getParameterValues(HttpServletRequest request, String key) {
            if (request instanceof RequestWrapper) {
                RequestWrapper rw = (RequestWrapper)request;
                return rw.getParameterValues(key);
            } else {
                return (new RequestWrapper(request)).getParameterValues(key);
            }
        }


        public static HttpServletRequest getRequest() {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
            return requestAttributes == null ? null : requestAttributes.getRequest();
        }

        public static void set(String key, Object value, HttpSession session) {
            session.setAttribute(key, value);
        }


        public static Map<String, Object> getJsonMap(HttpServletRequest request) {
        Map<String, Object> param = new HashMap();
        BufferedReader streamReader = null;
        StringBuilder responseStrBuilder = null;

        try {
            streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            responseStrBuilder = new StringBuilder();

            String inputStr;
            while((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }

            JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
            param = jsonObject;
            Iterator var6 = jsonObject.keySet().iterator();

            while(var6.hasNext()) {
                String key = (String)var6.next();
                String value = ((Map)param).get(key).toString();
                String result = value.replaceAll(XSS_PATTERN, "").replaceAll(SQL_PATTERN, "").replaceAll(SPECIAL_CHARACTERS, "").replaceAll(ASCII_CHARACTERS, "");
                ((Map)param).put(key, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (streamReader != null) {
                try {
                    streamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return (Map)param;
    }

    public static <T> T getParamterBean(HttpServletRequest request, Class<T> clszz) throws Exception {
        T obj = null;
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(clszz);
            obj = clszz.newInstance();
        } catch (IllegalAccessException var18) {
            throw new IllegalAccessException("实例化 JavaBean 失败");
        }

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        Enumeration en = request.getParameterNames();

        while(en.hasMoreElements()) {
            String paramName = (String)en.nextElement();

            for(int i = 0; i < propertyDescriptors.length; ++i) {
                if (paramName.toLowerCase().equals(propertyDescriptors[i].getName().toLowerCase()) && !"class".equals(propertyDescriptors[i].getName().toLowerCase())) {
                    PropertyDescriptor descriptor = propertyDescriptors[i];
                    String className = descriptor.getPropertyType().getName();
                    Method method = descriptor.getWriteMethod();
                    if (!"undefined".equals(request.getParameter(paramName)) && !StringUtils.isEmpty(request.getParameter(paramName)) && !"null".equals(request.getParameter(paramName))) {
                        Object value;
                        if (className.equals("java.lang.Boolean")) {
                            value = Boolean.parseBoolean(request.getParameter(paramName));
                        } else if (className.equals("java.lang.Integer")) {
                            value = Integer.parseInt(request.getParameter(paramName));
                        } else {
                            String result;
                            if (className.equals("java.util.Date")) {
                                result = request.getParameter(paramName);
                                Date parseDate = null;
                                try {
                                    parseDate = DateUtils.parseDate(result, new String[]{"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"});
                                } catch (ParseException var17) {
                                    throw new Exception("时间格式字段映射失败");
                                }
                                value = parseDate;
                            } else if (className.equals("java.lang.Long")) {
                                if (StringUtils.isBlank(request.getParameter(paramName))) {
                                    value = -1L;
                                } else {
                                    value = Long.parseLong(request.getParameter(paramName));
                                }
                            } else if (className.equals("java.lang.String")) {
                                value = request.getParameter(paramName);
                                value = String.valueOf(value).replaceAll(XSS_PATTERN, "").replaceAll(SQL_PATTERN, "").replaceAll(SPECIAL_CHARACTERS, "").replaceAll(ASCII_CHARACTERS, "");
                            } else if (className.equals("java.util.List")) {
                                List<String> list = Arrays.asList(request.getParameterValues(paramName));
                                ArrayList<String> arrayList = new ArrayList(list);
                                value = arrayList;
                            } else {
                                new Throwable("参数类型非常见类型，未处理！");
                                value = null;
                            }
                        }
                        try {
                            method.invoke(obj, value);
                        } catch (IllegalAccessException e) {
                            throw new IllegalAccessException("调用set方法失败");
                        } catch (InvocationTargetException e) {
                            throw new InvocationTargetException(e, "字段映射失败");
                        }
                    }
                }
            }
        }
        return obj;
    }

    public static <T> T getJsonBean(HttpServletRequest request, Class<T> clszz) throws Exception {
        T obj = null;
        BeanInfo beanInfo = null;

        try {
            beanInfo = Introspector.getBeanInfo(clszz);
            obj = clszz.newInstance();
        } catch (IllegalAccessException var33) {
            throw new IllegalAccessException("实例化 JavaBean 失败");
        } catch (IntrospectionException var34) {
            throw new IntrospectionException("获取分析类属性失败");
        } catch (InstantiationException var35) {
            throw new InstantiationException("实例化 JavaBean 失败");
        }

        BufferedReader streamReader = null;
        StringBuilder responseStrBuilder = null;

        try {
            streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            responseStrBuilder = new StringBuilder();

            String inputStr;
            while((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }

            JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            Iterator en = jsonObject.keySet().iterator();

            while(en.hasNext()) {
                String paramName = (String)en.next();

                for(int i = 0; i < propertyDescriptors.length; ++i) {
                    if (paramName.toLowerCase().equals(propertyDescriptors[i].getName().toLowerCase()) && !"class".equals(propertyDescriptors[i].getName().toLowerCase())) {
                        PropertyDescriptor descriptor = propertyDescriptors[i];
                        String className = descriptor.getPropertyType().getName();
                        Method method = descriptor.getWriteMethod();
                        if (jsonObject.get(paramName) != null && !"null".equals(jsonObject.getString(paramName)) && !"undefined".equals(jsonObject.getString(paramName))) {
                            Object value;
                            if (className.equals("java.lang.Boolean")) {
                                value = jsonObject.getBooleanValue(paramName);
                            } else if (className.equals("java.lang.Integer")) {
                                value = jsonObject.getIntValue(paramName);
                            } else if (className.equals("java.util.Date")) {
                                value = jsonObject.getDate(paramName);
                            } else if (className.equals("java.lang.Long")) {
                                value = jsonObject.getLongValue(paramName);
                            } else if (className.equals("java.lang.String")) {
                                value = jsonObject.get(paramName);
                                value = String.valueOf(value).replaceAll(XSS_PATTERN, "").replaceAll(SQL_PATTERN, "").replaceAll(SPECIAL_CHARACTERS, "").replaceAll(ASCII_CHARACTERS, "");
                            } else if (className.equals("java.util.List")) {
                                List<String> list = Arrays.asList(request.getParameterValues(paramName));
                                ArrayList<String> arrayList = new ArrayList(list);
                                value = arrayList;
                            } else {
                                new Throwable("参数类型非常见类型，未处理！");
                                value = null;
                            }
                            try {
                                method.invoke(obj, value);
                            } catch (IllegalAccessException var31) {
                                throw new InstantiationException("调用set方法失败");
                            } catch (InvocationTargetException var32) {
                                throw new InstantiationException("字段映射失败");
                            }
                        }
                    }
                }
            }
        } catch (Exception var36) {
            var36.printStackTrace();
        } finally {
            if (streamReader != null) {
                try {
                    streamReader.close();
                } catch (IOException var30) {
                    var30.printStackTrace();
                }
            }

        }

        return obj;
    }



}
