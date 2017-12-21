package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
            Session session = HibernateUtil.getSessionFactory().openSession();
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
            Session session = HibernateUtil.getSessionFactory().openSession();
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
            Session session = HibernateUtil.getSessionFactory().openSession();
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
}
