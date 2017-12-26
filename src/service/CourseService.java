package service;

import java.util.List;

import dao.CourseDAO;
import entity.CourseEntity;

public class CourseService
{
    CourseDAO courseDAO = new CourseDAO();

    public List<CourseEntity> getAllCourses()
    {
        return courseDAO.queryAllCourses();
    }

    public CourseEntity getCourseById(Integer courseID)
    {
        return courseDAO.queryCourseById(courseID);
    }

    public String queryCourseNameById(Integer courseID)
    {
        return courseDAO.queryCourseNameById(courseID);
    }

    public List<CourseEntity> getCoursesByName(String name)
    {
        return courseDAO.queryCoursesByName(name);
    }

    public List<CourseEntity> getCoursesByModuleID(int moduleID)
    {
        return courseDAO.queryCoursesByModuleID(moduleID);
    }

    public List<CourseEntity> getCoursesOrderedByPopularity()
    {
        return courseDAO.queryCourseOrderedByPopularity();
    }

    public Integer addCourse(CourseEntity course)
    {
        return courseDAO.addCourse(course);
    }

    public void deleteCourse(Integer courseID)
    {
        courseDAO.deleteCourse(courseID);
    }

    public void updateCourse(CourseEntity course)
    {
        courseDAO.updateCourse(course);
    }

    /**
     * 更新viewCount
     *
     * @param courseEntity
     */
    public void updateViewCount(CourseEntity courseEntity)
    {
        courseDAO.updateViewCount(courseEntity);
    }

    /**
     * 查询所有课程ID和Name
     *
     * @return List<CourseEntity>
     */
    public List<CourseEntity> queryAllIDsAndNames()
    {
        return courseDAO.queryAllIDsAndNames();
    }
}
