/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Milan
 */
@Entity
public class Korisnik implements Serializable {

    @Id
    @Basic(optional = false)
    private String username;

    private String password;

    @JoinColumn(name = "osoba", referencedColumnName = "idOsoba")
    @ManyToOne
    private Osoba osoba;

    public Korisnik() {
        osoba = new Osoba();
    }

    public Korisnik(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Korisnik(String username, String password, Osoba osoba) {
        this.username = username;
        this.password = password;
        this.osoba = osoba;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

    @Override
    public String toString() {
        return "@" + username + " - " + osoba;
    }

}
