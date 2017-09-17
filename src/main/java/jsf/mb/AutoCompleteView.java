/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import model.Korisnik;
import model.Osoba;
import org.primefaces.event.SelectEvent;
import utility.Kontroler;

/**
 *
 * @author Milan
 */
@Named(value = "autoCompleteView")
@RequestScoped
public class AutoCompleteView implements Serializable {

    private Osoba osoba;
    @Inject
    private Kontroler kontroler;
    @Inject
    private MBKorisnik mbKorisnik;
    @Inject
    private Navigacija nav;

    /**
     * Creates a new instance of AutoCompleteView
     */
    public AutoCompleteView() {
    }

    public List<Osoba> getSelected(String search) {
        if (search.isEmpty()) {
            return null;
        }
        return kontroler.vratiSveOsobe(search);
    }

    public void onItemSelect(SelectEvent evt) {
        System.out.println("OSOBA: " + osoba);
        mbKorisnik.setProfilKorisnik(kontroler.getSelectedUser(osoba));

        FacesContext.getCurrentInstance()
                .getApplication().getNavigationHandler()
                .handleNavigation(FacesContext.getCurrentInstance(), "", "profilnaStrana.xhtml");

        FacesContext.getCurrentInstance()
                .addMessage("msgs", new FacesMessage(FacesMessage.SEVERITY_INFO, "Selectovan: ",
                        osoba.getName()));
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }
    
    
}
