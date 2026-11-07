package org.example.servlet.request.pratice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/computer")
public class ComputerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/156.0.0.0 Safari/537.36
        Pattern pattern = Pattern.compile("\\((.*)\\)");
        String userAgent = req.getHeader("User-Agent");
        Matcher matcher = pattern.matcher(userAgent);
        matcher.find();
        String os = matcher.group(1);
        String[] osArray = os.split(";");
        System.out.println("操作系统: " + osArray[0]);
        System.out.println("位数: " + osArray[1]);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
