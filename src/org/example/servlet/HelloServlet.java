package org.example.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HelloServlet implements Servlet {
    private int count = 0;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("HelloServlet init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("HelloServlet service, count: " + count++);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if ("GET".equals(request.getMethod())) {
            doGet(servletRequest, servletResponse);
        } else if ("POST".equals(request.getMethod())) {
            doPost(servletRequest, servletResponse);
        }
    }

    private void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("HelloServlet GET request");
    }

    private void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("HelloServlet POST request");
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet destroy");
    }
}
