package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserAnswer", schema = "dbo", catalog = "OnlineTest")
public class UserAnswerEntity
{
    private int examLogsId;
    private int stuId;
    private int questionId;
    private String userAnswer;

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
    @Column(name = "QuestionID", nullable = false)
    public int getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(int questionId)
    {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "UserAnswer", nullable = false, length = 1)
    public String getUserAnswer()
    {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer)
    {
        this.userAnswer = userAnswer;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAnswerEntity that = (UserAnswerEntity) o;

        if (examLogsId != that.examLogsId) return false;
        if (stuId != that.stuId) return false;
        if (questionId != that.questionId) return false;
        if (userAnswer != null ? !userAnswer.equals(that.userAnswer) : that.userAnswer != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = examLogsId;
        result = 31 * result + stuId;
        result = 31 * result + questionId;
        result = 31 * result + (userAnswer != null ? userAnswer.hashCode() : 0);
        return result;
    }
}
