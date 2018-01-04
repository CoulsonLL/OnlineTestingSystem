/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import entity.ExamLogEntity;
import entity.StudentEntity;
import service.StudentService;
import util.FacesUtil;

/**
 * @author 小龍ge
 */
@Named(value = "examinationApplied")
@RequestScoped
public class ExaminationApplied
{

    int examId;
    String examName;
    int duration;
    int courseID;
    int examState;
    int questionNum;
    List<ExamLogEntity> list;

    public int getExamId()
    {
        return examId;
    }

    public void setExamId(int examId)
    {
        this.examId = examId;
    }

    public String getExamName()
    {
        return examName;
    }

    public void setExamName(String examName)
    {
        this.examName = examName;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public int getCourseID()
    {
        return courseID;
    }

    public void setCourseID(int courseID)
    {
        this.courseID = courseID;
    }

    public int getExamState()
    {
        return examState;
    }

    public void setExamState(int examState)
    {
        this.examState = examState;
    }

    public int getQuestionNum()
    {
        return questionNum;
    }

    public void setQuestionNum(int questionNum)
    {
        this.questionNum = questionNum;
    }

    public List<ExamLogEntity> getList()
    {
        StudentService ss = new StudentService();
        StudentEntity se = (StudentEntity) FacesUtil.getSession().getAttribute("userInfo");
        list = ss.queryExamLogsByStudent(se);
        return list;
    }

    public void setList(List<ExamLogEntity> list)
    {
        this.list = list;
    }

    public void getExamDetail(ExamLogEntity examLogEntity)
    {

    }

}
