package service;

import java.util.List;

import dao.CourseDAO;
import dao.ScDAO;
import entity.CourseEntity;
import entity.StudentEntity;

public class CourseService
{
    CourseDAO courseDAO = new CourseDAO();
    ScDAO scDAO = new ScDAO();

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

    /**
     * 根据学生查询所有已选课程
     *
     * @param studentEntity 学生实体
     * @return List<CourseEntity>
     */
    public List<CourseEntity> queryCoursesByStudent(StudentEntity studentEntity)
    {
        return scDAO.queryCoursesByStudent(studentEntity);
    }
}
