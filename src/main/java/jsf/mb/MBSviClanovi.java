/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Clan;
import model.Mesto;
import utility.Kontroler;

/**
 *
 * @author Milan
 */
@Named(value = "MBSviClanovi")
@SessionScoped
public class MBSviClanovi implements Serializable{

    private List<Clan> clanovi;
    private List<Mesto> mesta;
    
    @Inject
    Kontroler kontroler;

    public MBSviClanovi() {
    }
    
    
    @PostConstruct
    public void init(){
        clanovi = kontroler.vratiSveClanove();
        mesta = kontroler.vratiSvaMesta();
    }
    public List<Clan> getClanovi() {
        return clanovi;
    }

    public void setClanovi(List<Clan> clanovi) {
        this.clanovi = clanovi;
    }

    public List<Mesto> getMesta() {
        return mesta;
    }

    public void setMesta(List<Mesto> mesta) {
        this.mesta = mesta;
    }

    
    
}
