/*
package com.demo.test.filter;

import com.google.re2j.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

*/
/**
 * @author: lxw
 * @date: 2023-04-20  10:15
 *//*

@Slf4j
public class CivilViolationFilter implements Filter {
    
    private static final String FILTER_PROPERTIES = "filter.properties";//关键字
    private static final String IGNORES_INI = "violation-ignores.ini";
    private static final String DENIES_INI = "violation-denies.ini";
    private static final String SPECIAL_URLS_INI = "violation-special-url.ini";

    private static final Set<String> availableFiles = Stream.of(FILTER_PROPERTIES, IGNORES_INI, DENIES_INI, SPECIAL_URLS_INI).collect(Collectors.toSet());

    private boolean enable;

    private Thread watcher;

    //关键字
    private Pattern sqlInjectionPattern = null;
    private String xssFilterKeyword = "";
    //正则表达式   用 &!& 分割
    private Pattern[] addtionSqlInjectionPatterns = null;
    private Pattern[] addtionXssPatterns = null;
    //白名单
    private Set<String> violationIgnores = new HashSet<>();
    //黑名单
    private Set<String> violationDenies = new HashSet<>();
    //特定url
    private Set<String> specialUrls = new HashSet<>();

    */
/**
     * 加载主配置文件，包含是否启用、SQL注入和XSS的关键字、正则配置
     *
     * @param filterConfPath
     *//*

    private void loadFilterProperties(String filterConfPath) {
        Properties properties = new Properties();
        try (InputStream is = Streams.fileIn(filterConfPath + File.separator + FILTER_PROPERTIES)) {
            properties.load(is);
        } catch (IOException e) {
            log.warn("Load Violation Filter config failed, caused by:", e);
        }

        enable = Boolean.parseBoolean(properties.getProperty("enable", "false"));//默认关闭

        //sql关键字
        String sqlFilterKeyword = properties.getProperty("sql_filter_keyword", "and|or|where");
        StringBuilder sb = new StringBuilder("(?:'[ a-zA-Z0-9_\\-*]+)|( (");
        sb.append(sqlFilterKeyword);
        sb.append("))");
        sqlInjectionPattern = Pattern.compile(sb.toString(), Pattern.CASE_INSENSITIVE);

        //sql正则表达式  patternArrSql
        String sqlFilterReg = properties.getProperty("sql_filter_reg");
        if (null != sqlFilterReg && sqlFilterReg.length() > 0) {
            String[] sqlFilterRegArr = sqlFilterReg.split("&!&");
            addtionSqlInjectionPatterns = new Pattern[sqlFilterRegArr.length];
            for (int i = 0; i < sqlFilterRegArr.length; i++) {
                Pattern patternReg = Pattern.compile(sqlFilterRegArr[i], Pattern.CASE_INSENSITIVE);
                addtionSqlInjectionPatterns[i] = patternReg;
            }
        }

        //xss关键字
        xssFilterKeyword = properties.getProperty("xss_filter_keyword", "iframe|script");

        //xss正则表达式  patternArrXss
        String xssFilterReg = properties.getProperty("xss_filter_reg");
        if (null != xssFilterReg && xssFilterReg.length() > 0) {
            String[] xssFilterRegArr = xssFilterReg.split("&!&");
            addtionXssPatterns = new Pattern[xssFilterRegArr.length];
            for (int i = 0; i < xssFilterRegArr.length; i++) {
                Pattern patternReg = Pattern.compile(xssFilterRegArr[i], Pattern.CASE_INSENSITIVE);
                addtionXssPatterns[i] = patternReg;
            }
        }

    }

    */
/**
     * 加载忽略请求路径（即白名单，不进行合法性验证）配置文件
     *
     * @param filterConfPath
     *//*

    private void loadIgnores(String filterConfPath) {
        //白名单
        Stream<String> lines = null;
        try {
            lines = Files.lines(Paths.get(filterConfPath + File.separator + IGNORES_INI)).filter(line -> !line.startsWith("#"));
            if (null != lines) {
                violationIgnores = lines.collect(Collectors.toSet());
            } else
                violationIgnores = new HashSet<>();
        } catch (IOException e) {
            log.error("Read violation ignores failed, caused by:", e);
        }
    }

    */
/**
     * 加载拒绝请求路径（即黑名单，无法访问到）配置文件
     *
     * @param filterConfPath
     *//*

    private void loadDenies(String filterConfPath) {
        //黑名单
        Stream<String> lines = null;
        try {
            lines = Files.lines(Paths.get(filterConfPath + File.separator + DENIES_INI)).filter(line -> !line.startsWith("#"));
            if (null != lines) {
                violationDenies = lines.collect(Collectors.toSet());
            } else
                violationDenies = new HashSet<>();

        } catch (IOException e) {
            log.error("Read violation denies failed, caused by:", e);
        }
    }

    */
