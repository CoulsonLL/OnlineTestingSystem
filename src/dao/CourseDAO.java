package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import entity.CourseEntity;
import util.HibernateUtil;

@SuppressWarnings("ALL")
public class CourseDAO
{

    public Integer addCourse(CourseEntity course)
    {
        int i = 0;
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        i = (Integer) session.save(course);
        tx.commit();
        session.close();
        return i;
    }

    public void deleteCourse(Integer courseID)
    {
        int i = 0;
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        CourseEntity courseEntity = session.get(CourseEntity.class, courseID);
        session.delete(courseEntity);
        tx.commit();
        session.close();
    }

    public void updateCourse(CourseEntity course)
    {
        int i = 0;
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.update(course);
        tx.commit();
        session.close();
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
        for (Object c : list)
        {
            System.out.println(c.toString());
        }
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
//        System.out.println(list.toString());
        for (Object c : list)
        {
            System.out.println(c.toString());
        }
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
        String hql = "from CourseEntity where cName like '%" + name + "%'";
        list = session.createQuery(hql).list();
        tx.commit();
        session.close();
        for (Object c : list)
        {
            System.out.println(c.toString());
        }
        return list;
    }

    /**
     * 根据模块编号查询相应课程
     *
     * @param moduleID
     * @return List<CourseEntity>
     */
    public List<CourseEntity> queryCoursesByModuleID(int moduleID)
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        String hql = "from CourseEntity where cModule = " + moduleID;
        list = session.createQuery(hql).list();
        tx.commit();
        session.close();
        for (Object c : list)
        {
            System.out.println(c.toString());
        }
        return list;
    }


    public static void main(String[] args)
    {
        new CourseDAO().queryCoursesByModuleID(3);
    }
}
