/*
package com.demo.test.filter;

import org.apache.logging.log4j.util.Strings;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.Socket;

*/
/**
 * @author: lxw
 * @date: 2023-04-20  14:42
 *//*

public abstract class MvcHelper {

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestedWith = request.getHeader("X-Requested-With");
        return Strings.isNotBlank(requestedWith) && requestedWith.contains("XMLHttpRequest");
    }

    */
/**
     * 获取当前http服务开放的协议。通过端口检测实现，优先返回https，即如果http和https同时开放时，仅返回https
     * <b>当可以获得{@link HttpServletRequest}时，通过{@link HttpServletRequest#getScheme()}可以获取到用户访问使用的协议</b>
     * @return http|https
     *//*

    public static final String getHttpScheme() {
        if (Pangu.isRunningEmbeddedWebServer) {
            if (Strings.isNotBlank(SpringUtil.getProperty("server.ssl.key-store"))) {
                return "https";
            }
            return "http";
        }

        String httpPort = Cupid.getContextValueAs(String.class, "versionini.ports.server");
        String httpsPort = Cupid.getContextValueAs(String.class, "versionini.ports.server.ssl");

        try ( Socket socket = new Socket((String) null, Integer.parseInt(httpsPort)) ) {
            return "https";
        } catch (IOException e) {
        }

        try ( Socket socket = new Socket((String) null, Integer.parseInt(httpPort))) {
            return "http";
        } catch (IOException e) {
        }

        return "http";
    }

    public static final int getWebPort() {
        String port;
        if (Pangu.isRunningEmbeddedWebServer) {
            port = SpringUtil.getProperty("server.port");
        } else {
            port = Cupid.getContextValueAs(String.class, getHttpScheme().endsWith("s") ? "versionini.ports.server.ssl" : "versionini.ports.server");
        }
        return Strings.isNotBlank(port) ? Integer.parseInt(port) : (getHttpScheme().endsWith("s") ? 8443 : 8888);
    }

    */
/**
     * 获取Web访问路径
     * @param localhost 是否使用回环地址，为true即返回的URL中使用127.0.0.1作为地址，否则返回的URL中使用{@link ServerUtil#getServerIp()}的值作为主机地址
     * @return
     *//*

    public static final String getWebUrl(boolean localhost) {
        String host = localhost ? "127.0.0.1" : ServerUtil.getServerIp();
        return getWebUrl(host);
    }

    public static final String getContextPath() {
        if (Pangu.isRunningEmbeddedWebServer) {
            return SpringUtil.getProperty("server.servlet.context-path");
        } else {
            ServletContext servletContext = Mvcs.getServletContext(); // 从nutz取 外置tomcat，如果在Nutz Mvc初始化之前调用该工具， servletContext为空
            if (null == servletContext) { // 尝试使用spring获取servletContext，原则上通过该方法一定可以获取
                ApplicationContext applicationContext = SpringUtil.getApplicationContext();
                if (applicationContext instanceof WebApplicationContext) {
                    servletContext = ((WebApplicationContext) applicationContext).getServletContext();
                }
            }
            if (null == servletContext) // 兜底一下，从spring配置文件中获取，其实走不到，除非不用web
                return SpringUtil.getProperty("server.servlet.context-path");
            else
                return servletContext.getContextPath();
        }
    }

    */
/**
     * 使用提供的主机地址构造Web访问路径
     * @param host
     * @return
     *//*

    public static final String getWebUrl(String host) {
        String scheme = getHttpScheme();
        int port = getWebPort();
        String contextPath = getContextPath();
        return scheme + "://" + host + ":" + port + contextPath;
    }

}

*/
