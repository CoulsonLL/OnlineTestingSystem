package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import dao.ManagerDAO;
import dao.StudentDAO;
import util.HibernateUtil;

public class Servlet extends HttpServlet
{
    @Override
    public void init() throws ServletException
    {
        HibernateUtil.getSessionFactory();
        new Thread(() -> {
            for (; ; )
            {
                StudentDAO.updateStudentNum();
                ManagerDAO.updateManagerNum();
                try
                {
                    Thread.sleep(1000000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
