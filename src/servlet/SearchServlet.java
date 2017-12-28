package servlet;

import util.FacesUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter p = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        String buzzword = request.getParameter("user-input");
        request.getSession().setAttribute("search-word",buzzword);
        String hello = (String) request.getSession().getAttribute("search-word");
        System.out.println(hello);

        p.write("true");
        p.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
//    public static void main(String[] args){
//        System.out.println(FacesUtil.getSession().getAttribute("search-word"));
//    }
}
