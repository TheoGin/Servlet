package org.example.servlet.annotation;

import javax.servlet.Servlet;
import javax.servlet.annotation.WebServlet;
import java.util.HashMap;

public class SimpleImplAnnotationServlet {
    private static HashMap<String, Servlet> servletMapping = new HashMap<>();

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String classPath = "org.example.servlet.annotation.OkServlet";
        Class<?> clazz = Class.forName(classPath);
        OkServlet okServlet = (OkServlet) clazz.newInstance();
        WebServlet webServlet = clazz.getDeclaredAnnotation(WebServlet.class);
        String[] urls = webServlet.urlPatterns();

        for (String url : urls) {
            System.out.println(url);
        }

        servletMapping.put(urls[0], okServlet);
        System.out.println(servletMapping);
    }
}
