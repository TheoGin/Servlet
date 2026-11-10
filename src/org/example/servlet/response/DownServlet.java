package org.example.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/down")
public class DownServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String contextPath = req.getContextPath();
        /* resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        resp.setHeader("Location", contextPath + "/downNew"); */
        resp.sendRedirect(contextPath + "/downNew");
        // resp.sendRedirect("https://www.baidu.com/");

       /*  resp.setContentType("application/x-tar;charset=UTF-8"); // tar 压缩包
        System.out.println("DownServlet 被调用.. 下载文件"); */
    }
}
