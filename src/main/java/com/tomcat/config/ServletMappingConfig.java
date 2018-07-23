package com.tomcat.config;

import java.util.ArrayList;
import java.util.List;

/**
 * servlet mapping config
 */
public class ServletMappingConfig {

    public static List<ServletMapping> servletMappingList = new ArrayList<ServletMapping>();

    static {
        servletMappingList.add(new ServletMapping("findGirl", "/girl", "com.tomcat.servlet.FindGirlServlet"));
        servletMappingList.add(new ServletMapping("helloWorld", "/world", "com.tomcat.servlet.HelloWorldServlet"));
    }

}
