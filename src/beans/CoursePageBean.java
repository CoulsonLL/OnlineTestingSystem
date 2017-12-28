package beans;

import entity.CourseEntity;
import entity.StudentEntity;
import service.CourseService;
import service.StudentService;
import util.FacesUtil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CoursePageBean {
    private String click_flag;
    private CourseEntity passCourse;

    public void ParticipateClick(){
        String sessionlogintext = (String) FacesUtil.getSession().getAttribute("islogin");
        //若点击‘参加课程’按钮时用户已经登陆
        if(sessionlogintext.equals("success")){
            click_flag = "isLoged";
            //将用户申请信息发送到数据库
            StudentEntity studentEntity = (StudentEntity) FacesUtil.getSession().getAttribute("userInfo");
            StudentService stuSer = new StudentService();
            passCourse = (CourseEntity) FacesUtil.getSession().getAttribute("selectedcourse");
            stuSer.selectCourse(studentEntity, passCourse);
        }
        //若点击‘参加课程’按钮时用户未登陆
        else{
            click_flag = "notLoged";
        }
    }
    public String getClick_flag() {
        return click_flag;
    }

    public void setClick_flag(String click_flag) {
        this.click_flag = click_flag;
    }
}
