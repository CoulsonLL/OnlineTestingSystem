package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import entity.UserAnswerEntity;
import util.HibernateUtil;

public class UserAnswerDAO
{
    public boolean addUserAnswer(UserAnswerEntity userAnswerEntity)
    {
        try
        {
            Transaction tx = null;
            List list = null;
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
}
