package org.example.servlet.pratice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DogServlet extends HttpServlet {
    private int countGet = 0;
    private int countPost = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        countGet++;
        System.out.println("DogServlet doGet, count: " + countGet);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        countPost++;
        System.out.println("DogServlet doPost, count: " + countPost);
    }
}
