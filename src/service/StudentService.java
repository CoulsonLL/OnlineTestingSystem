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

    public StudentEntity getStudentEntity(Integer studentID)
    {
        return studentDAO.queryStudentById(studentID);
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
     * @param phoneNum
     * @param password
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
            FacesUtil.getSession().invalidate();
            return false;
        }
    }

    /**
     * 退出登录
     *
     * @param phoneNum
     */
    public void logout(String phoneNum)
    {
        FacesUtil.getSession().invalidate();
    }

    /**
     * 判断是否已经登录
     *
     * @return
     */
    public boolean isLogin()
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
}
