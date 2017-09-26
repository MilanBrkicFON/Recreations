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
public class SOObrisiKorisnika extends OpstaSO {

    private Korisnik korisnik;

    public SOObrisiKorisnika(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    protected void proveriPreduslove() throws Exception {

    }

    @Override
    protected void izvrsi() {
        session.delete(korisnik.getOsoba());
        session.delete(korisnik);
    }

}
