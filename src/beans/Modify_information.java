/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.StudentEntity;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import service.StudentService;
import util.FacesUtil;

/**
 *
 * @author 小龍ge
 */
@Named(value = "modify_information")
@RequestScoped
public class Modify_information {

    String phoneNumber;
    int age;
    String email;
    String password;
    String oldPassword;
    String newPassword;
    String name;
    String sex;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
   public void modifyInformation(){
       StudentEntity se = (StudentEntity) FacesUtil.getSession().getAttribute("userInfo");
       se.setStuName(name);
       se.setEmail(email);
       se.setPhoneNum(phoneNumber);
       se.setStuSex(sex);
       StudentService ss = new StudentService();
       ss.updateStudent(se);
   }     
   public void modifyPassword(){
            StudentEntity ssEntity = (StudentEntity) FacesUtil.getSession().getAttribute("userInfo");
            ssEntity.setStuPwd(password);
            StudentService s = new StudentService();
            s.updateStudent(ssEntity);      
   }
//      public void selectInformation(){
//            StudentEntity ss= (StudentEntity) FacesUtil.getSession().getAttribute("userInfo");
//            StudentService s = new StudentService();
//            s.; 
//      }
   public void validatePassword(FacesContext fc,UIComponent c, Object value)
   {
       if(getPassword()!=getNewPassword()) throw new ValidatorException(new FacesMessage ("Reset Password Not Match!"));           
   }
}
