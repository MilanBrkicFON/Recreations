/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import model.Clan;
import model.Osoba;
import model.Trener;
import model.Trening;
import utility.Kontroler;

/**
 *
 * @author Milan
 */
@Named(value = "mbTrening")
@SessionScoped
public class MBTrenings implements Serializable {

    private List<Trening> treninzi;
    private Trening selektovanTrening;
    
    @Inject
    private Kontroler kontroler;

    /**
     * Creates a new instance of MBTrenings
     */
    public MBTrenings() {
    }

    @PostConstruct
    public void init() {
        treninzi = kontroler.vratiSveTreninge();
    }

    public List<Trening> getTreninzi() {
        return treninzi;
    }

    public void setTreninzi(List<Trening> treninzi) {
        this.treninzi = treninzi;
    }

    public Trening getSelektovanTrening() {
        return selektovanTrening;
    }

    public void setSelektovanTrening(Trening selektovanTrening) {
        this.selektovanTrening = selektovanTrening;
    }
    

    public List<Trening> vratiTreninge(Osoba o) {
        List<Trening> pomTrening = new ArrayList<>();
        System.out.println(o);
        if (o instanceof Clan) {
            System.out.println("clan");
            Clan clan = (Clan) o;
            for (Trening trening : treninzi) {
                if (trening.getClanovi().contains(clan)) {
                    pomTrening.add(trening);
                }
            }
        }else if(o instanceof Trener){
            System.out.println("trener");
            Trener trener = (Trener) o;
            for (Trening trening : treninzi) {
                if (trening.getTreneri().contains(trener)) {
                    pomTrening.add(trening);
                }
            }
        }
        System.out.println("--- ZAVRSENA METODA VRATITRENINGE(CLAN) ----");
        System.out.println("--- VRACENO "+pomTrening.size()+"----");
        
        return pomTrening;
    }
}
