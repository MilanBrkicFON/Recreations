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

    @Override
    public String toString() {
        return super.toString();
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


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idOsoba;
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
        return super.equals(obj);
    }

 
    
    
    
}
