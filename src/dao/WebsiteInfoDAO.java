package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.WebsiteInfoEntity;
import util.HibernateUtil;

public class WebsiteInfoDAO
{
    public static long getViewCount()
    {
        long viewCount;
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        String hql = "from WebsiteInfoEntity";
        WebsiteInfoEntity websiteInfoEntity = (WebsiteInfoEntity) session.createQuery(hql).uniqueResult();
        viewCount = websiteInfoEntity.getViewCount();
        websiteInfoEntity.setViewCount(viewCount + 1);
        session.update(websiteInfoEntity);
        tx.commit();
        session.close();
        return viewCount;
    }
}
