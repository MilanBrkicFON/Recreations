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

    /**
     * Creates a new instance of AutoCompleteView
     */
    public AutoCompleteView() {
    }

    public List<Osoba> getList(String pretraga) {

        List<Osoba> filtriraneOsobe = kontroler.vratiSveOsobe(pretraga);
        return filtriraneOsobe;
    }

    public List<String> comleteText(String text) {
        List<String> t = new ArrayList();

        for (int i = 0; i < 10; i++) {
            t.add(text + i);
        }
        return t;
    }

    public void onItemSelect(SelectEvent event) throws IOException {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", ((Osoba) event.getObject()).getName()));

        mb.getProfilKorisnik().setOsoba((Osoba) event.getObject());

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/profilnaStrana.xhtml");

    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

}
