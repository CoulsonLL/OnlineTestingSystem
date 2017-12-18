package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StudentService;

@WebServlet(name = "TestServlet", urlPatterns = "/testServlet")
public class TestServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        String type = request.getParameter("type");
        if (type.equals("login"))
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            StudentService studentService = new StudentService();
            if (studentService.login(username, password))
            {
                out.print("OK");
            }
            else
            {
                out.print("WRONG");
            }
        }
        else if (type.equals("register"))
        {
            //获取注册相关表单的信息然后判断并向用户返回结果
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
//请不要修改此处
//        TestHomeBean testHomeBean = (TestHomeBean) request.getSession().getAttribute("testHomeBean");
//        testHomeBean.setUsername(username);
//        testHomeBean.setPassword(password);
//        System.out.println(testHomeBean.getUsername());
//        System.out.println(testHomeBean.getPassword());
//请不要修改此处
