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
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import model.Relationship;
import utility.Kontroler;

/**
 *
 * @author Milan
 */
@Named(value = "friendsRequest")
@SessionScoped
public class FriendsRequest implements Serializable{

    private List<Relationship> friends = new ArrayList<>();
    
    @Inject
    private Kontroler kontroler;
    @Inject
    private MBKorisnik korisnik;
    /**
     * Creates a new instance of Notifications
     */
    public FriendsRequest() {
    }
    
    @PostConstruct
    public void init(){
        friends = new ArrayList<>();
    }
    
    public List<Relationship> get(){
        friends = kontroler.getAllFriendsRequest(korisnik.getKorisnik().getOsoba());
        return friends;
    }

    public List<Relationship> getFriends() {
        return friends;
    }

    public void setFriends(List<Relationship> friends) {
        this.friends = friends;
    }
    
    public void accept(Relationship rel){
        System.out.println("---- POZVANA METODA accept() ----");
        System.out.println(rel);
        rel.setStatus(Relationship.Status.FRIENDS);
        kontroler.sacuvaj(rel);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "You accepted request!", ""));
    }
    
    public void reject(Relationship rel){
        rel.setStatus(Relationship.Status.NOT_FRIENDS);
        kontroler.sacuvaj(rel);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "You rejected request!", ""));
    }
}
