package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AjaxBean {
    private boolean agree;
    private String buttonval = "Invalid";

    public void buttonvalue(){
        if(!agree){
            buttonval = "Invalid";
        }else{
            buttonval = "Register";
        }
    }
    public boolean isAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }

    public String getButtonval() {
        return buttonval;
    }

    public void setButtonval(String buttonval) {
        this.buttonval = buttonval;
    }
}
