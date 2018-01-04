/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import entity.ManagerEntity;
import service.ManagerService;
import util.FacesUtil;

/**
 *
 * @author Administrator
 */
@Named(value = "modifyPass_manager")
@RequestScoped
public class Modify_manager {
 
    private String password;
    private String npsd;
    private String npsd1;
    private String error;
    

 

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the newpassword
     */
    
    public void modifyPass(){
       ManagerService s = new ManagerService();
       ManagerEntity ssEntity = (ManagerEntity) FacesUtil.getSession().getAttribute("mgrInfo");
       if(password.equals(ssEntity.getMgrPwd())){
           ssEntity.setMgrPwd(npsd1);
           s.changeProfile(ssEntity);
          
       }else{
           error = "Invalid previous password";
       }
       
    } 

    /**
     * @return the npsd
     */
    public String getNpsd() {
        return npsd;
    }

    /**
     * @param npsd the npsd to set
     */
    public void setNpsd(String npsd) {
        this.npsd = npsd;
    }

    /**
     * @return the MgrID
     */
   

    /**
     * @return the MgrName
     */
  

    public String getNpsd1() {
        return npsd1;
    }

    public void setNpsd1(String npsd1) {
        this.npsd1 = npsd1;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
}
