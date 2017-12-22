package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.WebsiteInfoEntity;
import util.HibernateUtil;

public class WebsiteInfoDAO
{
    public long getViewCount()
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

    public static void main(String[] args)
    {
        System.out.println(new WebsiteInfoDAO().getViewCount());
    }
}
