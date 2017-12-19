package service;

import java.util.List;

import dao.StudentDAO;
import entity.StudentEntity;
import util.FacesUtil;

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
     * 登录
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
     * 退出登录
     *
     * @param phoneNum 手机号码
     */
    public void logout(String phoneNum)
    {
        FacesUtil.getSession().invalidate();
    }

    /**
     * 判断是否已经登录
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
     * 注册
     *
     * @param studentEntity StudentEntity对象
     * @return boolean
     */
    public boolean register(StudentEntity studentEntity) {
        if (studentEntity != null) {
            StudentEntity entity = studentDAO.queryStudentByPhoneNum(studentEntity.getPhoneNum());
            if (entity == null) {
                try {
                    addStudent(studentEntity);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        } else {
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
        StudentService studentService = new StudentService();
        studentService.updateStudent(studentEntity);
    }

    public static void main(String[] args)
    {
        StudentService studentService = new StudentService();
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setPhoneNum("18661661839");
        studentEntity.setStuAge(20);
        studentEntity.setStuName("david1");
        studentEntity.setStuPwd("1231fdg23");
        studentEntity.setStuSex("M");
//        studentService.addStudent(studentEntity);
//        StudentEntity studentEntity = studentService.getStudentById(3);
//        System.out.println(studentEntity);
        boolean res = studentService.register(studentEntity);
        System.out.println(res);
    }
}
