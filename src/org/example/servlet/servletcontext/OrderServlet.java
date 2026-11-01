package org.example.servlet.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        // System.out.println("OrderServlet servletContext: " + servletContext);

        Object visitCount = servletContext.getAttribute("visitCount");
        if (visitCount == null) {
            visitCount = 1;
            servletContext.setAttribute("visitCount", visitCount);
        } else {
            int count = (int) visitCount;
            count++;
            visitCount = count;
            servletContext.setAttribute("visitCount", count);
        }
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        writer.write("Visit Count: " + visitCount);

        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
