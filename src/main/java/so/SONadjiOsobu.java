/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import java.util.List;
import javax.persistence.TypedQuery;
import model.Clan;
import model.Mesto;
import model.Osoba;
import model.Sport;

/**
 *
 * @author Milan
 */
public class SONadjiOsobu extends OpstaSO {

    private String kriterijum;
    private List<Osoba> osobe;

    public SONadjiOsobu(String kriterijum, List<Osoba> osobe) {
        this.kriterijum = kriterijum;
        this.osobe = osobe;
    }
    

    @Override
    protected void proveriPreduslove() {

    }

    @Override
    protected void izvrsi() {
        TypedQuery<Osoba> query;
        query = session.createQuery("from Osoba where lower(concat(ime,' ',prezime)) like :s").setParameter("s", kriterijum + "%");
        osobe = query.getResultList();
    }

    public List<Osoba> getOsobe() {
        return osobe;
    }

}
