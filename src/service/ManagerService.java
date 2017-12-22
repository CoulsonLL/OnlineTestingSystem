package service;

import java.util.List;

import dao.ExamLogDAO;
import dao.ManagerDAO;
import dao.ScDAO;
import entity.ExamLogEntity;
import entity.ManagerEntity;
import entity.ScEntity;
import entity.StudentEntity;
import util.FacesUtil;

public class ManagerService
{
    ManagerDAO managerDAO = new ManagerDAO();
    ScDAO scDAO = new ScDAO();
    ExamLogDAO examLogDAO = new ExamLogDAO();

    /**
     * ExamLogDAO
     * <h1>修改管理员信息</h1>
     *
     * @param managerEntity 调用过setMgrPassword()的管理员实体对象
     * @return boolean
     */
    public boolean changeProfile(ManagerEntity managerEntity)
    {
        return managerDAO.updateManager(managerEntity);
    }

    /**
     * <h1>登录</h1>
     *
     * @param MgrID    管理员ID
     * @param password 密码
     * @return boolean 登录成功返回true 失败返回false
     */
    public boolean login(Integer MgrID, String password)
    {
        ManagerEntity managerEntity = managerDAO.queryManagerById(MgrID);
        if (managerEntity != null && password != null && password.equals(managerEntity.getMgrPwd()))
        {
            FacesUtil.getSession().setAttribute("mgrInfo", managerEntity);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * <h1>退出登录</h1>
     */
    public void logout()
    {
        FacesUtil.getSession().removeAttribute("mgrInfo");
    }

    /**
     * <h1>判断是否已经登录</h1>
     *
     * @return boolean
     */
    public boolean isLoggedIn()
    {
        if (FacesUtil.getSession().getAttribute("mgrInfo") != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * <h1>撤销学生的选课</h1>
     *
     * @param scEntity 选课实体
     * @return boolean true-撤销成功 false-选课不存在
     */
    public boolean cancelSelectedCourse(ScEntity scEntity)
    {
        try
        {
            scDAO.deleteSC(scEntity);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * <h1>根据课程ID查询学生列表</h1>
     *
     * @param courseID
     * @return List<StudentEntity>
     */
    public List<StudentEntity> queryStudentsByCourseID(Integer courseID)
    {
        return scDAO.queryStudentsByCourseID(courseID);
    }

    /**
     * <p1>批准考试</p1>
     *
     * @param examLogEntity 考试实体对象
     * @param managerEntity 管理员实体对象
     * @return boolean
     */
    public boolean approveExam(ExamLogEntity examLogEntity, ManagerEntity managerEntity)
    {
        return examLogDAO.approveExam(examLogEntity, managerEntity);
    }

    /**
     * <p1>拒绝考试</p1>
     *
     * @param examLogEntity 考试实体对象
     * @param managerEntity 管理员实体对象
     * @return boolean
     */
    public boolean rejectExam(ExamLogEntity examLogEntity, ManagerEntity managerEntity)
    {
        return examLogDAO.rejectExam(examLogEntity, managerEntity);
    }

    /**
     * 查询考试列表
     *
     * @return List<ExamLogEntity>
     */
    public List<ExamLogEntity> queryExamLogs()
    {
        return examLogDAO.queryExamLogs();
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
        return examLogDAO.queryExamLogsWithDate(startDate, endDate);
    }
}
