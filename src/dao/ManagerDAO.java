package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import entity.ManagerEntity;
import util.HibernateUtil;

@SuppressWarnings("ALL")
public class ManagerDAO
{
    public boolean updateManager(ManagerEntity managerEntity)
    {
        try
        {
            Transaction tx = null;
            List list = null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(managerEntity);
            tx.commit();
            session.close();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
