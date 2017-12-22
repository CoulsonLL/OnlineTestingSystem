package dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import entity.StudentEntity;
import util.HibernateUtil;

@SuppressWarnings("ALL")
public class StudentDAO
{
    private static long stuNum;

    /**
     * 添加学生
     *
     * @param student
     * @return Integer
     */
    public Integer addStudent(StudentEntity student)
    {
        int i = 0;
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        i = (Integer) session.save(student);
        tx.commit();
        session.close();
        return i;
    }

    /**
     * 删除学生
     *
     * @param studentID
     */
    public void deleteStudent(Integer studentID)
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        StudentEntity studentEntity = session.get(StudentEntity.class, studentID);
        session.delete(studentEntity);
        tx.commit();
        session.close();
    }

    /**
     * 更新学生
     *
     * @param student
     */
    public void updateStudent(StudentEntity student)
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.update(student);
        tx.commit();
        session.close();
    }

    /**
     * 查询所有学生
     *
     * @return List<StudentEntity>
     */
    public List<StudentEntity> queryAllStudents()
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        list = session.createQuery("from StudentEntity").list();
        tx.commit();
        session.close();
//        for (Object c : list)
//        {
//            System.out.println(c.toString());
//        }
        return list;
    }

    /**
     * 根据学生ID查询学生信息
     *
     * @param studentID
     * @return StudentEntity
     */
    public StudentEntity queryStudentById(Integer studentID)
    {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        String hql = "from StudentEntity where stuId = '" + studentID + "'";
        StudentEntity entity = (StudentEntity) session.createQuery(hql).uniqueResult();
        tx.commit();
        session.close();
//        System.out.println(entity);
        return entity;
    }

    /**
     * 根据学生手机号码查询学生信息
     *
     * @param studentID
     * @return StudentEntity
     */
    public StudentEntity queryStudentByPhoneNum(String PhoneNum)
    {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
//        String hql = "from StudentEntity where phoneNum = " + PhoneNum;
        String hql = "from StudentEntity where phoneNum = '" + PhoneNum + "'";
        StudentEntity entity = (StudentEntity) session.createQuery(hql).uniqueResult();
        tx.commit();
        session.close();
//        System.out.println(entity);
        return entity;
    }

    public static void updateStudentNum()
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select count(*) from [OnlineTest].[dbo].Student");
        list = query.list();
        stuNum = (int) list.get(0);
    }

    public int getStudentNum()
    {
        return (int) stuNum;
    }
}
