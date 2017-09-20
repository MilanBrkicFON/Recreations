/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import javax.inject.Named;
import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Milan
 */
@Named(value = "localization")
@SessionScoped
public class Localization implements Serializable {
    public static final int ENG = 1;
    public static final int SERBIAN = 2;
    
    private String current = "ENG";
    
    
    public void change(int language){
        System.out.println("POZVALA SE IZMENA JEZIKA!"+language);
        switch(language){
            case ENG:
                FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
                setCurrent("ENG");
                break;
            case SERBIAN :
                FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("sr", "RS"));
                setCurrent("SRB");
                break;
                
        }
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }
    
    public Locale getLocale(){
        if (current.equals("ENG")) {
            return Locale.ENGLISH;
        }
        return new Locale("sr", "RS");
    }
}
