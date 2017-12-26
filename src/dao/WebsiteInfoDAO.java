package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.WebsiteInfoEntity;
import util.HibernateUtil;

public class WebsiteInfoDAO
{
    private static long viewCount;

    public void updateViewCount()
    {
        Transaction tx = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        String hql = "from WebsiteInfoEntity";
        WebsiteInfoEntity websiteInfoEntity = (WebsiteInfoEntity) session.createQuery(hql).uniqueResult();
        viewCount = websiteInfoEntity.getViewCount();
        websiteInfoEntity.setViewCount(viewCount + 1);
        session.update(websiteInfoEntity);
        tx.commit();
        session.close();
    }

    public long getViewCount()
    {
        new Thread(this::updateViewCount).start();
        return viewCount;
    }

    public static void main(String[] args)
    {
        System.out.println(new WebsiteInfoDAO().getViewCount());
    }
}
