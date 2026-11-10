package org.example.servlet.httpservletresponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseServlet")
public class ResponseServlet_ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8"); */
        // resp.setContentType("text/html; charset=UTF-8");

        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<h1>响应页面！</h1>");
        writer.flush();
        writer.close();
    }
}
