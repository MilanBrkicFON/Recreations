/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Milan
 */
@Entity
@Table(name="clan"
    ,catalog="pssunce"
)
@DiscriminatorValue("C")
public class Clan extends Osoba implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clanID;
    private String imeRoditelja;
    private int godinaUpisa;
    
    @Transient
    private boolean promenjen = false;
    
    public Clan() {
    }

    public Clan(String ime, String prezime, LocalDate datumRodjenja, char pol, Mesto mesto) {
        super(ime, prezime, datumRodjenja, pol, mesto);
    }

    public Clan(String imeRoditelja, int godinaUpisa, String ime, String prezime, LocalDate datumRodjenja, char pol, Mesto mesto) {
        super(ime, prezime, datumRodjenja, pol, mesto);
        this.imeRoditelja = imeRoditelja;
        this.godinaUpisa = godinaUpisa;
    }

    
    public boolean isPromenjen() {
        return promenjen;
    }

    public void setPromenjen(boolean promenjen) {
        this.promenjen = promenjen;
    }

    public Clan(int clanID) {
        this.clanID = clanID;
    }

   
    @Override
    public String toString() {
        return super.toString();
    }

    public int getClanID() {
        return clanID;
    }

    public void setClanID(int clanID) {
        this.clanID = clanID;
    }


    public String getImeRoditelja() {
        return imeRoditelja;
    }

    public void setImeRoditelja(String imeRoditelja) {
        this.imeRoditelja = imeRoditelja;
    }


    public int getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(int godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }


    public String getAttributes(){
        return clanID + " "+ godinaUpisa + " ";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.clanID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clan other = (Clan) obj;
        if (this.idOsoba != other.idOsoba) {
            return false;
        }
        return true;
    }
    
    
    
}
