package test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.List;

import util.HibernateUtil;

public class HibernateTest
{
    public static void main(String[] args)
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        list = session.createQuery("select s.stuName,c.cName from CourseEntity c,ScEntity sc,StudentEntity s where c.cCourseId=sc.cCourseId and sc.stuId=s.stuId").list();
        for (Object[] objects : (List<Object[]>) list)
        {
            System.out.println(Arrays.toString(objects));
        }
        tx.commit();
        session.close();
    }
}
