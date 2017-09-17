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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Milan
 */
@Entity
@Table(name = "trener", catalog = "pssunce"
)
@DiscriminatorValue("T")
public class Trener extends Osoba implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trenerID;
    private int godineRada;
    private String kratakCV;

    @ManyToOne
    @JoinColumn(name = "sportID")
    private Sport sport;

    public Trener() {
    }

    public Trener(String ime, String prezime, LocalDate datumRodjenja, char pol, Mesto mesto) {
        super(ime, prezime, datumRodjenja, pol, mesto);
    }

    public Trener(int godineRada, String kratakCV, Sport sport, String ime, String prezime, LocalDate datumRodjenja, char pol, Mesto mesto) {
        super(ime, prezime, datumRodjenja, pol, mesto);
        this.godineRada = godineRada;
        this.kratakCV = kratakCV;
        this.sport = sport;
    }

    public int getTrenerID() {
        return trenerID;
    }

    public void setTrenerID(int trenerID) {
        this.trenerID = trenerID;
    }

    public int getGodineRada() {
        return godineRada;
    }

    public void setGodineRada(int godineRada) {
        this.godineRada = godineRada;
    }

    public String getKratakCV() {
        return kratakCV;
    }

    public void setKratakCV(String kratakCV) {
        this.kratakCV = kratakCV;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return trenerID +" "+ super.toString();
    }

}
