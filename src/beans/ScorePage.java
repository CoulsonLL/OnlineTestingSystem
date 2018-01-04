package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entity.ExamLogEntity;
import entity.ReportEntity;
import service.ExamService;
import util.FacesUtil;

@ManagedBean
@SessionScoped
public class ScorePage
{
    private double score;
    private List<ReportEntity> reportList = new ArrayList<>();

    public double getScore()
    {
        return score;
    }

    public void setScore(double score)
    {
        this.score = score;
    }

    public List<ReportEntity> getReportList()
    {
        return reportList;
    }

    public void setReportList(List<ReportEntity> reportList)
    {
        this.reportList = reportList;
    }

    public String getScoreAndReport(ExamLogEntity examLogEntity)
    {
        ExamService examService = new ExamService();
        score = examService.getScore(examLogEntity);
        System.out.println("examLogEntity:"+examLogEntity);
        reportList = examService.getReport(examLogEntity);
        System.out.println(reportList);
        FacesUtil.getSession().removeAttribute("ele");
        return "ScorePage";
    }

    public String checkGrades(ExamLogEntity examLogEntity)
    {
        return getScoreAndReport(examLogEntity);
    }

    public String submit()
    {
        System.out.println("submit!!!");
        ExamLogEntity examLogEntity = (ExamLogEntity) FacesUtil.getSession().getAttribute("ele");
        System.out.println("examLogEntity examLogEntity examLogEntity:"+examLogEntity);
        ExamService examService = new ExamService();
        examService.submitExam(examLogEntity);
        return getScoreAndReport(examLogEntity);
    }
}
