package beans;

import entity.StudentEntity;
import service.StudentService;
import util.FacesUtil;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

import static java.lang.System.out;

@Named
@RequestScoped
public class Login_Signup {
    private String phoneno;
    private String password;
    private String email;
    private boolean remember;
    private String error1;
    private String error2;
    private String userinfo;

    public void login() {
        StudentService stuService = new StudentService();
        boolean sign = stuService.login(phoneno, password);
        if (sign) {
            FacesUtil.getRequest().getRequestDispatcher("HomePage.xhtml");
            userinfo = phoneno;
            System.out.println(userinfo);
        } else {
            error1 = "Invalid PhoneNo or Password, check and enter it again";
            out.println("login failed");
        }
    }

    public void signup() {
        StudentService stuService = new StudentService();
        StudentEntity student = new StudentEntity();
        student.setPhoneNum(phoneno);
        student.setEmail(email);
        student.setStuPwd(password);
        boolean sign = stuService.register(student);
        if (sign) {
            try {
                FacesUtil.getResponse().sendRedirect("HomePage.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            error2 = "Check your format of phone number and email address, please enter it again";
            out.println("Signup failed");
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
}
