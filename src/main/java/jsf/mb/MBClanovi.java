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
@Named(value = "mbClanovi")
@ViewScoped
public class MBClanovi implements Serializable{

    private List<Clan> clanovi;
    
    @Inject
    Kontroler kontroler;

    public MBClanovi() {
    }
    @PostConstruct
    public void init(){
        clanovi = kontroler.vratiSveClanove();
    }
    public List<Clan> getClanovi() {
        return clanovi;
    }

    public void setClanovi(List<Clan> clanovi) {
        this.clanovi = clanovi;
    }

}
