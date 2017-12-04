package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import entity.CourseEntity;
import util.HibernateUtil;

@SuppressWarnings("ALL")
public class CourseDAO
{

    public void addCourse(CourseEntity course)
    {

    }

    public void deleteCourse(Integer courseID)
    {

    }

    public void updateCourse(CourseEntity course)
    {

    }

    /**
     * 根据热度查询课程列表
     *
     * @return List<CourseEntity>
     */
    public List<CourseEntity> queryCourseOrderByPopularity()
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        list = session.createQuery("from CourseEntity order by viewCount desc ").list();
        tx.commit();
        session.close();
        System.out.println(list.toString());
        return list;
    }

    /**
     * 根据ID查询课程
     *
     * @param courseID
     * @return CourseEntity
     */
    public CourseEntity queryCourseById(Integer courseID)
    {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        String hql = "from CourseEntity where cCourseId = " + courseID;
        CourseEntity entity = (CourseEntity) session.createQuery(hql).uniqueResult();
        tx.commit();
        session.close();
        System.out.println(entity);
        return entity;
    }

    /**
     * 查询所有课程
     *
     * @return List<CourseEntity>
     */
    public List<CourseEntity> queryAllCourses()
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        list = session.createQuery("from CourseEntity").list();
        tx.commit();
        session.close();
        System.out.println(list.toString());
        return list;
    }

    /**
     * 根据名称查询课程列表
     *
     * @param name
     * @return List<CourseEntity>
     */
    public List<CourseEntity> queryCoursesByName(String name)
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        String hql = "from CourseEntity where cName like '" + name + "%'";
        list = session.createQuery(hql).list();
        tx.commit();
        session.close();
        System.out.println(list.toString());
        return list;
    }


    public static void main(String[] args)
    {
        new CourseDAO().queryCoursesByName("J");
    }
}
