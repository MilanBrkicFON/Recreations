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
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.Sport;
import utility.Kontroler;

/**
 *
 * @author Milan
 */
@Named(value = "mbSport")
@RequestScoped
public class mbSport implements Serializable{

    @Inject
    private Kontroler kontroler;
    
    private List<Sport> sports;
    
    
    /**
     * Creates a new instance of mbSport
     */
    public mbSport() {
    }
    
    @PostConstruct
    public void init(){
        retriveData();
    }

    private void retriveData() {
        try {
            sports = kontroler.vratiSveSportove();
        } catch (Exception ex) {
            Logger.getLogger(mbSport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Sport> getSports() {
        return sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }
    
    
}
