package beans;

import sun.security.validator.ValidatorException;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Named
@RequestScoped
public class Validator{

    /**
     * 验证手机号码为11位阿拉伯数字
     * @param context
     * @param component
     * @param value
     */
    public void validatePhoneNo(FacesContext context, UIComponent component, Object value) {
        boolean flag;
        String phoneno = (String)value;
        String check = "^[0-9]+$";
        Pattern pattern = Pattern.compile(check);
        Matcher matcher = pattern.matcher(phoneno);
        flag = matcher.matches();
        if(phoneno.length()!=11 || !flag){
            throw new javax.faces.validator.ValidatorException(new FacesMessage("* 11 digits required"));
        }
    }

    /**
     * 验证邮箱格式 Ming_01@163.com
     * @param context
     * @param component
     * @param value
     */
    public void validateEmail(FacesContext context, UIComponent component, Object value){
        boolean flag;
        String email = (String)value;
        String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(check);
        Matcher matcher = pattern.matcher(email);
        flag = matcher.matches();
        if(!flag){
            throw new javax.faces.validator.ValidatorException(new FacesMessage("* FORMAT: Zhang_01@163.com"));
        }
    }
}
