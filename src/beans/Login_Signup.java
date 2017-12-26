package beans;

import entity.StudentEntity;
import service.StudentService;
import util.FacesUtil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.ServletRequest;
import java.io.IOException;

import static java.lang.System.out;

@Named
@RequestScoped
public class Login_Signup {
    private String phoneno;
    private String password;
    private String email;
    private boolean remember;

    private String login_null_error;//登陆时有输入框为空错误
    private String error1;//登陆时手机号密码错误
    private String login_success;//登陆成功信息
    private String userinfo;//登陆成功显示在主页的用户手机号

    private String signup_null_error;//注册时有输入框为空错误
    private String error2;//注册时手机号已注册错误
    private String signup_success;//注册成功信息

    public void login() {
        //若登陆时存在inputText为空
        if(phoneno.equals("") || password.equals("")){
            login_null_error = "Ensure every input not null, please enter it again";
        }else{
            StudentService stuService = new StudentService();
            boolean sign = stuService.login(phoneno, password);
            //若登陆成功
            if (sign) {
                userinfo = phoneno.substring(7);
                System.out.println(userinfo+remember);
                //获取session，将是否登陆的值存入session，这样所有的bean都能获取到这个值
                login_success = "success";
                FacesUtil.getSession().setAttribute("islogin",login_success);
            }
            //若登陆失败
            else {
                error1 = "Invalid PhoneNo or Password, check and enter it again";
                out.println("login failed");
            }
        }
    }

    public void signup() {
        //若注册时存在inputText为空
        if(phoneno.equals("") || email.equals("") || password.equals("")){
            signup_null_error = "Ensure every input not null, please enter it again";
        }else{
            StudentService stuService = new StudentService();
            StudentEntity student = new StudentEntity();
            student.setPhoneNum(phoneno);
            student.setEmail(email);
            student.setStuPwd(password);
            boolean sign = stuService.register(student);
            //若注册成功
            if (sign) {
                signup_success = "Sign up success";
                System.out.println(signup_success);
            }
            //若注册失败
            else {
                error2 = "Sign up failed #_# The phone number you entered has been signed up!";
                out.println("Signup failed");
            }
        }
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    public String getError1() {
        return error1;
    }

    public void setError1(String error1) {
        this.error1 = error1;
    }

    public String getError2() {
        return error2;
    }

    public void setError2(String error2) {
        this.error2 = error2;
    }

    public String getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(String userinfo) {
        this.userinfo = userinfo;
    }

    public String getLogin_null_error() {
        return login_null_error;
    }

    public void setLogin_null_error(String login_null_error) {
        this.login_null_error = login_null_error;
    }

    public String getSignup_null_error() {
        return signup_null_error;
    }

    public void setSignup_null_error(String signup_null_error) {
        this.signup_null_error = signup_null_error;
    }

    public String getSignup_success() {
        return signup_success;
    }

    public void setSignup_success(String signup_success) {
        this.signup_success = signup_success;
    }

    public String getLogin_success() {
        return login_success;
    }

    public void setLogin_success(String login_success) {
        this.login_success = login_success;
    }
}
