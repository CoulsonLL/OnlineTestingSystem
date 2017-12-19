package test;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import entity.CourseEntity;
import service.CourseService;
import util.FacesUtil;

@SuppressWarnings("ALL")
@ManagedBean
@SessionScoped
public class TestHomeBean implements Serializable
{
    private String username;
    private String password;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    private List<CourseEntity> list = null;
    private HttpSession session = FacesUtil.getSession();

    public TestHomeBean()
    {
        session.setAttribute("testHomeBean", this);
    }

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
        session = FacesUtil.getSession();
        session.setAttribute("text", "asdfasdfasdf");
    }

    public String getSessionString()
    {
        String s = (String) session.getAttribute("text");
        return s;
    }

    public String deleteRow(CourseEntity courseEntity)
    {
        System.out.println(courseEntity.toString());
        return null;
    }

    public String getSessionID()
    {
        return session.getId();
    }
}
