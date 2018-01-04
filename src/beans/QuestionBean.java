/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

import entity.ExamEntity;
import entity.QuestionEntity;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import service.QuestionService;
import util.FacesUtil;

/**
 * @author Administrator
 */
@SuppressWarnings("ALL")
@ManagedBean
@SessionScoped
public class QuestionBean implements Serializable
{
    private int QuestionID;
    private int CourseID;
    private String A;
    private String B;
    private String C;
    private String D;
    private String Answer;
    private String Stem;
    private BigDecimal score;
    private List<QuestionEntity> list = null;
    private HttpSession session = FacesUtil.getSession();
    
    

    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int QuestionID) {
        this.QuestionID = QuestionID;
    }

    public HttpSession getSession()
    {
        return session;
    }

    public void setSession(HttpSession session)
    {
        this.session = session;
    }

    public List<QuestionEntity> getList()
    {
        return list;
    }

    public void setList(List<QuestionEntity> list)
    {
        this.list = list;
    }

    public QuestionBean()
    {
        queryAllquestion();
    }

    public String getSessionString()
    {
        String s = (String) session.getAttribute("text");
        return s;
    }


    public int getCourseID()
    {
        return CourseID;
    }

    public void setCourseID(int CourseID)
    {
        this.CourseID = CourseID;
    }

    public BigDecimal getScore()
    {
        return score;
    }

    public void setScore(BigDecimal score)
    {
        this.score = score;
    }

    public String getA()
    {
        return A;
    }

    public void setA(String A)
    {
        this.A = A;
    }

    public String getB()
    {
        return B;
    }

    public void setB(String B)
    {
        this.B = B;
    }

    public String getC()
    {
        return C;
    }

    public void setC(String C)
    {
        this.C = C;
    }

    public String getD()
    {
        return D;
    }

    public void setD(String D)
    {
        this.D = D;
    }

    public String getAnswer()
    {
        return Answer;
    }

    public void setAnswer(String Answer)
    {
        this.Answer = Answer;
    }

    public String getStem()
    {
        return Stem;
    }

    public void setStem(String Stem)
    {
        this.Stem = Stem;
    }


    public String addQUestion()
    {
        QuestionService s = new QuestionService();
        QuestionEntity ce = new QuestionEntity();
        ce.setCourseId(CourseID);
        ce.setStem(Stem);
        ce.setA(A);
        ce.setB(B);
        ce.setC(C);
        ce.setD(D);
        ce.setAnswer(Answer);
        ce.setScore(score);
        s.addQuestion(ce);
        queryAllquestion();
        return "Exampaper";
    }

    public void deleteQuestion(QuestionEntity questionEntity)
    {
        
        QuestionService ss = new QuestionService();
        ss.deleteQuestion(questionEntity);
        
        queryAllquestion();
    }

    public String updateQuestion()
    {
        QuestionService s = new QuestionService();
        QuestionEntity ce = new QuestionEntity();
        ce.setCourseId(CourseID);
        ce.setQuestionId(QuestionID);
        ce.setStem(Stem);
        ce.setA(A);
        ce.setB(B);
        ce.setC(C);
        ce.setD(D);
        ce.setAnswer(Answer);
        ce.setScore(score);
        s.updateQuestion(ce);
        queryAllquestion();
        return "Exampaper";
    }

    public void queryAllquestion()
    {
        QuestionService questionService = new QuestionService();
        list = questionService.queryQuestionsByCourseID(CourseID);
    }

    public String jumpToQuestionPage(ExamEntity examEntity)
    {
        System.out.println("before getID");
        CourseID = examEntity.getCourseId();
        System.out.println("after getID id="+CourseID);
        queryAllquestion();
        return "Exampaper";
    }
    
    public String jumpToUpdate(QuestionEntity c)
    {
        this.CourseID=c.getCourseId();
        this.QuestionID = c.getQuestionId();
        this.Stem = c.getStem();
        this.A = c.getA();
        this.B = c.getB();
        this.C = c.getC();
        this.D = c.getD();
        this.Answer = c.getAnswer();
        this.score = c.getScore();
        return "UpdateQuestion";
    }
}
