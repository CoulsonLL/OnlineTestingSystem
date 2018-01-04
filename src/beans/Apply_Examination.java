/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Timestamp;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import dao.ExamDAO;
import entity.ExamEntity;
import entity.ExamLogEntity;
import entity.StudentEntity;
import service.StudentService;
import util.FacesUtil;

import static util.MailUtil.sendHtmlMail;

/**
 * @author 小龍ge
 */
@Named(value = "apply_Examination")
@RequestScoped
public class Apply_Examination
{
    int ExamID;
    int StuID;
    String Email;
    String ApplyTime;
    String ExamStartTime;
    String ExamEndTime;
    List<ExamEntity> list;

    public int getExamID()
    {
        return ExamID;
    }

    public void setExamID(int ExamID)
    {
        this.ExamID = ExamID;
    }

    public int getStuID()
    {
        return StuID;
    }

    public void setStuID(int StuID)
    {
        this.StuID = StuID;
    }

    public String getEmail()
    {
        return Email;
    }

    public void setEmail(String Email)
    {
        this.Email = Email;
    }

    public String getApplyTime()
    {
        return ApplyTime;
    }

    public void setApplyTime(String ApplyTime)
    {
        this.ApplyTime = ApplyTime;
    }

    public String getExamStartTime()
    {
        return ExamStartTime;
    }

    public void setExamStartTime(String ExamStartTime)
    {
        this.ExamStartTime = ExamStartTime;
    }

    public String getExamEndTime()
    {
        return ExamEndTime;
    }

    public void setExamEndTime(String ExamEndTime)
    {
        this.ExamEndTime = ExamEndTime;
    }

    public List<ExamEntity> getList()
    {
        ExamDAO edao = new ExamDAO();
        StudentEntity se = (StudentEntity) FacesUtil.getSession().getAttribute("userInfo");
        list = edao.queryExamsByStudent(se);
        return list;
    }

    public void setList(List<ExamEntity> list)
    {
        this.list = list;
    }


    public void sendMessage()
    {
        StudentEntity se = (StudentEntity) FacesUtil.getSession().getAttribute("userInfo");
        sendHtmlMail("756572145@qq.com", "aaa", "Email ID:" + getEmail() + "<br/>" + "<hr/>" + "Student ID:" + se.getStuId() + "<br/>" + "<hr/>" + "Apply Time:" + getApplyTime() + "<br/>" + "<hr/>"
                + "Exam Start Time:" + getExamStartTime() + "<br/>" + "<hr/>" + "Exam End Time:" + getExamEndTime());
        StudentService ss = new StudentService();
        ExamLogEntity ele = new ExamLogEntity();
        ele.setExamId(ExamID);
        ele.setStuId(se.getStuId());
        ele.setEmail(Email);
        System.out.println(ExamStartTime);
        ele.setExamStartTime(Timestamp.valueOf(ExamStartTime));
        ss.applyForExam(ele);
    }
}
