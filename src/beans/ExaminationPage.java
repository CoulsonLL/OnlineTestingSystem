/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

import entity.ExamEntity;
import entity.ExamLogEntity;
import entity.QuestionEntity;
import entity.StudentEntity;
import entity.UserAnswerEntity;
import service.ExamService;
import util.FacesUtil;

/**
 * @author 小龍ge
 */
@ManagedBean(name = "examinationPage")
@javax.faces.bean.SessionScoped
public class ExaminationPage implements Serializable
{

    int courseID;
    int questionIndex;
    String a;
    String b;
    String c;
    String d;
    String stem;
    String scroe;
    String answer;
    List<QuestionEntity> list;
    String style;
    ExamEntity currentExam;
    ExamService es = new ExamService();
    ExamLogEntity ele;
    String[] answers;

    public String jumpToExam(ExamLogEntity examLogEntity)
    {
        System.out.println("examLogEntity=" + examLogEntity);
        ele = examLogEntity;
        FacesUtil.getSession().setAttribute("ele",examLogEntity);
        currentExam = examLogEntity.getExamEntity();
        getExaminationQuestion();
        showFirstQuestion();
        return "ExaminationPage";
    }

    public int getCourseID()
    {
        return courseID;
    }

    public void setCourseID(int courseID)
    {
        this.courseID = courseID;
    }

    public int getQuestionIndex()
    {

        return questionIndex;
    }

    public void setQuestionIndex(int questionID)
    {
        this.questionIndex = questionID;
    }

    public String getA()
    {
        return a;
    }

    public void setA(String a)
    {
        this.a = a;
    }

    public String getB()
    {
        return b;
    }

    public void setB(String b)
    {
        this.b = b;
    }

    public String getC()
    {
        return c;
    }

    public void setC(String c)
    {
        this.c = c;
    }

    public String getD()
    {
        return d;
    }

    public void setD(String d)
    {
        this.d = d;
    }

    public String getStem()
    {
        return stem;
    }

    public void setStem(String stem)
    {
        this.stem = stem;
    }

    public String getScroe()
    {
        return scroe;
    }

    public void setScroe(String scroe)
    {
        this.scroe = scroe;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public String getStyle()
    {
        return style;
    }

    public void setStyle(String style)
    {
        this.style = style;
    }

    public List<QuestionEntity> getList()
    {
        return list;
    }

    public void setList(List<QuestionEntity> list)
    {
        this.list = list;
    }

    public List<QuestionEntity> getQuestion()
    {
        return list;
    }

    public ExamEntity getCurrentExam()
    {
        return currentExam;
    }

    public void setCurrentExam(ExamEntity currentExam)
    {
        this.currentExam = currentExam;
    }

    public ExamService getEs()
    {
        return es;
    }

    public void setEs(ExamService es)
    {
        this.es = es;
    }

    public ExamLogEntity getEle()
    {
        return ele;
    }

    public void setEle(ExamLogEntity ele)
    {
        this.ele = ele;
    }

    public String[] getAnswers()
    {
        return answers;
    }

    public void setAnswers(String[] answers)
    {
        this.answers = answers;
    }

    public void getExaminationQuestion()
    {
        ExamService es = new ExamService();
        list = es.getExamQuestionsByExam(currentExam);
        answers = new String[list.size()];
        for (int i = 0; i < answers.length; i++)
        {
            answers[i] = "X";
            UserAnswerEntity uae = new UserAnswerEntity();
            uae.setExamLogsId(ele.getExamLogsId());
            StudentEntity se = (StudentEntity) FacesUtil.getSession().getAttribute("userInfo");
            uae.setStuId(se.getStuId());
            uae.setExamId(currentExam.getExamId());
            uae.setQuestionId(list.get(i).getQuestionId());
            uae.setUserAnswer("X");
            es.answerQuestion(uae);
        }
        System.out.println(list);
    }

    public void showFirstQuestion()
    {
        questionIndex = 0;
        QuestionEntity qe = list.get(questionIndex);
        stem = qe.getStem();
        a = qe.getA();
        b = qe.getB();
        c = qe.getC();
        d = qe.getD();
    }

    public void nextQuestion()
    {
        if (questionIndex < list.size() - 1 && questionIndex >= 0)
        {
            questionIndex++;
            QuestionEntity qe = list.get(questionIndex);
            stem = qe.getStem();
            a = qe.getA();
            b = qe.getB();
            c = qe.getC();
            d = qe.getD();
            answer = answers[questionIndex];
        }
    }

    public void lastQuestion()
    {
        if (questionIndex > 0 && questionIndex < list.size())
        {
            questionIndex--;
            QuestionEntity qe = list.get(questionIndex);
            stem = qe.getStem();
            a = qe.getA();
            b = qe.getB();
            c = qe.getC();
            d = qe.getD();
            answer = answers[questionIndex];
        }
    }

    public void onclick(ValueChangeEvent e)
    {
        String selected = e.getNewValue().toString();
        UserAnswerEntity uae = new UserAnswerEntity();
        uae.setExamLogsId(ele.getExamLogsId());
        StudentEntity se = (StudentEntity) FacesUtil.getSession().getAttribute("userInfo");
        uae.setStuId(se.getStuId());
        uae.setExamId(currentExam.getExamId());
        uae.setQuestionId(list.get(questionIndex).getQuestionId());
        uae.setUserAnswer(selected);
        es.answerQuestion(uae);
        answers[questionIndex] = selected;
    }

}
