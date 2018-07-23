package com.tomcat.servlet;

import com.tomcat.framework.MyRequest;
import com.tomcat.framework.MyResponse;
import com.tomcat.framework.MyServlet;

import java.io.IOException;

/**
 * hello world servlet impl
 */
public class HelloWorldServlet extends MyServlet {

    public void doGet(MyRequest request, MyResponse response) throws IOException {
        response.writ("get hello world");
    }

    public void doPost(MyRequest request, MyResponse response) throws IOException {
        response.writ("post hello world");
    }
}
