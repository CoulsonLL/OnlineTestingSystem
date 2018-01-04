/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.CourseEntity;
import entity.ExamLogEntity;
import entity.ManagerEntity;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.servlet.http.HttpSession;
import service.ManagerService;
import util.FacesUtil;
import static util.MailUtil.sendHtmlMail;

/**
 *
 * @author 小龍ge
 */
@ManagedBean(name = "Apply")
@RequestScoped
public class Apply {

    private int examId;
    private int stuId;
    private String email;
    private String applyTime;
    private String examStartTime;
    private String examEndTime;
    private List<ExamLogEntity> list = null;
    private HttpSession session = FacesUtil.getSession();
    
    

    public int getexamId() {
        return examId;
    }

    public void setexamId(int examId) {
        this.examId = examId;
    }

    public int getstuId() {
        return stuId;
    }

    public void setstuId(int stuId) {
        this.stuId = stuId;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String Email) {
        this.email = Email;
    }

    public String getapplyTime() {
        return applyTime;
    }

    public void setapplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getexamStartTime() {
        return examStartTime;
    }

    public void setexamStartTime(String examStartTime) {
        this.examStartTime = examStartTime;
    }

    public String getexamEndTime() {
        return examEndTime;
    }

    public void setexamEndTime(String examEndTime) {
        this.examEndTime = examEndTime;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public void setList(List<ExamLogEntity> list) {
        this.list = list;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    private String password;
    private String[] inputs = new String[10];
    private String[] options = {"A", "B", "C", "D"};

    public String[] getInputs() {
        return inputs;
    }

    public void setInputs(String[] inputs) {
        this.inputs = inputs;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void showinputs() {
        System.out.println(Arrays.toString(inputs));
    }

    public Apply() {
        queryExamLogs();
    }

    public List<ExamLogEntity> getList() {
        return list;
    }

    public String getSessionString() {
        String s = (String) session.getAttribute("text");
        return s;
    }

    public String deleteRow(CourseEntity courseEntity) {
        System.out.println(courseEntity.toString());
        return null;
    }

    public String getSessionID() {
        return session.getId();
    }

    public void queryExamLogs() {
        session = FacesUtil.getSession();
        ManagerService managerService = new ManagerService();
        list = managerService.queryExamLogs();
    }

    public void approveExam(ExamLogEntity ele) {
        session = FacesUtil.getSession();
        ManagerEntity ssEntity = (ManagerEntity) FacesUtil.getSession().getAttribute("mgrInfo");
        System.out.println(ssEntity);
        ManagerService c = new ManagerService();
        sendHtmlMail(ele.getEmail(), "Result", "You can take an exam");
        c.approveExam(ele, ssEntity);
        queryExamLogs();
    }

    public void rejectExam(ExamLogEntity ele) {
        session = FacesUtil.getSession();
        ManagerEntity ssEntity = (ManagerEntity) FacesUtil.getSession().getAttribute("mgrInfo");
        ManagerService c = new ManagerService();
        System.out.println(ssEntity);
        sendHtmlMail(ele.getEmail(), "Result", "You can't take an exam");
        c.rejectExam(ele, ssEntity);
        queryExamLogs();
    }

}

/*ManagerEntity ssEntity = (ManagerEntity) FacesUtil.getSession().getAttribute("mgrInfo");
        ManagerService c = new ManagerService();*/
