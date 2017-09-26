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
import model.Trening;
import org.hibernate.Hibernate;

/**
 *
 * @author Milan
 */
public class SOVratiSveTreninge extends OpstaSO {

    private List<Trening> treninzi;

    public SOVratiSveTreninge(List<Trening> treninzi) {
        this.treninzi = treninzi;
    }

    @Override
    protected void proveriPreduslove() {

    }

    @Override
    protected void izvrsi() {
        TypedQuery query;
        query = session.createQuery("from Trening");
        treninzi = query.getResultList();
        for (Trening trening : treninzi) {
            Hibernate.initialize(trening.getTreneri());
            Hibernate.initialize(trening.getClanovi());
        }
    }

    public List<Trening> getTreninzi() {
        return treninzi;
    }

}
