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

/**
 *
 * @author Milan
 */
public class SOVratiSveSportove extends OpstaSO{
    private List<Sport> sportovi;

    public SOVratiSveSportove(List<Sport> sportovi) {
        this.sportovi = sportovi;
    }

    @Override
    protected void proveriPreduslove() {
        
    }

    @Override
    protected void izvrsi() {
        TypedQuery query;
        query = session.createQuery("from Sport");
        sportovi = query.getResultList();
    }

    public List<Sport> getSportovi() {
        return sportovi;
    }
 
}
