package beans;

import util.FacesUtil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class JavaCourseBean {
    private String click_flag;
    private String sessionlogintext;

    public void click(){
        sessionlogintext = (String)FacesUtil.getSession().getAttribute("islogin");
        //若点击‘参加课程’按钮时用户已经登陆
        if(sessionlogintext.equals("success")){
            click_flag = "isLoged";
            //将用户申请信息发送到数据库

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
