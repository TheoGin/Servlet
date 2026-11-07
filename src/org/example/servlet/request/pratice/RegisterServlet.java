package org.example.servlet.request.pratice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pwd1 = req.getParameter("pwd1");
        String pwd2 = req.getParameter("pwd2");
        String[] sports = req.getParameterValues("sport");
        String gender = req.getParameter("gender");
        String city = req.getParameter("city");
        String info = req.getParameter("info");
        String myfile = req.getParameter("myfile");

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("注册成功<br/>");
        writer.write("用户名: " + username + "<br/>");
        writer.write("密码: " + pwd1 + "<br/>");
        writer.write("确认密码: " + pwd2 + "<br/>");
        writer.write("运动项目: ");
        for (String sport : sports) {
            writer.write(sport + ",");
        }
        writer.write("<br/>性别: " + (gender == "male" ? "男" : "女") + "<br/>");
        writer.write("城市: " + city + "<br/>");
        writer.write("自我介绍: " + info + "<br/>");

        writer.write("上传的文件: " + myfile + "<br/>");

        writer.flush();
        writer.close();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
