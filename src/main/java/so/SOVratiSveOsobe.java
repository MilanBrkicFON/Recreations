/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import java.util.List;
import javax.persistence.TypedQuery;
import model.Mesto;
import model.Osoba;
import model.Sport;

/**
 *
 * @author Milan
 */
public class SOVratiSveOsobe extends OpstaSO{
    private List<Osoba> osobe;

    public SOVratiSveOsobe(List<Osoba> osobe) {
        this.osobe = osobe;
    }

    @Override
    protected void proveriPreduslove() {
        
    }

    @Override
    protected void izvrsi() {
        TypedQuery query;
        query = session.createQuery("from Osoba");
        osobe = query.getResultList();
    }

    public List<Osoba> getOsobe() {
        return osobe;
    }
 
}
