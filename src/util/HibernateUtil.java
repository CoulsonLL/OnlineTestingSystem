package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
    private static SessionFactory sessionFactory;

    private HibernateUtil()
    {

    }

    /**
     * 获取会话工厂
     *
     * @return 会话工厂
     */
    public static SessionFactory getSessionFactory()
    {
        //第一步：读取Hibernate的配置文件 hibernate.cfg.xml文件
        Configuration con = new Configuration().configure();
//        第二步：创建服务注册构建器对象，通过配置对象加载所有的配置信息
//        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        //第三步：创建会话工厂
//        sessionFactory = con.buildSessionFactory(standardServiceRegistry);
        sessionFactory = con.buildSessionFactory();
        return sessionFactory;
    }

    /**
     * 获取会话
     *
     * @return 会话
     */
    public static Session getSession()
    {
        return sessionFactory.openSession();
    }
}
