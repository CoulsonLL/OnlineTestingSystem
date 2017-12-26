package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import entity.ScEntity;
import entity.StudentEntity;
import util.HibernateUtil;

public class ScDAO
{
    public void addSC(ScEntity scEntity)
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        session.save(scEntity);
        tx.commit();
        session.close();
    }

    public void deleteSC(ScEntity scEntity)
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        session.delete(scEntity);
        tx.commit();
        session.close();
    }

    public ScEntity queryScByStuIDAndCourseID(Integer stuID, Integer courseID)
    {
        Transaction tx = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        String hql = "from ScEntity where cCourseId = " + courseID + " and stuId = " + stuID;
        ScEntity entity = (ScEntity) session.createQuery(hql).uniqueResult();
        tx.commit();
        session.close();
        return entity;
    }

    public List<StudentEntity> queryStudentsByCourseID(Integer courseID)
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        list = session.createQuery("SELECT new StudentEntity(s.stuId,s.stuName,s.stuPwd,s.stuAge,s.stuSex,s.phoneNum,s.email) from StudentEntity s,ScEntity sc where s.stuId=sc.stuId and sc.cCourseId = " + courseID).list();
        tx.commit();
        session.close();
        return list;
    }

    public static void main(String[] args)
    {
//        ScEntity scEntity = new ScDAO().queryScByStuIDAndCourseID(3, 3);
//        System.out.println(scEntity);
        List<StudentEntity> studentEntities = new ScDAO().queryStudentsByCourseID(2);
        for (StudentEntity studentEntity : studentEntities)
        {
            System.out.println(studentEntity);
        }
    }
}
