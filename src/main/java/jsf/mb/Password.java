/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import com.password.hashing.PasswordHashing;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.print.attribute.standard.Severity;
import utility.Kontroler;

/**
 *
 * @author Milan
 */
@Named(value = "password")
@ViewScoped
public class Password implements Serializable{
    
    private String oldPass;
    private String newPass;
    
    @Inject
    private MBKorisnik mb;
    
    @Inject
    private Kontroler k;
    /**
     * Creates a new instance of Password
     */
    public Password() {
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        PasswordHashing ph = new PasswordHashing(oldPass);
        this.oldPass = ph.generateHash();
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
    
    
    public void promeniLozinku(){
        System.out.println(mb.getKorisnik().getPassword());
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
        System.out.println(oldPass);
        
        if (oldPass.equals(mb.getKorisnik().getPassword())) {
            try {
                k.promeniLozinku(newPass,mb.getKorisnik());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspesno promenjena lozinka", ""));
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspesno promenjena lozinka", ""));
            }
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Stara lozinka se ne poklapa.", ""));
        }
    }
}
