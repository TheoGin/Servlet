package org.example.servlet.pratice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/pig1", "/pig2"}, loadOnStartup = 1)
public class PigServlet extends HttpServlet {
    private int countGet = 0;
    private int countPost = 0;

    @Override
    public void init() throws ServletException {
        System.out.println("PigServlet init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        countGet++;
        System.out.println("DogServlet doGet, count: " + countGet + ", client IP: " + req.getLocalAddr());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        countPost++;
        System.out.println("DogServlet doPost, count: " + countPost + ", client IP: " + req.getLocalAddr());
    }
}
