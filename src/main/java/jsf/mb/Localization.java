/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import javax.inject.Named;
import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Milan
 */
@Named(value = "localization")
@ApplicationScoped
public class Localization implements Serializable {
    public static final int ENG = 1;
    public static final int SERBIAN = 2;
    
    /**
     * Creates a new instance of Localization
     */
    public Localization() {
    }
    
    
    public void change(int language){
        System.out.println("POZVALA SE IZMENA JEZIKA!"+language);
        switch(language){
            case ENG:
                FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
                break;
            case SERBIAN :
                FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("sr", "RS"));
                break;
                
        }
    }
}