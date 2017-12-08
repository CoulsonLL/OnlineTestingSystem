package service;

import java.util.List;

import dao.StudentDAO;
import entity.StudentEntity;

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
}
