package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import dao.ManagerDAO;
import dao.StudentDAO;

public class Servlet extends HttpServlet
{
    @Override
    public void init() throws ServletException
    {
        for (; ; )
        {
            StudentDAO.updateStudentNum();
            ManagerDAO.updateManagerNum();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
