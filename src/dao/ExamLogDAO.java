package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import entity.ExamLogEntity;
import entity.ManagerEntity;
import util.HibernateUtil;

@SuppressWarnings("ALL")
public class ExamLogDAO
{
    /**
     * 申请考试
     *
     * @param examLogEntity 考试记录实体对象
     *                      <p>
     *                      <p>
     *                      需要设置的参数有
     *                      ExamID<br/>
     *                      StuID<br/>
     *                      Email<br/>
     *                      ExamStartTime(考试开始时间)</p>
     * @return boolean
     */
    public boolean applyForExam(ExamLogEntity examLogEntity)
    {
        try
        {
            examLogEntity.setApprovalResult(0);
            examLogEntity.setApplyTime(new Timestamp(new Date().getTime()));
            Transaction tx = null;
            List list = null;
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.save(examLogEntity);
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

    /**
     * 通过考试请求
     *
     * @param examLogEntity 考试实体对象
     * @param managerEntity 管理员实体对象
     * @return boolean
     */
    public boolean approveExam(ExamLogEntity examLogEntity, ManagerEntity managerEntity)
    {
        try
        {
            examLogEntity.setApprovalResult(1);
            examLogEntity.setMgrId(managerEntity.getMgrId());
            Transaction tx = null;
            List list = null;
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.save(examLogEntity);
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

    /**
     * 拒绝考试请求
     *
     * @param examLogEntity 考试实体对象
     * @param managerEntity 管理员实体对象
     * @return boolean
     */
    public boolean rejectExam(ExamLogEntity examLogEntity, ManagerEntity managerEntity)
    {
        try
        {
            examLogEntity.setApprovalResult(-1);
            examLogEntity.setMgrId(managerEntity.getMgrId());
            Transaction tx = null;
            List list = null;
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.save(examLogEntity);
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

    /**
     * 查询考试列表
     *
     * @return List<ExamLogEntity>
     */
    public List<ExamLogEntity> queryExamLogs()
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        list = session.createQuery("from ExamLogEntity").list();
        tx.commit();
        session.close();
        return list;
    }

    /**
     * 根据学生查询申请的考试列表
     *
     * @return List<ExamLogEntity>
     */
    public List<ExamLogEntity> queryExamLogsByStudent(ExamLogEntity examLogEntity)
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        Query query = session.createQuery("from ExamLogEntity where stuId = ?");
        query.setParameter(0, examLogEntity.getStuId());
        list = query.list();
        tx.commit();
        session.close();
        return list;
    }

    /**
     * 根据时间查询考试列表
     *
     * @param startDate 开始时间 yyyy-MM-dd HH:mm:ss
     * @param endDate   结束时间 yyyy-MM-dd HH:mm:ss
     * @return List<ExamLogEntity>
     */
    public List<ExamLogEntity> queryExamLogsWithDate(String startDate, String endDate)
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        list = session.createQuery("from ExamLogEntity where examStartTime between '" + startDate + "' and '" + endDate + "'").list();
        tx.commit();
        session.close();
        return list;
    }

    public static void main(String[] args)
    {
//        System.out.println(new ExamLogDAO().queryExamLogs());
        System.out.println(new ExamLogDAO().queryExamLogsWithDate("2017-12-22 10:30", "2017-12-22 19:00"));
    }
}
