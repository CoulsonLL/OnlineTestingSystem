package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import entity.QuestionEntity;
import util.HibernateUtil;

@SuppressWarnings("ALL")
public class QuestionDAO
{
    public void addQuestion(QuestionEntity questionEntity)
    {
        int i = 0;
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        i = (Integer) session.save(questionEntity);
        tx.commit();
        session.close();
    }

    public void deleteQuestion(QuestionEntity questionEntity)
    {
        int i = 0;
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.delete(questionEntity);
        tx.commit();
        session.close();
    }

    public void updateQuestion(QuestionEntity questionEntity)
    {
        int i = 0;
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.update(questionEntity);
        tx.commit();
        session.close();
    }

    public List<QuestionEntity> queryQuestionsByCourseID(Integer courseID)
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        String hql = "from QuestionEntity where courseId = '" + courseID + "'";
        list = session.createQuery(hql).list();
        tx.commit();
        session.close();
        return list;
    }

    public QuestionEntity queryQuesitonByID(Integer questionID)
    {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        String hql = "from QuestionEntity where questionId = '" + questionID + "'";
        QuestionEntity entity = (QuestionEntity) session.createQuery(hql).uniqueResult();
        tx.commit();
        session.close();
        return entity;
    }
}
