/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import com.password.hashing.PasswordHashing;
import java.util.List;
import javax.persistence.TypedQuery;
import model.Korisnik;
import model.Mesto;
import model.Sport;
import model.Trening;

/**
 *
 * @author Milan
 */
public class SOIzmeniTrening extends OpstaSO {

    private Trening trening;

    public SOIzmeniTrening(Trening trening) {
        this.trening = trening;
    }

    @Override
    protected void proveriPreduslove() throws Exception {

    }

    @Override
    protected void izvrsi() {
        session.update(trening);
    }

}
