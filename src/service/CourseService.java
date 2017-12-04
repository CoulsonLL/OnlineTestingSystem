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

    public List<CourseEntity> getCoursesByPopularity()
    {
        CourseDAO courseDAO = new CourseDAO();
        return courseDAO.queryCourseOrderByPopularity();
    }
}
