/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import model.Clan;
import model.Korisnik;
import model.Osoba;
import org.primefaces.event.SelectEvent;
import utility.Kontroler;

/**
 *
 * @author Milan
 */
@Named(value = "autoCompleteView")
@ViewScoped
public class AutoCompleteView implements Serializable {

    private Osoba osoba;
    @Inject
    private Kontroler kontroler;

    @Inject
    private MBKorisnik mb;
    @Inject
    private Navigacija nav;

    /**
     * Creates a new instance of AutoCompleteView
     */
    public AutoCompleteView() {
    }

    public List<Osoba> getList(String pretraga) {

        List<Osoba> filtriraneOsobe = kontroler.vratiSveOsobe(pretraga);
        return filtriraneOsobe;
    }

    public void onItemSelect(SelectEvent event) throws IOException {
        System.out.println("---- POZVALA SE METODA ZA AUTOCOMPLETE ----");
        System.out.println("Osoba iz klase: " + osoba);
        
        Korisnik kor = kontroler.getSelectedUser(osoba);
        mb.setProfilKorisnik(kor);
        System.out.println("--- PROFILNI KORISNIK SETOVAN NA: " + kor);
        FacesContext.getCurrentInstance().getApplication()
                .getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), "", nav.profilna());

    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

}
