package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import entity.CourseEntity;
import util.HibernateUtil;

@SuppressWarnings("ALL")
public class CourseDAO
{

    /**
     * 添加课程
     *
     * @param course
     * @return Integer
     */
    public Integer addCourse(CourseEntity course)
    {
        int i = 0;
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        i = (Integer) session.save(course);
        tx.commit();
        session.close();
        return i;
    }

    /**
     * 删除课程
     *
     * @param courseID
     */
    public void deleteCourse(Integer courseID)
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        CourseEntity courseEntity = session.get(CourseEntity.class, courseID);
        session.delete(courseEntity);
        tx.commit();
        session.close();
    }

    /**
     * 更新课程
     *
     * @param course
     */
    public void updateCourse(CourseEntity course)
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        session.update(course);
        tx.commit();
        session.close();
    }

    /**
     * 根据热度排序查询课程列表
     *
     * @return List<CourseEntity>
     */
    public List<CourseEntity> queryCourseOrderedByPopularity()
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
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
     * 根据模块排序查询课程列表
     *
     * @return List<CourseEntity>
     */
    public List<CourseEntity> queryCourseOrderedByModule()
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        list = session.createQuery("from CourseEntity order by cModule").list();
        tx.commit();
        session.close();
//        for (Object c : list)
//        {
//            System.out.println(c.toString());
//        }
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
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        String hql = "from CourseEntity where cCourseId = " + courseID;
        CourseEntity entity = (CourseEntity) session.createQuery(hql).uniqueResult();
        tx.commit();
        session.close();
        System.out.println(entity);
        return entity;
    }

    /**
     * 根据ID查询课程名称
     *
     * @param courseID
     * @return CourseEntity
     */
    public String queryCourseNameById(Integer courseID)
    {
        Transaction tx = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        String hql = "select new CourseEntity (cCourseId,cName)from CourseEntity where cCourseId = " + courseID;
        CourseEntity entity = (CourseEntity) session.createQuery(hql).uniqueResult();
        tx.commit();
        session.close();
        return entity.getcName();
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
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        list = session.createQuery("from CourseEntity").list();
        tx.commit();
        session.close();
//        for (Object c : list)
//        {
//            System.out.println(c.toString());
//        }
        return list;
    }

    /**
     * 查询所有课程ID和Name
     *
     * @return List<CourseEntity>
     */
    public List<CourseEntity> queryAllIDsAndNames()
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        list = session.createQuery("select new CourseEntity(cCourseId,cName) from CourseEntity").list();
        tx.commit();
        session.close();
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
        Session session = HibernateUtil.getSession();
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
        Session session = HibernateUtil.getSession();
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

    /**
     * 更新viewCount
     *
     * @param courseEntity
     */
    public void updateViewCount(CourseEntity courseEntity)
    {
        Transaction tx = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        String hql = "from CourseEntity where cCourseId = " + courseEntity.getcCourseId();
        CourseEntity newCourseEntity = (CourseEntity) session.createQuery(hql).uniqueResult();
        int viewCount = newCourseEntity.getViewCount();
        newCourseEntity.setViewCount(viewCount + 1);
        session.update(newCourseEntity);
        tx.commit();
        session.close();
    }

    public static void main(String[] args)
    {
        new CourseDAO().queryCoursesByModuleID(3);
    }
}
