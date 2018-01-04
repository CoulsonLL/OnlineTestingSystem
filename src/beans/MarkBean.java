/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author 小龍ge
 */
@Named(value = "markBean")
@SessionScoped
public class MarkBean implements Serializable {

    private String style;
    public MarkBean() {
         style = "width:40px;\n" +
                "height:40px;\n" +
                "background: graytext;\n" +     
                "z-index: 1;";
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    public void mark(){
          style = "width:40px;\n" +
                "height:40px;\n" +
                "background: yellow;\n" +
                "z-index: 1;";
    }
    public void unmark(){
          style = "width:40px;\n" +
                "height:40px;\n" +
                "background:graytext;\n" +
                "z-index: 1;";
    }
}
