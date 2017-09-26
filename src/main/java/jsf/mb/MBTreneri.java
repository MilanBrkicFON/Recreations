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
import model.Trener;
import utility.Kontroler;

/**
 *
 * @author Milan
 */
@Named(value = "mbTreneri")
@ViewScoped
public class MBTreneri implements Serializable{

    private List<Trener> treneri;
    
    @Inject
    Kontroler kontroler;

    public MBTreneri() {
    }
    @PostConstruct
    public void init(){
        try {
            treneri = kontroler.vratiSveTrenere();
        } catch (Exception ex) {
            Logger.getLogger(MBTreneri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Trener> getTreneri() {
        return treneri;
    }

    public void setTreneri(List<Trener> treneri) {
        this.treneri = treneri;
    }
}
