package service;

import java.util.List;

import dao.CourseDAO;
import entity.CourseEntity;

public class CourseService
{
    public List<CourseEntity> getAllCourses()
    {
        CourseDAO courseDAO = new CourseDAO();
        return courseDAO.queryAllCourses();
    }

    public CourseEntity getCourseById(Integer courseID)
    {
        CourseDAO courseDAO = new CourseDAO();
        return courseDAO.queryCourseById(courseID);
    }

    public List<CourseEntity> getCoursesByName(String name)
    {
        CourseDAO courseDAO = new CourseDAO();
        return courseDAO.queryCoursesByName(name);
    }

    public List<CourseEntity> getCoursesByModuleID(int moduleID)
    {
        CourseDAO courseDAO = new CourseDAO();
        return courseDAO.queryCoursesByModuleID(moduleID);
    }

    public List<CourseEntity> getCoursesByPopularity()
    {
        CourseDAO courseDAO = new CourseDAO();
        return courseDAO.queryCourseOrderByPopularity();
    }

    public Integer addCourse(CourseEntity course)
    {
        CourseDAO courseDAO = new CourseDAO();
        return courseDAO.addCourse(course);
    }

    public void deleteCourse(Integer courseID)
    {
        CourseDAO courseDAO = new CourseDAO();
        courseDAO.deleteCourse(courseID);
    }

    public void updateCourse(CourseEntity course)
    {
        CourseDAO courseDAO = new CourseDAO();
        courseDAO.updateCourse(course);
    }
}
