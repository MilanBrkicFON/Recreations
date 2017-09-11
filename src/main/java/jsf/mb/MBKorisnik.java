/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import model.Clan;
import model.Korisnik;
import model.Mesto;
import model.Osoba;
import model.Relationship;
import utility.Kontroler;

/**
 *
 * @author Milan
 */
@Named(value = "mBKorisnik")
@SessionScoped
public class MBKorisnik implements Serializable {

    private Korisnik korisnik;
    private Korisnik profilKorisnik;
    private Korisnik korisnikZaRegistraciju;
    private String lozinkaZaUlazUIzmenu;
    private List<Korisnik> listaKorisnika;

    @Inject
    private Kontroler kontroler;

    /**
     * Creates a new instance of MBKorisnik
     */
    public MBKorisnik() {

    }

    @PostConstruct
    public void init() {
        korisnik = new Korisnik();
        profilKorisnik = new Korisnik();
        korisnikZaRegistraciju = new Korisnik();

    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Korisnik getProfilKorisnik() {
        return profilKorisnik;
    }

    public void setProfilKorisnik(Korisnik profilKorisnik) {
        this.profilKorisnik = profilKorisnik;
    }

    public Korisnik getKorisnikZaRegistraciju() {
        return korisnikZaRegistraciju;
    }

    public void setKorisnikZaRegistraciju(Korisnik korisnikZaRegistraciju) {
        this.korisnikZaRegistraciju = korisnikZaRegistraciju;
    }

    public String getLozinkaZaUlazUIzmenu() {
        return lozinkaZaUlazUIzmenu;
    }

    public void setLozinkaZaUlazUIzmenu(String lozinkaZaUlazUIzmenu) {
        this.lozinkaZaUlazUIzmenu = lozinkaZaUlazUIzmenu;
    }

    public String ulogujSe() {
        try {
            System.out.println("---- POZVALA SE METODA ZA LOGOVANJE KORISNIKA! ----");
            Korisnik korisnikIzBaze = kontroler.vratiKorisnika(korisnik);

            korisnik = korisnikIzBaze;
            profilKorisnik = korisnik;
            return "profilnaStrana.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), ""));

        }
        return null;
    }

    public String logout() {
        System.out.println("--- POZVALA SE METODA LOGOUT() ---");
        korisnik = new Korisnik();
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();

        return "/index.xhtml";
    }

    public String registrujKorisnika() {
        try {
            System.out.println("---- POZVALA SE METODA ZA REGISTRUJ KORISNIKA! ----");
            System.out.println(korisnikZaRegistraciju);
            kontroler.sacuvajOsobu(korisnikZaRegistraciju.getOsoba());
            kontroler.sacuvajKorisnika(korisnikZaRegistraciju);
            korisnik = korisnikZaRegistraciju;
            System.out.println("USPESNO IZVRSENA METODA");
            return "pocetna.xhtml";
        } catch (Exception ex) {
            FacesContext context = FacesContext.getCurrentInstance();
            System.out.println("NEUSPESNO IZVRSENA METODA");
            //ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), ""));
            ex.printStackTrace();
        }
        return null;
    }

    public String proveriLozinku() {
        if (lozinkaZaUlazUIzmenu.equals(korisnik.getPassword())) {
            return "/clan/Edit.xhtml";
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lozinke se ne poklapaju!", ""));
        }
        return null;
    }

    public void saveChanges() {
        try {
            System.out.println("---- POZVALA SE METODA ZA saveChanges()! ----");
            kontroler.sacuvajKorisnika(korisnik);

            System.out.println("USPESNO IZVRSENA METODA");
            FacesContext context = FacesContext.getCurrentInstance();
            //ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspesno ste izmenili podatke!", ""));
        } catch (Exception ex) {
            FacesContext context = FacesContext.getCurrentInstance();
            System.out.println("NEUSPESNO IZVRSENA METODA");
            //ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), ""));
            ex.printStackTrace();
        }
    }

    public String deleteUser() {
        try {
            System.out.println("--- POZVALA SE METODA deleteUser() ----");

            kontroler.deleteUser(profilKorisnik);

            System.out.println("uspesno izvrsena metoda");
        } catch (Exception e) {

        }
        return null;
    }

    public String getAge() {
        return "" + (LocalDate.now().getYear() - profilKorisnik.getOsoba().getDatumRodjenja().getYear());
    }

    public String pokreniProfilnuStranu() {
        profilKorisnik = korisnik;
        return "profilnaStrana.xhtml";
    }

    public List<Korisnik> getListaKorisnika() {
        return listaKorisnika;
    }

    public void setListaKorisnika(List<Korisnik> listaKorisnika) {
        this.listaKorisnika = listaKorisnika;
    }

    public boolean isProfileSameAsUser(){
        return korisnik.equals(profilKorisnik);
    }

    public boolean areFriends(){
        Relationship rel = kontroler.areFriends(korisnik,profilKorisnik);
        
        return rel != null;
    }
    
    /* public String getParams() {
    System.out.println("--- POZVANA METODA GETPARAMS() ---");
    try {
    String email = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("email");
    String name = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("name");
    String dat_rodj = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("dat_rodj");
    String mesto = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("mesto");
    String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("mesto_id");
    
    System.out.println("");
    korisnik.setUsername(email);
    Osoba o = new Osoba() {
    };
    o.setIme(name);
    o.setDatumRodjenja(LocalDate.parse(dat_rodj));
    o.setMesto(new Mesto(Integer.parseInt(id), mesto));
    korisnik.setOsoba(o);
    System.out.println("--- USPESNO METODA GETPARAMS() ---");
    return "pocetna.xhtml";
    } catch (Exception ex) {
    System.out.println("GRESKA: " + ex.getMessage());
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), ""));
    System.out.println("--- NEUSPSNO METODA GETPARAMS() ---");
    }
    return null;
    }*/
}