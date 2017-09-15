/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import model.Clan;
import model.Trener;
import model.Trening;
import org.primefaces.context.RequestContext;
import utility.Kontroler;

/**
 *
 * @author Milan
 */
@Named(value = "filterTreninga")
@ViewScoped
public class FilterTreninga implements Serializable {

    private List<Trening> treninzi;
    private List<Trening> filtriraniTreninzi;
    private List<Trener> treneriNaTreningu;

    @Inject
    private MBTrenings mbTrening;
    @Inject
    private Kontroler kontroler;
    @Inject
    private MBKorisnik mbKorisnik;

    /**
     * Creates a new instance of FilterTreninga
     */
    public FilterTreninga() {
    }

    @PostConstruct
    public void init() {
        treninzi = mbTrening.getTreninzi();
        filtriraniTreninzi = new ArrayList<>();
        treneriNaTreningu = new ArrayList<>();
    }

    public List<Trening> getTreninzi() {
        return treninzi;
    }

    public void setTreninzi(List<Trening> treninzi) {
        this.treninzi = treninzi;
    }

    public List<Trening> getFiltriraniTreninzi() {
        return filtriraniTreninzi;
    }

    public void setFiltriraniTreninzi(List<Trening> filtriraniTreninzi) {
        this.filtriraniTreninzi = filtriraniTreninzi;
    }

    public List<Trener> getTreneriNaTreningu() {
        System.out.println("treneri na treningu"+ treneriNaTreningu.size());
        return treneriNaTreningu;
    }

    public void setTreneriNaTreningu(List<Trener> treneriNaTreningu) {
        this.treneriNaTreningu = treneriNaTreningu;
    }

    public void vratiSelektovanog(Trening trening) {
        //logika za dodavanje clana na trening
        System.out.println("--- POZVALA SE METODA VRATISELEKTOVANOG() ---");
        trening.getClanovi().add((Clan) mbKorisnik.getKorisnik().getOsoba());
        try {
            kontroler.izmeni(trening);
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspesno ste se prijavili na trening!", trening.toString()));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Doslo je do greske!", trening.toString()));
        }
        //RequestContext.getCurrentInstance().closeDialog(trening);
    }

}
