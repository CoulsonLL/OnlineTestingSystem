package service;

import java.util.List;

import dao.QuestionDAO;
import entity.QuestionEntity;

public class QuestionService
{
    QuestionDAO questionDAO = new QuestionDAO();

    /**
     * 添加问题
     *
     * @param questionEntity 问题
     */
    public void addQuestion(QuestionEntity questionEntity)
    {
        questionDAO.addQuestion(questionEntity);
    }

    /**
     * 删除问题
     *
     * @param questionEntity 问题
     */
    public void deleteQuestion(QuestionEntity questionEntity)
    {
        questionDAO.deleteQuestion(questionEntity);
    }

    /**
     * 更新问题
     *
     * @param questionEntity 问题
     */
    public void updateQuestion(QuestionEntity questionEntity)
    {
        questionDAO.updateQuestion(questionEntity);
    }

    /**
     * 根据课程ID查询问题
     *
     * @param courseID 课程ID
     * @return List<QuestionEntity>
     */
    public List<QuestionEntity> queryQuestionsByCourseID(Integer courseID)
    {
        return questionDAO.queryQuestionsByCourseID(courseID);
    }

    /**
     * 根据问题ID查询问题
     *
     * @param questionID 问题ID
     * @return QuestionEntity
     */
    public QuestionEntity queryQuesitonByID(Integer questionID)
    {
        return questionDAO.queryQuesitonByID(questionID);
    }
}