/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Milan
 */
@Named(value = "navigacija")
@RequestScoped
public class Navigacija {

    /**
     * Creates a new instance of Navigacija
     */
    public Navigacija() {
    }
    
    
    public String pocetna(){
        return "pocetna.xhtml?faces-redirect=true";
    }
    
    public String profilna(){
        return "profilnaStrana.xhtml?faces-redirect=true";
    }
    
    public String editKorisnika(){
        return "EditClan.xhtml?faces-redirect=true";
    }
    
    public String mojiTreninzi(){
        return "mojiTreninzi.xhtml?faces-redirect=true";
    }
}
