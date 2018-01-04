package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReportEntity
{
    private int reportId;
    private Integer examLogId;
    private Integer stuId;
    private Integer questionId;
    private String stem;
    private String a;
    private String b;
    private String c;
    private String d;
    private String userAnswer;
    private String rightAnswer;
    private Integer score;

    @Id
    @Column(name = "ReportID", nullable = false)
    public int getReportId()
    {
        return reportId;
    }

    public void setReportId(int reportId)
    {
        this.reportId = reportId;
    }

    @Basic
    @Column(name = "ExamLogID", nullable = true)
    public Integer getExamLogId()
    {
        return examLogId;
    }

    public void setExamLogId(Integer examLogId)
    {
        this.examLogId = examLogId;
    }

    @Basic
    @Column(name = "StuID", nullable = true)
    public Integer getStuId()
    {
        return stuId;
    }

    public void setStuId(Integer stuId)
    {
        this.stuId = stuId;
    }

    @Basic
    @Column(name = "QuestionID", nullable = true)
    public Integer getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(Integer questionId)
    {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "Stem", nullable = true, length = 200)
    public String getStem()
    {
        return stem;
    }

    public void setStem(String stem)
    {
        this.stem = stem;
    }

    @Basic
    @Column(name = "A", nullable = true, length = 200)
    public String getA()
    {
        return a;
    }

    public void setA(String a)
    {
        this.a = a;
    }

    @Basic
    @Column(name = "B", nullable = true, length = 200)
    public String getB()
    {
        return b;
    }

    public void setB(String b)
    {
        this.b = b;
    }

    @Basic
    @Column(name = "C", nullable = true, length = 200)
    public String getC()
    {
        return c;
    }

    public void setC(String c)
    {
        this.c = c;
    }

    @Basic
    @Column(name = "D", nullable = true, length = 200)
    public String getD()
    {
        return d;
    }

    public void setD(String d)
    {
        this.d = d;
    }

    @Basic
    @Column(name = "UserAnswer", nullable = true, length = 1)
    public String getUserAnswer()
    {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer)
    {
        this.userAnswer = userAnswer;
    }

    @Basic
    @Column(name = "RightAnswer", nullable = true, length = 1)
    public String getRightAnswer()
    {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer)
    {
        this.rightAnswer = rightAnswer;
    }

    @Basic
    @Column(name = "Score", nullable = true)
    public Integer getScore()
    {
        return score;
    }

    public void setScore(Integer score)
    {
        this.score = score;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReportEntity reportEntity = (ReportEntity) o;

        if (reportId != reportEntity.reportId) return false;
        if (examLogId != null ? !examLogId.equals(reportEntity.examLogId) : reportEntity.examLogId != null)
        {
            return false;
        }
        if (stuId != null ? !stuId.equals(reportEntity.stuId) : reportEntity.stuId != null)
        {
            return false;
        }
        if (questionId != null ? !questionId.equals(reportEntity.questionId) : reportEntity.questionId != null)
        {
            return false;
        }
        if (stem != null ? !stem.equals(reportEntity.stem) : reportEntity.stem != null)
        {
            return false;
        }
        if (a != null ? !a.equals(reportEntity.a) : reportEntity.a != null) return false;
        if (b != null ? !b.equals(reportEntity.b) : reportEntity.b != null) return false;
        if (c != null ? !c.equals(reportEntity.c) : reportEntity.c != null) return false;
        if (d != null ? !d.equals(reportEntity.d) : reportEntity.d != null) return false;
        if (userAnswer != null ? !userAnswer.equals(reportEntity.userAnswer) : reportEntity.userAnswer != null)
        {
            return false;
        }
        if (rightAnswer != null ? !rightAnswer.equals(reportEntity.rightAnswer) : reportEntity.rightAnswer != null)
        {
            return false;
        }
        if (score != null ? !score.equals(reportEntity.score) : reportEntity.score != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = reportId;
        result = 31 * result + (examLogId != null ? examLogId.hashCode() : 0);
        result = 31 * result + (stuId != null ? stuId.hashCode() : 0);
        result = 31 * result + (questionId != null ? questionId.hashCode() : 0);
        result = 31 * result + (stem != null ? stem.hashCode() : 0);
        result = 31 * result + (a != null ? a.hashCode() : 0);
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        result = 31 * result + (d != null ? d.hashCode() : 0);
        result = 31 * result + (userAnswer != null ? userAnswer.hashCode() : 0);
        result = 31 * result + (rightAnswer != null ? rightAnswer.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "ReportEntity{" +
                "reportId=" + reportId +
                ", examLogId=" + examLogId +
                ", stuId=" + stuId +
                ", questionId=" + questionId +
                ", stem='" + stem + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                ", userAnswer='" + userAnswer + '\'' +
                ", rightAnswer='" + rightAnswer + '\'' +
                ", score=" + score +
                '}';
    }
}
