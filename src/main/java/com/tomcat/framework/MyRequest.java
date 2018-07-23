package com.tomcat.framework;

import java.io.IOException;
import java.io.InputStream;

/**
 * request 请求封装
 */
public class MyRequest {

    /** 请求地址 */
    private String url;

    /** 请求方法名 */
    private String method;

    /**
     * 构造方法 传入 请求流 封装request对象
     * @param inputStream 请求流
     * @throws IOException IO异常
     */
    public MyRequest (InputStream inputStream) throws IOException {

//      GET /girl HTTP/1.1
//      Host: localhost:8080
//      User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0
//      Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
//      Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
//      Accept-Encoding: gzip, deflate
//      Connection: keep-alive
//      Upgrade-Insecure-Requests: 1

        // 获取 请求流 字符
        String httpRequest = inputStreamToString(inputStream);
        String httpHead = httpRequest.split("\n")[0];
        setUrl(httpHead.split("\\s")[1]);
        setMethod(httpHead.split("\\s")[0]);
        System.out.println(this);
    }

    /**
     * inputStream 转 string
     * @param inputStream 字符流
     * @return
     * @throws IOException
     */
    private String inputStreamToString (InputStream inputStream) throws IOException {
        byte[] bytes = new byte[4096];
        Integer length = inputStream.read(bytes);
        return new String(bytes, 0, length);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
