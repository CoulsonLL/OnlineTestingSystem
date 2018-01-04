package dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import entity.CourseEntity;
import entity.ExamLogEntity;
import entity.ManagerEntity;
import entity.StudentEntity;
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
            Transaction tx = null;
            List list = null;
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("update ExamLogEntity set approvalResult = 1,mgrId = ? where examLogsId = ?");
            query.setParameter(0, managerEntity.getMgrId());
            query.setParameter(1, examLogEntity.getExamLogsId());
            query.executeUpdate();
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
            Transaction tx = null;
            List list = null;
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("update ExamLogEntity set approvalResult = -1,mgrId = ? where examLogsId = ?");
            query.setParameter(0, managerEntity.getMgrId());
            query.setParameter(1, examLogEntity.getExamLogsId());
            query.executeUpdate();
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
     * 完成考试
     *
     * @param examLogEntity 考试实体对象
     * @param managerEntity 管理员实体对象
     * @return boolean
     */
    public boolean finishExam(ExamLogEntity examLogEntity)
    {
        try
        {
            Transaction tx = null;
            List list = null;
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("update ExamLogEntity set approvalResult = 2,examEndTime = ? where examLogsId = ?");
            query.setParameter(0, new Date());
            query.setParameter(1, examLogEntity.getExamLogsId());
            query.executeUpdate();
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
    public List<ExamLogEntity> queryExamLogsByStudent(StudentEntity studentEntity)
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        Query query = session.createQuery("from ExamLogEntity where stuId = ?");
        query.setParameter(0, studentEntity.getStuId());
        list = query.list();
        tx.commit();
        session.close();
        return list;
    }

    /**
     * 查询指定课程的考试成绩排名
     *
     * @param courseEntity
     * @return List<ExamLogEntity>
     */
    public List<ExamLogEntity> getCourseRanking(CourseEntity courseEntity)
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        Query query = session.createQuery("from ExamLogEntity where examEntity.courseId = ? order by score desc");
        query.setParameter(0, courseEntity.getcCourseId());
        list = query.list();
        tx.commit();
        session.close();
        return list;
    }

    /**
     * 查询指定日期或日期范围内给定课程的考试成绩列表
     *
     * @param courseEntity
     * @return List<ExamLogEntity>
     */
    public List<ExamLogEntity> getCourseRankingWithDate(CourseEntity courseEntity, String startDate, String endDate)
    {
        Transaction tx = null;
        List list = null;
        Session session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        Query query = session.createQuery("from ExamLogEntity where examEntity.courseId = ? and examStartTime between ? and ? order by score desc");
        query.setParameter(0, courseEntity.getcCourseId());
        query.setParameter(1, startDate);
        query.setParameter(2, endDate);
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

    /**
     * 根据ID加载ExamLogEntity
     *
     * @param examLogEntity
     * @return
     */
    public ExamLogEntity getExamLogEntityByID(ExamLogEntity examLogEntity)
    {
        Session session = HibernateUtil.getSession();
        ExamLogEntity newExamLogEntity = new ExamLogEntity();
        session.load(newExamLogEntity, examLogEntity.getExamLogsId());
        session.close();
        return newExamLogEntity;
    }

    /**
     * 提交考试并进行自动批阅
     *
     * @param examLogEntity
     * @return boolean
     */
    public boolean submitExam(ExamLogEntity examLogEntity)
    {
        Transaction tx = null;
        try
        {
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery("exec OnlineTest.dbo.checkExam ?");
            query.setParameter(0, examLogEntity.getExamLogsId());
            query.executeUpdate();
            tx.commit();
            session.close();
            return true;
        }
        catch (Exception e)
        {
            tx.rollback();
            return false;
        }
    }

    public static void main(String[] args)
    {
//        System.out.println(new ExamLogDAO().queryExamLogs());
//        System.out.println(new ExamLogDAO().queryExamLogsWithDate("2017-12-22 10:30", "2017-12-22 19:00"));
        HibernateUtil.getSessionFactory();
//        StudentEntity studentEntity = new StudentEntity();
//        studentEntity.setStuId(1);
        ExamLogEntity examLogEntity = new ExamLogEntity();
        examLogEntity.setExamLogsId(2);
        new ExamLogDAO().submitExam(examLogEntity);
//        ManagerEntity managerEntity = new ManagerEntity();
//        managerEntity.setMgrId(1);
//        new ExamLogDAO().approveExam(examLogEntity, managerEntity);
//        System.out.println(new ExamLogDAO().queryExamLogsByStudent(studentEntity));
    }
}
