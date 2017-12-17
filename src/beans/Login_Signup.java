package beans;

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

@Named
@RequestScoped
public class Login_Signup {
    private String phoneno;
    private String password;
    private String email;
    private boolean remember;
    private String error;

    public void login(){
        StudentService stuService = new StudentService();
        boolean sign = stuService.login(phoneno, password);
        if(sign){
            try {
                FacesUtil.getResponse().sendRedirect("HomePage.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            error = "Invalid PhoneNo or Password, check and enter it again";
            System.out.println("login failed");
        }
    }

//    public void validatename(FacesContext context, UIComponent component, Object value){
//        if(error!=null){
//            throw new ValidatorException(new FacesMessage(error));
//        }
//    }

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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
