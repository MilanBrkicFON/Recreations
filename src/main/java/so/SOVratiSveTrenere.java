/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import java.util.List;
import javax.persistence.TypedQuery;
import model.Mesto;
import model.Sport;
import model.Trener;

/**
 *
 * @author Milan
 */
public class SOVratiSveTrenere extends OpstaSO{
    private List<Trener> treneri;

    public SOVratiSveTrenere(List<Trener> treneri) {
        this.treneri = treneri;
    }

    @Override
    protected void proveriPreduslove() {
        
    }

    @Override
    protected void izvrsi() {
        TypedQuery query;
        query = session.createQuery("from Trener");
        treneri = query.getResultList();
    }

    public List<Trener> getTreneri() {
        return treneri;
    }
 
    
}
