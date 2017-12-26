package entity;

public class UserAnswerEntity
{
    private int examLogsId;
    private int stuId;
    private int examId;
    private int questionId;
    private String userAnswer;
    private int userAnswerId;

    public int getExamLogsId()
    {
        return examLogsId;
    }

    public void setExamLogsId(int examLogsId)
    {
        this.examLogsId = examLogsId;
    }

    public int getStuId()
    {
        return stuId;
    }

    public void setStuId(int stuId)
    {
        this.stuId = stuId;
    }

    public int getExamId()
    {
        return examId;
    }

    public void setExamId(int examId)
    {
        this.examId = examId;
    }

    public int getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(int questionId)
    {
        this.questionId = questionId;
    }

    public String getUserAnswer()
    {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer)
    {
        this.userAnswer = userAnswer;
    }

    public int getUserAnswerId()
    {
        return userAnswerId;
    }

    public void setUserAnswerId(int userAnswerId)
    {
        this.userAnswerId = userAnswerId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAnswerEntity that = (UserAnswerEntity) o;

        if (examLogsId != that.examLogsId) return false;
        if (stuId != that.stuId) return false;
        if (examId != that.examId) return false;
        if (questionId != that.questionId) return false;
        if (userAnswerId != that.userAnswerId) return false;
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
        result = 31 * result + examId;
        result = 31 * result + questionId;
        result = 31 * result + (userAnswer != null ? userAnswer.hashCode() : 0);
        result = 31 * result + userAnswerId;
        return result;
    }
}
