/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.CourseDAO;
import dao.ScDAO;
import entity.ExamLogEntity;
import entity.ScEntity;
import entity.StudentEntity;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import service.StudentService;
import util.FacesUtil;

/**
 *
 * @author 小龍ge
 */
@Named(value = "personalCenter")
@RequestScoped
public class PersonalCenter {

    int scID;
    String courseName;
    List<ScEntity> list;

    public int getScID() {
        return scID;
    }

    public void setScID(int scID) {
        this.scID = scID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<ScEntity> getList() {
        StudentService ss = new StudentService();
        StudentEntity se = (StudentEntity) FacesUtil.getSession().getAttribute("userInfo");
        list = ss.queryScByStudent(se);
        return list;
    }

    public void setList(List<ScEntity> list) {
        this.list = list;
    }
    
    public String getCourseName(ScEntity sc){
        CourseDAO cdao = new CourseDAO();
        return cdao.queryCourseById(sc.getcCourseId()).getcName();       
    }
}
