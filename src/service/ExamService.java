package service;

import java.util.List;

import dao.ExamDAO;
import entity.CourseEntity;
import entity.ExamEntity;

public class ExamService
{
    private ExamDAO examDAO = new ExamDAO();

    /**
     * 添加考试
     *
     * @param examEntity
     * @return Integer
     */
    public Integer addExam(ExamEntity examEntity)
    {
        return examDAO.addExam(examEntity);
    }

    /**
     * 删除考试
     *
     * @param examEntity
     */
    public boolean deleteExam(ExamEntity examEntity)
    {
        return examDAO.deleteExam(examEntity);
    }

    /**
     * 修改考试
     *
     * @param examEntity
     */
    public boolean modifyExam(ExamEntity examEntity)
    {
        return examDAO.modifyExam(examEntity);
    }

    /**
     * 查询所有考试
     *
     * @return List<ExamEntity>
     */
    public List<ExamEntity> queryAllExams()
    {
        return examDAO.queryAllExams();
    }

    /**
     * 根据名称查询考试列表
     *
     * @param courseEntity
     * @return List<ExamEntity>
     */
    public List<ExamEntity> queryExamsByCourse(CourseEntity courseEntity)
    {
        return examDAO.queryExamsByCourse(courseEntity);
    }

}
