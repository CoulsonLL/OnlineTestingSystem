/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ExamDAO;
import entity.ExamEntity;
import entity.StudentEntity;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import service.ExamService;

/**
 *
 * @author 小龍ge
 */
@Named(value = "examination")
@RequestScoped
public class Examination {

    int examID;
    String examName;
    int duration;
    int courseID;
    int examState;
    int questionNum;
    List<ExamEntity> list;
    public int getExamID() {
        return examID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getExamState() {
        return examState;
    }

    public void setExamState(int examState) {
        this.examState = examState;
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }

    public List<ExamEntity> getList() {
        ExamService es = new ExamService();
        StudentEntity se = new StudentEntity();
        se.getStuId();
        es.queryExamsByStudent(se);
        return list;
    }

    public void setList(List<ExamEntity> list) {
        this.list = list;
    }
    
}
