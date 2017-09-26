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
public class SOPrijaviKorisnika extends OpstaSO {

    private Korisnik korisnik;
    private Korisnik korisnikIzBaze;
    
    public SOPrijaviKorisnika(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    protected void proveriPreduslove() throws Exception {
        korisnikIzBaze = session.find(Korisnik.class, korisnik.getUsername());
        System.out.println("KORISNIK IZ BAZE: "+ korisnikIzBaze);
        if (korisnikIzBaze == null) {
            throw new Exception("Korisnik sa datim korisnickim imenom ili sifrom ne postoji!");
        }
    }

    @Override
    protected void izvrsi() throws Exception{
        PasswordHashing ph = new PasswordHashing(korisnik.getPassword());
        String pass = ph.generateHash();

        if (korisnikIzBaze.getPassword().equals(pass)) {
            korisnik = korisnikIzBaze;
        } else {
            throw new Exception("Korisnicka lozinka je netacna!");
        }
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    
}
