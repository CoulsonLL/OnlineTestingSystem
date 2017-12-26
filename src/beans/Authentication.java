package beans;

import entity.StudentEntity;
import service.StudentService;
import util.FacesUtil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Authentication {
    private String phoneno;
    private boolean sign;
    private String hiddeninput;

    public void checkLogin(){
        StudentService stuSer = new StudentService();
        sign = stuSer.isLoggedIn();
        //如果判断用户已登录，从session中获取已登录的StudentEntity
        if(sign){
            StudentEntity stu = (StudentEntity) FacesUtil.getSession().getAttribute("userInfo");
            phoneno = stu.getPhoneNum().substring(7);
            hiddeninput = (String) FacesUtil.getSession().getAttribute("islogin");
        }
        //若用户未登录，也需在session中设置islogin的属性值，以防止后续页面空指针异常
        else{
            FacesUtil.getSession().setAttribute("islogin", "fail");
        }
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getHiddeninput() {
        return hiddeninput;
    }

    public void setHiddeninput(String hiddeninput) {
        this.hiddeninput = hiddeninput;
    }
}
