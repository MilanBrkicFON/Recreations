/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import com.password.hashing.PasswordHashing;
import java.io.Serializable;
import model.Clan;
import model.Korisnik;
import model.Mesto;
import model.Trening;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Osoba;
import model.Relationship;
import model.Sport;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Milan
 */
@Named(value = "Kontroler")
@ApplicationScoped
public class Kontroler implements Serializable {

    private Session session;

    public Kontroler(){
        
    }
    public void kreirajIUbaciMesto(Mesto m) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(m);
        session.getTransaction().commit();
    }

    public Korisnik vratiKorisnika(Korisnik korisnik) throws Exception {
        String hql = "from Korisnik WHERE username = :username";
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        PasswordHashing ph = new PasswordHashing(korisnik.getPassword());
        String pass = ph.generateHash();

        Query query = session.createQuery(hql);
        query.setParameter("username", korisnik.getUsername());

        Korisnik vracenKorisnik = (Korisnik) query.list().get(0);
        if (vracenKorisnik.getPassword().equals(pass)) {
            return vracenKorisnik;
        } else {
            throw new Exception("Korisnik sa datim korisnickim imenom ili sifrom ne postoji!");
        }

    }

    public void sacuvajKorisnika(Korisnik korisnik) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        PasswordHashing ph = new PasswordHashing(korisnik.getPassword());
        korisnik.setPassword(ph.generateHash());
        session.saveOrUpdate(korisnik);
        session.getTransaction().commit();
    }

    public List vratiSveClanove() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery<Clan> query;
        query = session.createQuery("from Clan");
        List lista = query.getResultList();
        session.getTransaction().commit();
        return lista;
    }

    public List vratiSveTrenere() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery<Clan> query;
        query = session.createQuery("from Trener");
        List lista = query.getResultList();
        session.getTransaction().commit();
        return lista;
    }

    private void dodajTrening(Trening t) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(t);
        session.getTransaction().commit();
    }

    public List<Mesto> vratiSvaMesta() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery query;
        query = session.createQuery("from Mesto");
        List lista = query.getResultList();
        session.getTransaction().commit();
        return lista;
    }

    public List<Trening> vratiSveTreninge() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery query;
        query = session.createQuery("from Trening");
        List<Trening> lista = query.getResultList();
        session.getTransaction().commit();

        return lista;
    }

    public static void main(String[] args) {
        Kontroler kontroler = new Kontroler();

        Relationship o = kontroler.areFriends(new Korisnik("", "", new Osoba(101)), new Korisnik("", "", new Osoba(1002)));

        System.out.println(o);
    }

    public List<Korisnik> vratiSveKorisnike() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery query;
        query = session.createQuery("from Korisnik");
        List lista = query.getResultList();
        session.getTransaction().commit();
        return lista;
    }

    public List<Sport> vratiSveSportove() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery query;
        query = session.createQuery("from Sport");
        List lista = query.getResultList();
        session.getTransaction().commit();
        return lista;
    }

    public Object pronadjiMesto(int parseInt) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Mesto mesto = session.find(Mesto.class, parseInt);

        return mesto;
    }

    public void sacuvajOsobu(Osoba osoba) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(osoba);
        session.getTransaction().commit();
    }

    public Object pronadjiSport(int parseInt) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Sport sport = session.find(Sport.class, parseInt);

        return sport;
    }

    public Osoba pronadjiOsobu(int parseInt) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Osoba osoba = session.find(Osoba.class, parseInt);

        return osoba;
    }

    public List<Osoba> vratiSveOsobe() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery<Clan> query;
        query = session.createQuery("from Osoba");
        List lista = query.getResultList();
        session.getTransaction().commit();
        return lista;
    }

    public List<Osoba> vratiSveOsobe(String pretraga) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery<Clan> query;
        query = session.createQuery("from Osoba where lower(concat(ime,' ',prezime)) like :s").setParameter("s", pretraga + "%");
        List lista = query.getResultList();
        session.getTransaction().commit();
        return lista;
    }

    public void deleteUser(Korisnik korisnik) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(korisnik.getOsoba());
        session.delete(korisnik);

        session.getTransaction().commit();
    }

    public Relationship areFriends(Korisnik korisnik, Korisnik profilKorisnik) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery<Relationship> query;
        query = session.createQuery("from Relationship where osoba_1_id = :id1 AND osoba_2_id = :id2 and status = 1")
                .setParameter("id1", korisnik.getOsoba())
                .setParameter("id2", profilKorisnik.getOsoba());
        try {
            Relationship o = query.getSingleResult();
            session.getTransaction().commit();
            return o;
        } catch (NoResultException e) {
            return null;
        }

    }

}
