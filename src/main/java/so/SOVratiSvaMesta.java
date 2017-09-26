/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import java.util.List;
import javax.persistence.TypedQuery;
import model.Mesto;

/**
 *
 * @author Milan
 */
public class SOVratiSvaMesta extends OpstaSO{
    private List<Mesto> mesta;

    public SOVratiSvaMesta(List<Mesto> mesta) {
        this.mesta = mesta;
    }

    @Override
    protected void proveriPreduslove() {
        
    }

    @Override
    protected void izvrsi() {
        TypedQuery query;
        query = session.createQuery("from Mesto");
        mesta = query.getResultList();
    }

    public List<Mesto> getMesta() {
        return mesta;
    }
 
    
}
