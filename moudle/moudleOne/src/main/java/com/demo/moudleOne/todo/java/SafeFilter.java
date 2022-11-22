package com.demo.moudleOne.todo.java;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SafeFilter {
    private static final Logger log = LoggerFactory.getLogger(SafeFilter.class);
    private static final String[] ALLOWED_METHODS = new String[]{"GET", "POST"};
    private static final String[] STATIC_LIST = new String[]{"js", "css", "png", "jpg", "gif", "jpeg", "bmp", "woff", "woff2", "ttf", "svg", "map"};
    private static final String sqlBadStr = "net user|xp_cmdshell|exec master.dbo.xp_cmdshell|net localgroup administrators|delete from|drop table";
    //白名单
    private String[] whitelist = {};
    //域名
    private String domainName = "";


    public SafeFilter() {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws Exception {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        StringBuffer url = request.getRequestURL();
        String path = request.getRequestURI();
        String method = request.getMethod();
        PrintWriter writer;
        if (!ArrayUtils.contains(ALLOWED_METHODS, method) || "TRACE".equals(method.toUpperCase())) {
            response.setStatus(400);
            response.setContentType("text/html;charset=UTF-8");
            writer = response.getWriter();
            writer.write("HTTP方法不安全!");
            writer.flush();
            return;
        }

        if (SqlValidatorUtil.sqlValidator(request, sqlBadStr)) {
            response.setStatus(400);
            response.setContentType("text/html;charset=UTF-8");
            writer = response.getWriter();
            writer.write("参数具有sql注入风险!");
            writer.flush();
            return;
        }


        if (this.isBadReferer(request, path)) {
            this.toError(request, response);
            return;
        }

        if (this.isBadOrigin(request, path)) {
            this.toError(request, response);
            return;
        }

        if (this.isBadHost(request)) {
            this.toError(request, response);
            return;
        }

        if (ArrayUtils.contains(this.whitelist, path)) {
            chain.doFilter(request, response);
            return;
        }

        int suffixIndex = path.lastIndexOf(".");
        if (suffixIndex >= 0) {
            String suffix = path.substring(suffixIndex + 1).toLowerCase(Locale.ENGLISH);
            if (ArrayUtils.contains(STATIC_LIST, suffix)) {
                chain.doFilter(request, response);
                return;
            }
        }

        RequestWrapper requestWrapper = new RequestWrapper(request);
        chain.doFilter(requestWrapper, res);
    }

    private boolean isBadReferer(HttpServletRequest request, String path) {
        if (!path.endsWith("sg-iot") && !path.endsWith("login.html")) {
            String referer = request.getHeader("Referer");
            if (StringUtils.isEmpty(referer)) {
                return true;
            } else {
                String[] split = referer.split("/");
                return !this.domainName.equals(split[2]);
            }
        } else {
            return false;
        }
    }

    private boolean isBadOrigin(HttpServletRequest request, String path) {
        String origin = request.getHeader("Origin");
        if (!StringUtils.isEmpty(origin)) {
            String[] split = origin.split("/");
            if (!this.domainName.equals(split[2])) {
                return true;
            }
        }

        return false;
    }

    private boolean isBadHost(HttpServletRequest request) {
        if (!this.domainName.equals(request.getHeader("host")) || !StringUtils.isNotBlank(request.getHeader("host"))) {
            return true;
        }
        return false;
    }

    private void toError(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(401);
        response.setContentType("text/html");
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("非法请求！");
        writer.flush();
    }
}
