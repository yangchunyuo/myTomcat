package com.tomcat.servlet;

import com.tomcat.framework.MyRequest;
import com.tomcat.framework.MyResponse;
import com.tomcat.framework.MyServlet;

import java.io.IOException;

/**
 * find girl servlet impl
 */
public class FindGirlServlet extends MyServlet {

    public void doGet(MyRequest request, MyResponse response) throws IOException {
        response.writ("get girl");
    }

    public void doPost(MyRequest request, MyResponse response) throws IOException {
        response.writ("post girl");
    }
}
