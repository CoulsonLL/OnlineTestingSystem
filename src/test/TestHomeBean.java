package test;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import entity.CourseEntity;
import service.CourseService;
import util.FacesUtil;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class TestHomeBean implements Serializable
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

    public String deleteRow(CourseEntity courseEntity)
    {
        System.out.println(courseEntity.toString());
        return null;
    }
}
