package com.tomcat.framework;

import java.io.IOException;

/**
 * servlet 抽象封装
 */
public abstract class MyServlet {

    public abstract void doGet (MyRequest request, MyResponse response) throws IOException;

    public abstract void doPost (MyRequest request, MyResponse response) throws IOException;

    public void service (MyRequest request, MyResponse response) throws IOException {
        if (request.getMethod().equalsIgnoreCase("GET"))
            doGet(request, response);
        else if (request.getMethod().equalsIgnoreCase("POST"))
            doPost(request, response);
    }

}
