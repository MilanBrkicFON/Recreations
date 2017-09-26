/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import model.Clan;
import model.Osoba;
import model.Trener;
import model.Trening;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
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
    private Trening noviTrening;
    private Clan selektovanClan;
    private Date vremeOd;
    private Date vremeDo;

    @Inject
    private Kontroler kontroler;
    @Inject
    private MBKorisnik mbKorisnik;
    @Inject
    Navigacija nav;

    /**
     * Creates a new instance of MBTrenings
     */
    public MBTrenings() {
    }

    @PostConstruct
    public void init() {
        try {
            treninzi = kontroler.vratiSveTreninge();
            noviTrening = new Trening();
        } catch (Exception ex) {
            Logger.getLogger(MBTrenings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Date getVremeOd() {
        return vremeOd;
    }

    public void setVremeOd(Date vremeOd) {
        this.vremeOd = vremeOd;
    }

    public Date getVremeDo() {
        return vremeDo;
    }

    public void setVremeDo(Date vremeDo) {
        this.vremeDo = vremeDo;
    }

    public List<Trening> get() throws Exception{
        treninzi = kontroler.vratiSveTreninge(); 
        return treninzi;
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

    public Trening getNoviTrening() {
        return noviTrening;
    }

    public void setNoviTrening(Trening noviTrening) {
        this.noviTrening = noviTrening;
    }

    public Clan getSelektovanClan() {
        return selektovanClan;
    }

    public void setSelektovanClan(Clan selektovanClan) {
        this.selektovanClan = selektovanClan;
    }

    public List<Trening> vratiTreninge(Osoba o) {
        List<Trening> pomTrening = new ArrayList<>();
        System.out.println(o.getName());
        if (o instanceof Clan) {
            System.out.println("clan");
            Clan clan = (Clan) o;
            for (Trening trening : treninzi) {
                if (trening.getClanovi().contains(clan)) {
                    pomTrening.add(trening);
                }
            }
        } else if (o instanceof Trener) {
            System.out.println("trener");
            Trener trener = (Trener) o;
            for (Trening trening : treninzi) {
                if (trening.getTreneri().contains(trener)) {
                    pomTrening.add(trening);
                }
            }
        }

        return pomTrening;
    }

    public void onRowSelect(SelectEvent evt) {
        if (evt == null) {
            System.out.println("NULL NULL NULL");
            return;
        }
        Object o = evt.getObject();
        if (o instanceof Trener) {
            Trener t = (Trener) o;
            noviTrening.getTreneri().add(t);
            FacesMessage msg = new FacesMessage("Unet trener", t.getName());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else if (o instanceof Clan) {
            Clan cl = (Clan) o;
            noviTrening.getClanovi().add(cl);
            FacesMessage msg = new FacesMessage("Unet clan", cl.getName());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public String saveNew() {
        try {
            noviTrening.setVremeOd(LocalDateTime.ofInstant(vremeOd.toInstant(), ZoneId.systemDefault()).toLocalTime());
            System.out.println("VREME: " + noviTrening.getVremeOd().toString());
            noviTrening.setVremeDo(LocalDateTime.ofInstant(vremeDo.toInstant(), ZoneId.systemDefault()).toLocalTime());
            kontroler.sacuvaj(noviTrening);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspesno ste kreirali novi trening!", noviTrening.toString()));
            return nav.pocetna();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sistem ne moze da sacuva novi trening!", e.getMessage()));
        }
        return null;
    }

    public void obrisi(Trening trening) {
        try {
            kontroler.obrisi(trening);
            treninzi = kontroler.vratiSveTreninge();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistem je uspesno obrisao trening", noviTrening.toString()));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sistem nije obrsao trening.", e.getMessage()));
        }
    }

    public void update() {
        try {
            System.out.println("SELEKTOVAN TRENING:"+ selektovanTrening.toString());
            kontroler.izmeni(selektovanTrening);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistem je uspesno izmenio trening", noviTrening.toString()));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sistem nije izmenio podatke!", e.getMessage()));
        }
    }

    public String izmena(Trening trening) {
        try {
            selektovanTrening = trening;
            return nav.izmeniTrening();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Greska!", e.getMessage()));
        }
        return null;
    }
}
