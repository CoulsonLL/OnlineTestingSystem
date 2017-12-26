package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import entity.CourseEntity;
import entity.ExamEntity;
import service.CourseService;
import service.ExamService;

@Named
@ViewScoped
public class ExamBean implements Serializable
{
    private List<ExamEntity> examEntityList;
    private ExamEntity examEntity;
    private ExamEntity newExamEntity = new ExamEntity();

    public String getCourseNameByID(int courseID)
    {
        CourseService courseService = new CourseService();
        String name = courseService.queryCourseNameById(courseID);
        return name;
    }

    public String convertExamStateToString(int examState)
    {
        if (examState == 0)
        {
            return "Available";
        }
        else
        {
            return "Not Available";
        }
    }

    public void deleteExam(ExamEntity examEntity)
    {
        ExamService examService = new ExamService();
        examService.deleteExam(examEntity);
    }

    public void modifyExam()
    {
        ExamService examService = new ExamService();
        examService.modifyExam(newExamEntity);
        updateExamEntityList();
    }

    public void addAsNew()
    {
        ExamService examService = new ExamService();
        examService.addExam(newExamEntity);
    }

    public void handleModifyExamButton(ExamEntity examEntity)
    {
        newExamEntity = new ExamEntity();
        newExamEntity.setCourseId(examEntity.getCourseId());
        newExamEntity.setDuration(examEntity.getDuration());
        newExamEntity.setExamId(examEntity.getExamId());
        newExamEntity.setExamName(examEntity.getExamName());
        newExamEntity.setQuestionNum(examEntity.getQuestionNum());
        newExamEntity.setExamState(examEntity.getExamState());
    }

    public List<CourseEntity> queryAllIDsAndNames()
    {
        CourseService courseService = new CourseService();
        return courseService.queryAllIDsAndNames();
    }

    public List<SelectItem> getSelectItemList()
    {
        List<SelectItem> selectItemList = new ArrayList<SelectItem>();
        List<CourseEntity> list = queryAllIDsAndNames();
        for (CourseEntity entity : list)
        {
            selectItemList.add(new SelectItem(entity.getcCourseId(), entity.getcName()));
        }
        return selectItemList;
    }

    public void updateExamEntityList()
    {
        ExamService examService = new ExamService();
        examEntityList = examService.queryAllExams();
    }

    public List<ExamEntity> getExamEntityList()
    {
        return examEntityList;
    }

    public void setExamEntityList(List<ExamEntity> examEntityList)
    {
        this.examEntityList = examEntityList;
    }

    public ExamEntity getExamEntity()
    {
        return examEntity;
    }

    public ExamEntity getNewExamEntity()
    {
        return newExamEntity;
    }

    public void setNewExamEntity(ExamEntity newExamEntity)
    {
        this.newExamEntity = newExamEntity;
    }

    public void setExamEntity(ExamEntity examEntity)
    {
        this.examEntity = examEntity;
    }
}
