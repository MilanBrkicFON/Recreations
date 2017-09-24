/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Milan
 */
@Named(value = "navigacija")
@ApplicationScoped
public class Navigacija {

    /**
     * Creates a new instance of Navigacija
     */
    public Navigacija() {
    }
    
    
    public String pocetna(){
        return "/pocetna.xhtml?faces-redirect=true";
    }
    
    public String profilna(){
        return "/profilnaStrana.xhtml?faces-redirect=true";
    }
    
    public String editKorisnika(){
        return "/EditClan.xhtml?faces-redirect=true";
    }
    
    public String mojiTreninzi(){
        return "/mojiTreninzi.xhtml?faces-redirect=true";
    }
    
    public String index(){
        return "/index.xhtml?faces-redirect=true";
    }
    public String dodajTrening(){
        return "/admin/dodajTrening.xhtml?faces-redirect=true";
    }
     public String izmeniTrening(){
        return "/admin/izmeniTrening.xhtml?faces-redirect=true";
    }   
}
