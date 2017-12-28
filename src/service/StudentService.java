package service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import dao.ExamLogDAO;
import dao.ScDAO;
import dao.StudentDAO;
import entity.CourseEntity;
import entity.ExamLogEntity;
import entity.ScEntity;
import entity.StudentEntity;
import util.FacesUtil;
import util.HibernateUtil;

public class StudentService
{
    StudentDAO studentDAO = new StudentDAO();

    public List<StudentEntity> getAllStudents()
    {
        return studentDAO.queryAllStudents();
    }

    public StudentEntity getStudentById(Integer studentID)
    {
        return studentDAO.queryStudentById(studentID);
    }

    public Integer addStudent(StudentEntity student)
    {
        return studentDAO.addStudent(student);
    }

    public void deleteStudent(Integer studentID)
    {
        studentDAO.deleteStudent(studentID);
    }

    public void updateStudent(StudentEntity student)
    {
        studentDAO.updateStudent(student);
    }

    public StudentEntity getStudentByPhoneNum(String PhoneNum)
    {
        return studentDAO.queryStudentByPhoneNum(PhoneNum);
    }

    /**
     * <h1>登录</h1>
     *
     * @param phoneNum 手机号码
     * @param password 密码
     * @return boolean 登录成功返回true 失败返回false
     */
    public boolean login(String phoneNum, String password)
    {
        StudentEntity studentEntity = studentDAO.queryStudentByPhoneNum(phoneNum);
        if (studentEntity != null && password != null && password.equals(studentEntity.getStuPwd()))
        {
            FacesUtil.getSession().setAttribute("userInfo", studentEntity);
            return true;
        }
        else
        {
//            FacesUtil.getSession().invalidate();
            return false;
        }
    }

    /**
     * <h1>退出登录</h1>
     */
    public void logout()
    {
        FacesUtil.getSession().removeAttribute("userInfo");
    }

    /**
     * <h1>判断是否已经登录</h1>
     *
     * @return boolean
     */
    public boolean isLoggedIn()
    {
        if (FacesUtil.getSession().getAttribute("userInfo") != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * <h1>注册</h1>
     *
     * @param studentEntity StudentEntity对象
     * @return boolean
     */
    public boolean register(StudentEntity studentEntity)
    {
        if (studentEntity != null)
        {
            StudentEntity entity = studentDAO.queryStudentByPhoneNum(studentEntity.getPhoneNum());
            if (entity == null)
            {
                try
                {
                    addStudent(studentEntity);
                    return true;
                }
                catch (Exception e)
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * <h1>修改学生信息</h1>
     * <p>先使用StudentEntity se = FacesUtil.getSession().setAttribute("userInfo", studentEntity);获取当前学生信息<br/>
     * 然后调用se.setXXX();设定相关属性<br/>
     * 设定完成后调用本函数 传入修改过的StudentEntity对象即可</p>
     *
     * @param studentEntity 修改过的StudentEntity对象
     */
    public void updateStudentProfile(StudentEntity studentEntity)
    {
        studentDAO.updateStudent(studentEntity);
    }

    /**
     * <h1>学生选课</h1>
     *
     * @param studentEntity 学生实体
     * @param courseEntity  课程实体
     * @return boolean true-选课成功 false-课程已选择
     */
    public boolean selectCourse(StudentEntity studentEntity, CourseEntity courseEntity)
    {
        ScDAO scDAO = new ScDAO();
        //判断是否选课
        ScEntity scEntity = scDAO.queryScByStuIDAndCourseID(studentEntity.getStuId(), courseEntity.getcCourseId());
        if (scEntity == null)
        {
            scEntity = new ScEntity(studentEntity.getStuId(), courseEntity.getcCourseId(), 0);//0代表刚刚选课
            try
            {
                scDAO.addSC(scEntity);
                return true;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return false;
            }
        }
        else
        {
            return false;
        }
    }

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
        ExamLogDAO examLogDAO = new ExamLogDAO();
        return examLogDAO.applyForExam(examLogEntity);
    }

    /**
     * 获取学生数量
     *
     * @return int 学生数量
     */
    public int getStudentNum()
    {
        return studentDAO.getStudentNum();
    }

    public static void main(String[] args)
    {
//        StudentService studentService = new StudentService();
//        StudentEntity studentEntity = new StudentEntity();
//        studentEntity.setPhoneNum("18661661839");
//        studentEntity.setStuAge(20);
//        studentEntity.setStuName("david1");
//        studentEntity.setStuPwd("1231fdg23");
//        studentEntity.setStuSex("M");
////        studentService.addStudent(studentEntity);
////        StudentEntity studentEntity = studentService.getStudentById(3);
////        System.out.println(studentEntity);
//        boolean res = studentService.register(studentEntity);
//        System.out.println(res);
        HibernateUtil.getSessionFactory();
        ExamLogEntity examLogEntity = new ExamLogEntity();
        examLogEntity.setExamId(1);
        examLogEntity.setStuId(2);
        examLogEntity.setExamStartTime(new Timestamp(new Date().getTime()));
        examLogEntity.setEmail("550361254@qqqq.com");
        new StudentService().applyForExam(examLogEntity);
    }
}
