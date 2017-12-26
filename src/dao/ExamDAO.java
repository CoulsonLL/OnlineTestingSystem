package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import entity.CourseEntity;
import entity.ExamEntity;
import util.HibernateUtil;

@SuppressWarnings("Duplicates")
public class ExamDAO
{

    /**
     * 添加考试
     *
     * @param examEntity
     * @return Integer
     */
    public Integer addExam(ExamEntity examEntity)
    {
        int i = 0;
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        i = (Integer) session.save(examEntity);
        tx.commit();
        session.close();
        return i;
    }

    /**
     * 删除考试
     *
     * @param examEntity
     */
    public boolean deleteExam(ExamEntity examEntity)
    {
        try
        {
            Transaction tx = null;
            List list = null;
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.delete(examEntity);
            tx.commit();
            session.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * 修改考试
     *
     * @param examEntity
     */
    public boolean modifyExam(ExamEntity examEntity)
    {
        try
        {
            Transaction tx = null;
            List list = null;
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.update(examEntity);
            tx.commit();
            session.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * 查询所有考试
     *
     * @return List<ExamEntity>
     */
    public List<ExamEntity> queryAllExams()
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        list = session.createQuery("from ExamEntity").list();
        tx.commit();
        session.close();
        return list;
    }

    /**
     * 根据名称查询考试列表
     *
     * @param courseEntity
     * @return List<ExamEntity>
     */
    public List<ExamEntity> queryExamsByCourse(CourseEntity courseEntity)
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        String hql = "from ExamEntity where courseId = " + courseEntity.getcCourseId();
        list = session.createQuery(hql).list();
        tx.commit();
        session.close();
        return list;
    }
}
