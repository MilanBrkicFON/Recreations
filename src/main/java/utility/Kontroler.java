/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import com.password.hashing.PasswordHashing;
import java.io.Serializable;
import java.util.ArrayList;
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
import model.Trener;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Milan
 */
@Named(value = "Kontroler")
@ApplicationScoped
public class Kontroler implements Serializable {

    private Session session;

    public Kontroler() {

    }

    public void kreirajIUbaciMesto(Mesto m) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            session.saveOrUpdate(m);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

    }

    public Korisnik vratiKorisnika(Korisnik korisnik) throws Exception {
        String hql = "from Korisnik WHERE username = :username";
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        Korisnik vracenKorisnik = null;
        String pass = null;
        try {
            tx = session.beginTransaction();

            PasswordHashing ph = new PasswordHashing(korisnik.getPassword());
            pass = ph.generateHash();

            Query query = session.createQuery(hql);
            query.setParameter("username", korisnik.getUsername());

            vracenKorisnik = (Korisnik) query.list().get(0);
            if (vracenKorisnik.getPassword().equals(pass)) {
                return vracenKorisnik;
            } else {
                throw new Exception("Korisnik sa datim korisnickim imenom ili sifrom ne postoji!");
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
        return null;
    }

    public void sacuvajKorisnika(Korisnik korisnik) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            PasswordHashing ph = new PasswordHashing(korisnik.getPassword());
            korisnik.setPassword(ph.generateHash());
            session.save(korisnik);
            tx.commit();
            System.out.println("uspesno je uradjena izmena podataka." + this.getClass());
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("NIJE USPESNO uradjena izmena podataka." + this.getClass());
        } finally {
            session.close();
        }
    }

    public void izmeniKorisnika(Korisnik korisnik) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(korisnik.getOsoba());
            session.update(korisnik);
            tx.commit();
            System.out.println("uspesno je uradjena izmena podataka." + this.getClass());
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("NIJE USPESNO uradjena izmena podataka." + this.getClass());
        } finally {
            session.close();
        }
    }

    public List vratiSveClanove() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery<Clan> query;
        query = session.createQuery("from Clan");
        List lista = query.getResultList();
        session.close();
        return lista;

    }

    public List<Trener> vratiSveTrenere() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery<Trener> query;
        query = session.createQuery("from Trener");
        List<Trener> lista = query.getResultList();
        session.close();
        return lista;
    }

    private void dodajTrening(Trening t) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(t);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public List<Mesto> vratiSvaMesta() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery query;
        query = session.createQuery("from Mesto");
        List lista = query.getResultList();
        session.close();
        return lista;
    }

    public List<Trening> vratiSveTreninge() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery query;
        query = session.createQuery("from Trening");
        List<Trening> lista = query.getResultList();
        for (Trening trening : lista) {
            Hibernate.initialize(trening.getTreneri());
            Hibernate.initialize(trening.getClanovi());
        }
        session.close();
        return lista;
    }

    public static void main(String[] args) {
        Kontroler kontroler = new Kontroler();

    }

    public List<Korisnik> vratiSveKorisnike() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery query;
        query = session.createQuery("from Korisnik");
        List lista = query.getResultList();
        session.close();
        return lista;
    }

    public List<Sport> vratiSveSportove() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery query;
        query = session.createQuery("from Sport");
        List lista = query.getResultList();
        session.close();
        return lista;
    }

    public Object pronadjiMesto(int parseInt) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Mesto mesto = session.find(Mesto.class, parseInt);
        session.close();
        return mesto;
    }

    public void sacuvajOsobu(Osoba osoba) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            session.saveOrUpdate(osoba);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public Object pronadjiSport(int parseInt) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Sport sport = session.find(Sport.class, parseInt);
        session.close();
        return sport;
    }

    public Osoba pronadjiOsobu(int parseInt) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Osoba osoba = session.find(Osoba.class, parseInt);
        session.close();
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
        session.close();
        return lista;
    }

    public void deleteUser(Korisnik korisnik) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();

            session.delete(korisnik.getOsoba());
            session.delete(korisnik);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public Relationship areFriends(Korisnik korisnik, Korisnik profilKorisnik) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            TypedQuery<Relationship> query;
            query = session.createQuery("from Relationship where osoba_1_id = :id1 AND osoba_2_id = :id2 and status = 1")
                    .setParameter("id1", korisnik.getOsoba())
                    .setParameter("id2", profilKorisnik.getOsoba());

            Relationship o = query.getSingleResult();
            return o;
        } catch (NoResultException e) {
            return null;
        } finally {
            session.close();
        }
    }

    public Korisnik getSelectedUser(Osoba osoba) {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        TypedQuery<Korisnik> query;
        try {
            query = session.createQuery("from Korisnik where osoba = :o")
                    .setParameter("o", osoba);
            Korisnik k = query.getSingleResult();
            return k;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    public void promeniLozinku(String newPass, Korisnik profilKorisnik) throws Exception {
        session = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            PasswordHashing ph = new PasswordHashing(newPass);
            String hash = ph.generateHash();
            profilKorisnik.setPassword(hash);
            session.update("password", profilKorisnik);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            session.close();
        }
    }

    public List<Relationship> getAllFriendsRequest(Osoba osoba) {
        session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        List<Relationship> friendsReq = new ArrayList<>();
        TypedQuery<Relationship> query;

        query = session.createQuery("from Relationship where (osoba_1_id = :s or osoba_2_id= :s) and status = :p and akcija_osoba_id <> :s")
                .setParameter("s", osoba)
                .setParameter("p", Relationship.Status.PENDDING);
        friendsReq = query.getResultList();
        session.close();

        return friendsReq;
    }

    public void addFriend(Korisnik korisnik, Korisnik profilKorisnik) {

        session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(new Relationship(korisnik.getOsoba(), profilKorisnik.getOsoba(), Relationship.Status.PENDDING, korisnik.getOsoba()));
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

    }

    public void sacuvaj(Relationship rel) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(rel);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void izmeni(Trening trening) throws Exception{
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            session.update(trening);
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally{
            session.close();
        }
    }

}
