package beans;

import service.StudentService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Logout {
    //退出登录
    public String logout(){
        StudentService StuSer = new StudentService();
        StuSer.logout();
        return "HomePage";
    }
}
