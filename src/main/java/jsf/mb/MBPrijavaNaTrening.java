/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import model.Trening;
import utility.Kontroler;

/**
 *
 * @author Milan
 */
@Named(value = "mBPrijavaNaTrening")
@SessionScoped
public class MBPrijavaNaTrening implements Serializable {

    @Inject
    private Kontroler kontroler;
    
    private Trening trening;
    /**
     * Creates a new instance of MBPrijavaNaTrening
     */
    public MBPrijavaNaTrening() {
    }
    
    @PostConstruct
    public void init(){
        trening = new Trening();
    }
    public void prijaviSeNaTrening(){
        System.out.println("--- POZVANA METODA PRIJAVANATRENING() ---");
        
        
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }
    
    
}
