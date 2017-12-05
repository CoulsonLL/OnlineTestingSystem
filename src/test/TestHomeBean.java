package test;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import entity.CourseEntity;
import service.CourseService;

@Named
@RequestScoped
public class TestHomeBean
{
    private List<CourseEntity> list = null;

    public void queryAllCourses()
    {
        CourseService courseService = new CourseService();
        list = courseService.getAllCourses();
    }

    public void queryPopularList()
    {
        CourseService courseService = new CourseService();
        list = courseService.getCoursesByPopularity();
    }

    public List<CourseEntity> getList()
    {
        return list;
    }
}
