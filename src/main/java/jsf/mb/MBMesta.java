/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Clan;
import model.Mesto;
import utility.Kontroler;

/**
 *
 * @author Milan
 */
@Named(value = "mbMesta")
@ViewScoped
public class MBMesta implements Serializable{

    private List<Mesto> mesta;
    
    @Inject
    Kontroler kontroler;

    public MBMesta() {
    }
    
    
    @PostConstruct
    public void init(){
        try {
            mesta = kontroler.vratiSvaMesta();
        } catch (Exception ex) {
            Logger.getLogger(MBMesta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Mesto> getMesta() {
        return mesta;
    }

    public void setMesta(List<Mesto> mesta) {
        this.mesta = mesta;
    }
    
}
