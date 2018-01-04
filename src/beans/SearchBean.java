/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.CourseEntity;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import service.CourseService;

/**
 *
 * @author Administrator
 */
@Named(value = "searchBean")
@RequestScoped
public class SearchBean {
    
    private List<CourseEntity> moduleCourse;
    private int moduleID;
    private String moduleName;
   

    

    public int getModuleID() {
        return moduleID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    /**
     * Creates a new instance of SearchBean
     */
    public SearchBean() {
    }
    
    public void searchCourserByModule(){
        CourseService courseService = new CourseService();
        moduleCourse = courseService.getCoursesByModuleID(moduleID);
    }
    
    
    
    public void searchCourserByIdAndName(){
        CourseService courseService = new CourseService();
        moduleCourse = courseService.getCoursesByName(moduleName);
    }

    public List<CourseEntity> getModuleCourse() {
        return moduleCourse;
    }

    public void setModuleCourse(List<CourseEntity> moduleCourse) {
        this.moduleCourse = moduleCourse;
    }
    
}
