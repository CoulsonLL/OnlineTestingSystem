package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.UserAnswerEntity;
import util.HibernateUtil;

@SuppressWarnings("Duplicates")
public class UserAnswerDAO
{
    public boolean addUserAnswer(UserAnswerEntity userAnswerEntity)
    {
        try
        {
            Transaction tx;
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.save(userAnswerEntity);
            tx.commit();
            session.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean updateUserAnswer(UserAnswerEntity userAnswerEntity)
    {
        try
        {
            Transaction tx;
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.update(userAnswerEntity);
            tx.commit();
            session.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean isOptionAlreadyExist(int examLogsID, int questionID)
    {
        Transaction tx;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        Query query = session.createQuery("from UserAnswerEntity where examLogsId = ? and questionId = ?");
        query.setParameter(0, examLogsID);
        query.setParameter(1, questionID);
        UserAnswerEntity entity = (UserAnswerEntity) query.uniqueResult();
        tx.commit();
        session.close();
        return entity != null;
    }
}
