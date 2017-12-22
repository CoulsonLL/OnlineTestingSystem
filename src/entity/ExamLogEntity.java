package entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ExamLog", schema = "dbo", catalog = "OnlineTest")
public class ExamLogEntity
{
    private int examLogsId;
    private int examId;
    private int stuId;
    private String email;
    private Timestamp applyTime;
    private Integer mgrId;
    private Integer approvalResult;
    private Timestamp examStartTime;
    private Timestamp examEndTime;
    private BigDecimal score;
    private ExamEntity examEntity;

    @Id
    @Column(name = "ExamLogsID", nullable = false)
    public int getExamLogsId()
    {
        return examLogsId;
    }

    public void setExamLogsId(int examLogsId)
    {
        this.examLogsId = examLogsId;
    }

    @Basic
    @Column(name = "ExamID", nullable = false)
    public int getExamId()
    {
        return examId;
    }

    public void setExamId(int examId)
    {
        this.examId = examId;
    }

    @Basic
    @Column(name = "StuID", nullable = false)
    public int getStuId()
    {
        return stuId;
    }

    public void setStuId(int stuId)
    {
        this.stuId = stuId;
    }

    @Basic
    @Column(name = "Email", nullable = false, length = 20)
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Basic
    @Column(name = "ApplyTime", nullable = false)
    public Timestamp getApplyTime()
    {
        return applyTime;
    }

    public void setApplyTime(Timestamp applyTime)
    {
        this.applyTime = applyTime;
    }

    @Basic
    @Column(name = "MgrID", nullable = true)
    public Integer getMgrId()
    {
        return mgrId;
    }

    public void setMgrId(Integer mgrId)
    {
        this.mgrId = mgrId;
    }

    @Basic
    @Column(name = "ApprovalResult", nullable = true)
    public Integer getApprovalResult()
    {
        return approvalResult;
    }

    public void setApprovalResult(Integer approvalResult)
    {
        this.approvalResult = approvalResult;
    }

    @Basic
    @Column(name = "ExamStartTime", nullable = true)
    public Timestamp getExamStartTime()
    {
        return examStartTime;
    }

    public void setExamStartTime(Timestamp examStartTime)
    {
        this.examStartTime = examStartTime;
    }

    @Basic
    @Column(name = "ExamEndTime", nullable = true)
    public Timestamp getExamEndTime()
    {
        return examEndTime;
    }

    public void setExamEndTime(Timestamp examEndTime)
    {
        this.examEndTime = examEndTime;
    }

    @Basic
    @Column(name = "Score", nullable = true, precision = 2)
    public BigDecimal getScore()
    {
        return score;
    }

    public void setScore(BigDecimal score)
    {
        this.score = score;
    }

    public ExamEntity getExamEntity()
    {
        return examEntity;
    }

    public void setExamEntity(ExamEntity examEntity)
    {
        this.examEntity = examEntity;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamLogEntity that = (ExamLogEntity) o;

        if (examLogsId != that.examLogsId) return false;
        if (examId != that.examId) return false;
        if (stuId != that.stuId) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (applyTime != null ? !applyTime.equals(that.applyTime) : that.applyTime != null)
        {
            return false;
        }
        if (mgrId != null ? !mgrId.equals(that.mgrId) : that.mgrId != null) return false;
        if (approvalResult != null ? !approvalResult.equals(that.approvalResult) : that.approvalResult != null)
        {
            return false;
        }
        if (examStartTime != null ? !examStartTime.equals(that.examStartTime) : that.examStartTime != null)
        {
            return false;
        }
        if (examEndTime != null ? !examEndTime.equals(that.examEndTime) : that.examEndTime != null)
        {
            return false;
        }
        if (score != null ? !score.equals(that.score) : that.score != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = examLogsId;
        result = 31 * result + examId;
        result = 31 * result + stuId;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (applyTime != null ? applyTime.hashCode() : 0);
        result = 31 * result + (mgrId != null ? mgrId.hashCode() : 0);
        result = 31 * result + (approvalResult != null ? approvalResult.hashCode() : 0);
        result = 31 * result + (examStartTime != null ? examStartTime.hashCode() : 0);
        result = 31 * result + (examEndTime != null ? examEndTime.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "ExamLogEntity{" +
                "examLogsId=" + examLogsId +
                ", examId=" + examId +
                ", stuId=" + stuId +
                ", email='" + email + '\'' +
                ", applyTime=" + applyTime +
                ", mgrId=" + mgrId +
                ", approvalResult=" + approvalResult +
                ", examStartTime=" + examStartTime +
                ", examEndTime=" + examEndTime +
                ", score=" + score +
                ", examEntity=" + examEntity +
                '}';
    }
}
