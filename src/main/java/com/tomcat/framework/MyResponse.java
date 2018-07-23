package com.tomcat.framework;

import java.io.IOException;
import java.io.OutputStream;

/**
 * response 返回封装
 */
public class MyResponse {

    /** 返回流 */
    private OutputStream outputStream;

    /**
     * 返回内容
     * @param content
     * @throws IOException
     */
    public void writ (String content) throws IOException {
        StringBuffer httpResponse = new StringBuffer();
        httpResponse
                .append("HTTP/1.1 200 OK\n")
                .append("Content-Type: text/html\n")
                .append("\r\n")
                .append("<html><body>")
                .append(content)
                .append("</body></html>");
        outputStream.write(httpResponse.toString().getBytes());
        outputStream.close();
    }

    public MyResponse (OutputStream outputStream) {
        setOutputStream(outputStream);
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
