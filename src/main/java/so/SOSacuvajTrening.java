/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import com.password.hashing.PasswordHashing;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Korisnik;
import model.Mesto;
import model.Sport;
import model.Trening;

/**
 *
 * @author Milan
 */
public class SOSacuvajTrening extends OpstaSO {

    private Trening trening;

    public SOSacuvajTrening(Trening trening) {
        this.trening = trening;
    }

    @Override
    protected void proveriPreduslove() throws Exception {
        try {
            Trening treningIzBaze = 
                    (Trening) session.createQuery("from Trening where datum = :datum and vremeOd = :vremeOd and vremeDo= :vremeDo")
                    .setParameter("datum", trening.getDatum())
                    .setParameter("vremeOd", trening.getVremeOd())
                    .setParameter("vremeDo", trening.getVremeDo()).getSingleResult();
            throw new Exception("Trening u tom terminu na taj dan postoji!");
        } catch (NoResultException e) {
            
        }
    }

    @Override
    protected void izvrsi() {
        session.save(trening);
    }

}
