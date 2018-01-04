/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.CourseEntity;
import entity.ManagerEntity;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import service.CourseService;
import util.FacesUtil;

@SuppressWarnings("ALL")
@ManagedBean
@SessionScoped
public class ManagerCourse implements Serializable{
    private int MgrID;
    private String Name;
    private int Module;
    private String Detail;
    private int cCourseID;
    private String username;

    public int getcCourseID() {
        return cCourseID;
    }

    public void setcCourseID(int cCourseID) {
        this.cCourseID = cCourseID;
    }
 
    public int getID() {
        return MgrID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.MgrID = ID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    public int getModule() {
        return Module;
    }

    public void setModule(int Module) {
        this.Module = Module;
    }

   

    /**
     * @return the Detail
     */
    public String getDetail() {
        return Detail;
    }

    /**
     * @param Detail the Detail to set
     */
    public void setDetail(String Detail) {
        this.Detail = Detail;
    }
    
    public String jumpToModify(CourseEntity c)
    {
        this.Name = c.getcName();
        this.Module = c.getcModule();
        this.Detail = c.getcDetail();
        this.cCourseID  = c.getcCourseId();
        return "Revise";
    }
      
    
    public String addCourse(){
        CourseService s = new CourseService();
        CourseEntity ce = new CourseEntity();
        ce.setMgrId(((ManagerEntity)FacesUtil.getSession().getAttribute("mgrInfo")).getMgrId());
        ce.setcName(Name);
        ce.setcDetail(Detail);
        ce.setcModule(Module);
        ce.setModifyTime(new Timestamp(new Date().getTime()));
        s.addCourse(ce);
        
        queryAllCourses();
        return "MCourse";
    }
     public void deleteCourse(CourseEntity courseEntity){
       CourseService ss = new CourseService();
       ss.deleteCourse(courseEntity.getcCourseId());
       
       queryAllCourses();
       
    }
    public String updateCourse(){
        CourseService s = new CourseService();
        CourseEntity ce = new CourseEntity();
        ce.setcCourseId(cCourseID);
        ce.setMgrId(((ManagerEntity)FacesUtil.getSession().getAttribute("mgrInfo")).getMgrId());
        ce.setcName(Name);
        ce.setcDetail(Detail);
        ce.setcModule(Module);
        ce.setModifyTime(new Timestamp(new Date().getTime()));
        s.updateCourse(ce);
        
        queryAllCourses();
        return "MCourse";
    }
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

    public ManagerCourse()
    {
        session.setAttribute("managerCourse", this);
    }

    public void queryAllCourses()
    {
        CourseService courseService = new CourseService();
        list = courseService.getAllCourses();
    }

    public void queryPopularList()
    {
        CourseService courseService = new CourseService();
        list = courseService.getCoursesOrderedByPopularity();
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

