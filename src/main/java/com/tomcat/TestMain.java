package com.tomcat;

import com.tomcat.framework.MyTomcat;

/**
 * 测试 main
 */
public class TestMain {

    public static void main (String[] args) {
        new MyTomcat(8080).start();
    }

}
