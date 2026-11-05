package org.example.servlet.httpservletrequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestMethods")
public class HttpServletRequestMethods extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.println("Request URI: " + req.getRequestURI());
        System.out.println("Request URL: " + req.getRequestURL());
        System.out.println("Request Header - Host: " + req.getHeader("Host"));
        System.out.println("Request Header - Referer: " + req.getHeader("Referer"));
        System.out.println("Request Header - getMethod: " + req.getMethod());
        System.out.println("Request Header - User-Agent: " + req.getHeader("User-Agent")); // Request Header - User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/156.0.0.0 Safari/537.36

        // 取出访问的浏览器
        String userAgent = req.getHeader("User-Agent");
        String[] userAgents = userAgent.split(" ");
        String browser = userAgents[userAgents.length - 2].split("/")[0];
        System.out.println("Browser: " + browser);

        //练习: 要求取出 Windows NT 10.0 和Win64
        System.out.println("os: " + userAgents[1].replace("(", "") + " " + userAgents[2] + " " + userAgents[3].replace(";", ""));
        System.out.println("os bit num: " + userAgents[4].replace(";", ""));

        System.out.println("Request Parameter - username: " + req.getParameter("username"));
        System.out.println("Request Parameter - pwd: " + req.getParameter("pwd"));

        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println("Request Parameter - hobby: " + hobby);
        }

        System.out.println("req.getRemoteAddr(): " + req.getRemoteAddr());

        // req.getRequestDispatcher()

        // 请想办法获取到JSESSIONID 的值.
        Cookie[] cookies = req.getCookies();
        Cookie JSESSIONIDCookie = cookies[0];
        System.out.println(JSESSIONIDCookie.getName() + ": " + JSESSIONIDCookie.getValue()); // JSESSIONID: EDED4003F275CD9272C8F5D789D5B336
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
