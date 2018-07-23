package com.tomcat.config;

/**
 * servlet mapping 封装
 */
public class ServletMapping {

    /** servlet 名称 */
    private String servletName;

    /** servlet 监听的 请求地址 */
    private String url;

    /** servlet 类的 class 值 */
    private String className;

    public ServletMapping(String servletName, String url, String className) {
        this.servletName = servletName;
        this.url = url;
        this.className = className;
    }

    public String getServletName() {
        return servletName;
    }

    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
