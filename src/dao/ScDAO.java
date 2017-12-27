package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

import entity.CourseEntity;
import entity.ScEntity;
import entity.StudentEntity;
import util.HibernateUtil;

@SuppressWarnings("ALL")
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
        Transaction tx;
        List list;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        list = session.createQuery("SELECT new StudentEntity(s.stuId,s.stuName,s.stuPwd,s.stuAge,s.stuSex,s.phoneNum,s.email) from StudentEntity s,ScEntity sc where s.stuId=sc.stuId and sc.cCourseId = " + courseID).list();
        tx.commit();
        session.close();
        return list;
    }

    public List<CourseEntity> queryCoursesByStudent(StudentEntity studentEntity)
    {
        Transaction tx;
        List list;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        Query query = session.createQuery("SELECT new CourseEntity (c.cCourseId,c.cName,c.cModule,c.cDetail,c.mgrId,c.modifyTime,c.viewCount) from CourseEntity c,ScEntity sc where c.cCourseId = sc.cCourseId and sc.stuId = ?");
        query.setParameter(0, studentEntity.getStuId());
        list = query.list();
        tx.commit();
        session.close();
        return list;
    }

    public static void main(String[] args)
    {
//        ScEntity scEntity = new ScDAO().queryScByStuIDAndCourseID(3, 3);
//        System.out.println(scEntity);
//        List<StudentEntity> studentEntities = new ScDAO().queryStudentsByCourseID(2);
//        for (StudentEntity studentEntity : studentEntities)
//        {
//            System.out.println(studentEntity);
//        }
//    }
        HibernateUtil.getSessionFactory();
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStuId(4);
        System.out.println(new ScDAO().queryCoursesByStudent(studentEntity));
    }
}
