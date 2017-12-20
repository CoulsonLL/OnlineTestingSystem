package test;

import java.io.Serializable;
import java.util.Arrays;
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

    public String[] getOptions()
    {
        return options;
    }

    public void setOptions(String[] options)
    {
        this.options = options;
    }

    public void setList(List<CourseEntity> list)
    {
        this.list = list;
    }

    public HttpSession getSession()
    {
        return session;
    }

    public void setSession(HttpSession session)
    {
        this.session = session;
    }

    private String password;
    private String[] inputs = new String[10];
    private String[] options = {"A", "B", "C", "D"};

    public String[] getInputs()
    {
        return inputs;
    }

    public void setInputs(String[] inputs)
    {
        this.inputs = inputs;
    }

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

    public void showinputs()
    {
        System.out.println(Arrays.toString(inputs));
    }

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