/**
     * 加载有额外校验需求的请求路径和校验规则配置文件
     *
     * @param filterConfPath
     *//*

    private void loadSpecialUrls(String filterConfPath) {
        //特定url
        Stream<String> specialUrlLines = null;
        try {
            specialUrlLines = Files.lines(Paths.get(filterConfPath + File.separator + SPECIAL_URLS_INI)).filter(line -> !line.startsWith("#"));
            if (null != specialUrlLines) {
                specialUrls = specialUrlLines.collect(Collectors.toSet());
            } else
                specialUrls = new HashSet<>();

        } catch (IOException e) {
            log.error("Read violation special urls failed, caused by:", e);
        }
    }

    @Override
    public void init(FilterConfig conf) throws ServletException {

        String filterConfPath;
        URL url = getClass().getClassLoader().getResource("cc-compiled/META-INF/resources/WEB-INF/_conf/commons/violation");
        File file;
        if (url != null && (file = new File(url.getFile())).exists()) {
            filterConfPath = file.getAbsolutePath();
        } else
            filterConfPath = conf.getServletContext().getRealPath("/WEB-INF/_conf/commons/violation");
        loadFilterProperties(filterConfPath);
        loadIgnores(filterConfPath);
        loadDenies(filterConfPath);
        loadSpecialUrls(filterConfPath);

        watcher = new Thread() {
            @Override
            public void run() {
                //注册监听器，实时监视配置文件变化
                try (WatchService service = FileSystems.getDefault().newWatchService()) {
                    Path path = new File(filterConfPath).toPath();
                    path.register(service, StandardWatchEventKinds.ENTRY_MODIFY);
                    boolean UPDATED = false;
                    long LAST_MOD = 0;
                    Map<String, Long> lastModifies = Collections.synchronizedMap(new HashMap<>());
                    while (true) {
                        final WatchKey wk = service.take();
                        for (WatchEvent<?> event : wk.pollEvents()) {
                            final Path changed = (Path) event.context();
                            Path absolute = path.resolve(changed);
                            File configFile = absolute.toFile();
                            String filename = configFile.getName();
                            long lastModified = configFile.lastModified();
                            log.info(lastModified + "----------------");
                            // 利用文件时间戳，防止触发两次
                            if (availableFiles.contains(filename) && lastModified - lastModifies.getOrDefault(filename, 0L) > 500) {
                                log.info("----------------- reloading -----------------");
                                lastModifies.put(filename, lastModified); // 保存上一次时间戳
                                switch (filename) {
                                    case FILTER_PROPERTIES:
                                        loadFilterProperties(filterConfPath);
                                        break;
                                    case IGNORES_INI:
                                        loadIgnores(filterConfPath);
                                        break;
                                    case DENIES_INI:
                                        loadDenies(filterConfPath);
                                        break;
                                    case SPECIAL_URLS_INI:
                                        loadSpecialUrls(filterConfPath);
                                        break;
                                }
                            }
                        }
                        // reset the key
                        boolean valid = wk.reset();
                        if (!valid) {
                            log.error("watch key invalid!");
                        }
                    }
                } catch (IOException | InterruptedException e) {
                }
            }
        };
        watcher.setDaemon(true);
        watcher.start();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        Boolean on = (Boolean) req.getServletContext().getAttribute(getClass().getName() + ".on");
        if (!enable && (on == null || !on.booleanValue())) {
            chain.doFilter(req, resp);
            return;
        }

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String servletPath = request.getServletPath();

        if (!matchIgnores(servletPath)) {
            if (matchDenies(servletPath)) {
                response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
                return;
            } else {
                Map<String, String[]> parameterMap;
                String contentType = request.getContentType();
                if ("post".equalsIgnoreCase(request.getMethod()) && contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
                    request = new StreamCachedHttpServletRequest(request);
                    parameterMap = request.getParameterMap();
                } else {
                    parameterMap = request.getParameterMap();
                }

                if (sqlInjectionSuspected(request, parameterMap) || xssSuspected(request, parameterMap) || matchSpecialUrl(request, parameterMap, servletPath)) {
                    if (MvcHelper.isAjaxRequest(request)) {
                        response.setContentType("application/json;charset=UTF-8");
                        response.sendError(422, "Potential SQL injection threat!");
                        response.flushBuffer();
                    } else {
                        response.sendError(422);
                    }
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    private boolean matchIgnores(String servletPath) {
        boolean match = false;
        if (violationIgnores.equals("*") || violationIgnores.equals("/*")) {  //路径为*全放过
            match = true;
        } else {
            for (String filterInclude : violationIgnores) {
                if (servletPath.equals(filterInclude)) {
                    match = true;
                    break;
                } else if (filterInclude.endsWith("/*")) {
                    if (servletPath.startsWith(filterInclude.substring(0, filterInclude.length() - 2) + "/")) {
                        match = true;
                        break;
                    }
                }
            }

        }
        return match;
    }

    private boolean matchDenies(String servletPath) {
        boolean match = false;
        if (violationDenies.equals("*") || violationDenies.equals("/*")) {   //路径为*全拦截
            match = true;
        } else {
            for (String filterExpire : violationDenies) {
                if (servletPath.equals(filterExpire)) {
                    match = true;
                    log.warn("URI=" + servletPath + "黑名单拦截");
                    break;
                } else if (filterExpire.endsWith("/*")) {
                    if (servletPath.startsWith(filterExpire.substring(0, filterExpire.length() - 2) + "/")) {
                        match = true;
                        log.warn("URI=" + servletPath + "黑名单拦截");
                        break;
                    }
                }
            }
        }
        return match;
    }

    private boolean sqlInjectionSuspected(HttpServletRequest request, Map<String, String[]> parameterMap) {
        boolean isGet = "get".equalsIgnoreCase(request.getMethod());
        return parameterMap.entrySet().stream().anyMatch(entry -> {
            String[] valueArray = entry.getValue();
            for (int i = 0; i < valueArray.length; i++) {
                String value = valueArray[i].toLowerCase();
                if (isGet) {
                    try {
                        value = URLDecoder.decode(value, "UTF-8");
                    } catch (Exception e) {
                        log.error("[" + request.getMethod() + "]URI=" + request.getRequestURI() + " URL:key=" + entry.getKey() + " value=" + value);
                    }
                }

                // 判断如果路径参数值中含有关键字则返回true,并且结束循环
                if (sqlInjectionPattern.matcher(value).find()) {
                    log.warn("[" + request.getMethod() + "]URI=" + request.getRequestURI() + " SQL关键字过滤:key=" + entry.getKey() + " value=" + value);
                    return true;
                }
                if (null != addtionSqlInjectionPatterns) {
                    for (Pattern patternSql : addtionSqlInjectionPatterns) {
                        if (patternSql.matcher(value).find()) {
                            log.warn("[" + request.getMethod() + "]URI=" + request.getRequestURI() + " SQL正则表达式过滤:key=" + entry.getKey() + " value=" + value);
                            return true;
                        }
                    }
                }
            }

            return false;
        });
    }

    private boolean xssSuspected(HttpServletRequest request, Map<String, String[]> parameterMap) {

        return parameterMap.entrySet().stream().anyMatch(entry -> {
            String[] valueArray = entry.getValue();
            for (int i = 0; i < valueArray.length; i++) {
                String value = valueArray[i].toLowerCase();
                //分拆关键字
                String[] inj_stra = StringUtils.split(xssFilterKeyword, "|");
                for (int j = 0; j < inj_stra.length; j++) {
                    // 判断如果路径参数值中含有关键字则返回true,并且结束循环
                    if (value.contains("<" + inj_stra[j] + ">") || value.contains("<" + inj_stra[j]) || value.contains(inj_stra[j] + ">") || value.contains(inj_stra[j] + "(") || value.contains(inj_stra[j] + "=")) {
                        log.warn("[" + request.getMethod() + "]URI=" + request.getRequestURI() + " XSS关键字过滤:" + value);
                        return true;
                    }
                }

                if (null != addtionXssPatterns) {
                    for (Pattern patternXss : addtionXssPatterns) {
                        if (patternXss.matcher(value).find()) {
                            log.warn("[" + request.getMethod() + "]URI=" + request.getRequestURI() + " XSS正则表达式过滤:" + value);
                            return true;
                        }
                    }
                }
            }
            return false;
        });
    }

    private boolean matchSpecialUrl(HttpServletRequest request, Map<String, String[]> parameterMap, String servletPath) {

        if (specialUrls == null || specialUrls.isEmpty())
            return false;

        return specialUrls.stream().map(url -> {
            String specialUrl = url.substring(0, url.indexOf("="));
            String specialReg = url.substring(url.indexOf("=") + 1);
            return new String[]{specialUrl, specialReg};
        }).filter(tuple -> StringUtils.isNotBlank(tuple[1])).filter(tuple -> servletPath.equals(tuple[0]) || tuple[0].endsWith("/*") && servletPath.startsWith(tuple[0] + "/")).anyMatch(tuple -> matchSpecialUrlPattern(tuple[1], parameterMap, request));

    }

    private boolean matchSpecialUrlPattern(String specialReg, Map<String, String[]> parameterMap, HttpServletRequest request) {
        return parameterMap.entrySet().stream().anyMatch(entry -> {
            String[] valueArray = entry.getValue();
            for (int i = 0; i < valueArray.length; i++) {
                String value = valueArray[i].toLowerCase();
                // 分拆关键字
                if (null != specialReg && specialReg != "" && specialReg.length() != 0) {
                    String[] spe_regs = StringUtils.split(specialReg, ";");
                    for (int j = 0; j < spe_regs.length; j++) {
                        // 路径参数值中含有关键字或正则则返回true,并且结束循环
                        if (value.contains(spe_regs[j])) {
                            log.warn("[" + request.getMethod() + "]URI=" + request.getRequestURI() + "特定url地址关键字过滤:" + value);
                            return true;
                        }
                    }
                }
            }
            return false;
        });
    }
}

*/
