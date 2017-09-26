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

/**
 *
 * @author Milan
 */
public class SOSacuvajKorisnika extends OpstaSO {

    private Korisnik korisnik;

    public SOSacuvajKorisnika(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    protected void proveriPreduslove() throws Exception {
        Korisnik k = session.find(Korisnik.class, korisnik.getUsername());
        if (k != null) {
            throw new Exception("Korisnik sa datim korisnickim imenom vec postoji!");
        }
    }

    @Override
    protected void izvrsi() {
        PasswordHashing ph = new PasswordHashing(korisnik.getPassword());
        korisnik.setPassword(ph.generateHash());
        session.save(korisnik);
    }

}
