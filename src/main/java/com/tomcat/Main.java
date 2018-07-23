package com.tomcat;

/**
 * 测试 主方法
 */
public class Main {

    public static void main (String[] args) {

        int i = 12;
        System.out.println(i + ":" + Integer.toBinaryString(i));

        i = i << 3;
        System.out.println(i + ":" + Integer.toBinaryString(i));

        i = i >> 2;
        System.out.println(i + ":" + Integer.toBinaryString(i));

    }

}
