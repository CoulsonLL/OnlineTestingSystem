package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Exam", schema = "dbo", catalog = "OnlineTest")
public class ExamEntity
{
    private int examId;
    private String examName;
    private int duration;
    private int courseId;
    private int examState;
    private Integer questionNum;

    @Id
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
    @Column(name = "ExamName", nullable = false, length = 20)
    public String getExamName()
    {
        return examName;
    }

    public void setExamName(String examName)
    {
        this.examName = examName;
    }

    @Basic
    @Column(name = "Duration", nullable = false)
    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    @Basic
    @Column(name = "CourseID", nullable = false)
    public int getCourseId()
    {
        return courseId;
    }

    public void setCourseId(int courseId)
    {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "ExamState", nullable = false)
    public int getExamState()
    {
        return examState;
    }

    public void setExamState(int examState)
    {
        this.examState = examState;
    }

    @Basic
    @Column(name = "QuestionNum", nullable = true)
    public Integer getQuestionNum()
    {
        return questionNum;
    }

    public void setQuestionNum(Integer questionNum)
    {
        this.questionNum = questionNum;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamEntity that = (ExamEntity) o;

        if (examId != that.examId) return false;
        if (duration != that.duration) return false;
        if (courseId != that.courseId) return false;
        if (examState != that.examState) return false;
        if (examName != null ? !examName.equals(that.examName) : that.examName != null)
            return false;
        if (questionNum != null ? !questionNum.equals(that.questionNum) : that.questionNum != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = examId;
        result = 31 * result + (examName != null ? examName.hashCode() : 0);
        result = 31 * result + duration;
        result = 31 * result + courseId;
        result = 31 * result + examState;
        result = 31 * result + (questionNum != null ? questionNum.hashCode() : 0);
        return result;
    }
}
