package com.tomcat.framework;

import com.tomcat.config.ServletMapping;
import com.tomcat.config.ServletMappingConfig;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * tomcat 主程序
 */
public class MyTomcat {

    /** 监听端口 */
    private Integer port = 8080;

    /** 请求地址与servlet的对应关系 */
    private Map<String, String> urlServletMap = new HashMap<String, String>();

    public MyTomcat(Integer port) {
        this.port = port;
    }

    /**
     * 启动 tomcat
     */
    public void start () {
        // 初始化 servlet 配置
        initServletMapping();
        // socket 服务
        ServerSocket serverSocket = null;
        try {
            // 启动端口监听
            serverSocket = new ServerSocket(getPort());
            System.out.println("tomcat is start ...");
            // 无限循环 获取请求
            while (true) {
                // 获取请求
                Socket socket = serverSocket.accept();
                // 创建 request
                MyRequest request = new MyRequest(socket.getInputStream());
                // 创建 response
                MyResponse response = new MyResponse(socket.getOutputStream());
                // 请求分发
                dispatch(request, response);
                // 关闭请求流
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 初始化 servlet mapping
     */
    private void initServletMapping () {
        for (ServletMapping servletMapping : ServletMappingConfig.servletMappingList) {
            urlServletMap.put(servletMapping.getUrl(), servletMapping.getClassName());
        }
    }

    /**
     * 执行请求
     * @param request 请求封装
     * @param response 返回封装
     */
    private void dispatch (MyRequest request, MyResponse response) {
        // 获取 请求地址 对应的 servlet 类class
        String clazz = urlServletMap.get(request.getUrl());
        try {
            // 通过反射 获取 myServlet 对象
            Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
            MyServlet myServlet = myServletClass.newInstance();
            // 执行请求方法
            myServlet.service(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Map<String, String> getUrlServletMap() {
        return urlServletMap;
    }

    public void setUrlServletMap(Map<String, String> urlServletMap) {
        this.urlServletMap = urlServletMap;
    }
}
