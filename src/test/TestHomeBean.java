package test;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import entity.CourseEntity;
import service.CourseService;
import util.FacesUtil;

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

    public void addSession()
    {
        HttpSession session = FacesUtil.getSession();
        session.setAttribute("text", "asdfasdfasdf");
    }

    public String getSessionString()
    {
        HttpSession session = FacesUtil.getSession();
        String s = (String) session.getAttribute("text");
        return s;
    }
}
