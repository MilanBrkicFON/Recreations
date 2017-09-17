/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Milan
 */
@Entity
@Table(name = "trening", catalog = "pssunce"
)
public class Trening implements Serializable {

    @ManyToMany(fetch = FetchType.LAZY)
    //@LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "tclan",
            joinColumns = {
                @JoinColumn(name = "treningId", referencedColumnName = "treningId")},
            inverseJoinColumns = {
                @JoinColumn(name = "clanId", referencedColumnName = "idOsoba")}
    )
    private List<Clan> clanovi;

    @ManyToMany(fetch = FetchType.LAZY)
    //@LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "tt",
            joinColumns = @JoinColumn(name = "treningId", referencedColumnName = "treningId"),
            inverseJoinColumns =@JoinColumn(name = "trenerId", referencedColumnName = "idOsoba")
    )
    private List<Trener> treneri;

    @Column(name = "vremeOd")
    private LocalTime vremeOd;

    @Column(name = "vremeDo")
    private LocalTime vremeDo;

    @Column(name = "datum")
    private LocalDate datum;

    @ManyToOne
    @JoinColumn(name = "sport")
    private Sport sport;
    
    @Id
    @Column(name = "treningId")
    private int treningId;
    
    private String nazivTreninga;
    
    public Trening() {
    }

    public Trening(int treningId) {
        this.treningId = treningId;
    }

    public Trening(LocalTime vremeOd, LocalTime vremeDo, LocalDate datum, String nazivTreninga) {
        this.vremeOd = vremeOd;
        this.vremeDo = vremeDo;
        this.datum = datum;
        this.nazivTreninga = nazivTreninga;
    }

    
    public Trening(LocalTime vremeOd, LocalTime vremeDo, LocalDate datum) {
        this.vremeOd = vremeOd;
        this.vremeDo = vremeDo;
        this.datum = datum;
    }

    public Trening(LocalTime vremeOd, LocalTime vremeDo, LocalDate datum, int treningId) {
        this.vremeOd = vremeOd;
        this.vremeDo = vremeDo;
        this.datum = datum;
        this.treningId = treningId;
    }

    
    @Override
    public String toString() {
        return "----- SPORT: "+ this.sport +" Datum: " + datum + " Vreme od: " + vremeOd + " vreme do: " + vremeDo + "\n clanovi: " + clanovi + "\n treneri: " + treneri;
    }

    public List<Clan> getClanovi() {
        return clanovi;
    }

    public void setClanovi(List<Clan> clanovi) {
        this.clanovi = clanovi;
    }

    public List<Trener> getTreneri() {
        return treneri;
    }

    public void setTreneri(List<Trener> treneri) {
        this.treneri = treneri;
    }

    public LocalTime getVremeOd() {
        return vremeOd;
    }

    public void setVremeOd(LocalTime vremeOd) {
        this.vremeOd = vremeOd;
    }

    public LocalTime getVremeDo() {
        return vremeDo;
    }

    public void setVremeDo(LocalTime vremeDo) {
        this.vremeDo = vremeDo;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public int getTreningId() {
        return treningId;
    }

    public void setTreningId(int treningId) {
        this.treningId = treningId;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public String getNazivTreninga() {
        return nazivTreninga;
    }

    public void setNazivTreninga(String nazivTreninga) {
        this.nazivTreninga = nazivTreninga;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Trening other = (Trening) obj;

//        postavi uslov za jednakost!!
//        if (this.vremeDo - other.vremeOd > 0 && this.vremeOd - other.vremeDo < 0) {
//            return false;
//        }
        return true;
    }

}
