/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import java.util.List;
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
public class mbSport {

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
        sports = kontroler.vratiSveSportove();
    }

    public List<Sport> getSports() {
        return sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }
    
    
}
