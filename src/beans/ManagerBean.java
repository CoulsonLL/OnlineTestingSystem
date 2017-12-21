package beans;

import service.ManagerService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ManagerBean {
    private int id;
    private String password;
    private String error;

    public String login(){
        ManagerService managerSer = new ManagerService();
        boolean sign = managerSer.login(id, password);
        if(sign){
            return "ManagerCenter";
        }else{
            error = "Login failed";
            return null;
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
