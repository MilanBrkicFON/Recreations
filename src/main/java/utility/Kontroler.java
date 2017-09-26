/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import com.password.hashing.PasswordHashing;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Clan;
import model.Korisnik;
import model.Mesto;
import model.Trening;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Osoba;
import model.Relationship;
import model.Sport;
import model.Trener;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import so.OpstaSO;
import so.SOIzmeniKorisnika;
import so.SOIzmeniTrening;
import so.SONadjiOsobu;
import so.SOObrisiKorisnika;
import so.SOObrisiTrening;
import so.SOPrijaviKorisnika;
import so.SOSacuvajKorisnika;
import so.SOSacuvajTrening;
import so.SOVratiSvaMesta;
import so.SOVratiSveOsobe;
import so.SOVratiSveSportove;
import so.SOVratiSveTrenere;
import so.SOVratiSveTreninge;

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

    public Korisnik vratiKorisnika(Korisnik korisnik) throws Exception {
        SOPrijaviKorisnika so = new SOPrijaviKorisnika(korisnik);
        so.opsteIzvrsenje();
        return so.getKorisnik();
//        session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
//
//        String pass = null;
//        try {
//            tx = session.beginTransaction();
//
//            PasswordHashing ph = new PasswordHashing(korisnik.getPassword());
//            pass = ph.generateHash();
//
//            Korisnik k = session.find(Korisnik.class, korisnik.getUsername());
//            
//            if (k == null) {
//                throw new Exception("Korisnik sa datim korisnickim imenom ili sifrom ne postoji!");
//            }
//
//            if (k.getPassword().equals(pass)) {
//                return k;
//            } else {
//                throw new Exception("Korisnicka lozinka je netacna!");
//            }
//        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//                throw e;
//            }
//        } finally {
//            session.close();
//        }
//        return null;
    }

    public void sacuvajKorisnika(Korisnik korisnik) throws Exception {
        OpstaSO so = new SOSacuvajKorisnika(korisnik);
        so.opsteIzvrsenje();
//        
//        session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            Korisnik k = session.find(Korisnik.class, korisnik.getUsername());
//            
//            if(k != null){
//                throw new Exception("Korisnik sa datim korisnickim imenom vec postoji!");
//            }
//            PasswordHashing ph = new PasswordHashing(korisnik.getPassword());
//            korisnik.setPassword(ph.generateHash());
//            session.save(korisnik);
//            tx.commit();
//            System.out.println("uspesno je sacuvan Korisnik." + this.getClass());
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            throw new Exception("Korisnicko ime vec postoji!");
//        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            System.out.println("NIJE USPESNO sacuvan Korisnik." + this.getClass());
//            throw e;
//        } finally {
//            session.close();
//        }
    }

    public void izmeniKorisnika(Korisnik korisnik) throws Exception {
        OpstaSO so = new SOIzmeniKorisnika(korisnik);
        so.opsteIzvrsenje();
//        
//        session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            session.update(korisnik.getOsoba());
//            session.update(korisnik);
//            tx.commit();
//            System.out.println("uspesno je uradjena izmena podataka." + this.getClass());
//        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            System.out.println("NIJE USPESNO uradjena izmena podataka." + this.getClass());
//        } finally {
//            session.close();
//        }
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

    public List<Trener> vratiSveTrenere() throws Exception {
        SOVratiSveTrenere so = new SOVratiSveTrenere(new ArrayList<Trener>());
        so.opsteIzvrsenje();
        return so.getTreneri();
//        session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        TypedQuery<Trener> query;
//        query = session.createQuery("from Trener");
//        List<Trener> lista = query.getResultList();
//        session.close();
//        return lista;
    }

//    private void dodajTrening(Trening t) throws Exception {
//        OpstaSO so = new SOSacuvajTrening(t);
//        so.opsteIzvrsenje();
//        
////        session = HibernateUtil.getSessionFactory().openSession();
////        Transaction tx = null;
////        try {
////            tx = session.beginTransaction();
////            session.saveOrUpdate(t);
////            tx.commit();
////        } catch (Exception e) {
////            if (tx != null) {
////                tx.rollback();
////            }
////        } finally {
////            session.close();
////        }
//    }

    public List<Mesto> vratiSvaMesta() throws Exception {
        SOVratiSvaMesta so = new SOVratiSvaMesta(new ArrayList<Mesto>());
        so.opsteIzvrsenje();
        return so.getMesta();
//        session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        TypedQuery query;
//        query = session.createQuery("from Mesto");
//        List lista = query.getResultList();
//        session.close();
//        return lista;
    }

    public List<Trening> vratiSveTreninge() throws Exception {
        SOVratiSveTreninge so = new SOVratiSveTreninge(new ArrayList<Trening>());
        so.opsteIzvrsenje();
        return so.getTreninzi();
//        session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        TypedQuery query;
//        query = session.createQuery("from Trening");
//        List<Trening> lista = query.getResultList();
//        for (Trening trening : lista) {
//            Hibernate.initialize(trening.getTreneri());
//            Hibernate.initialize(trening.getClanovi());
//        }
//        session.close();
//        return lista;
    }

    public static void main(String[] args) {
        Kontroler kontroler = new Kontroler();

        try {
            kontroler.sacuvajKorisnika(new Korisnik("novi", "novi", new Clan("", 2017, "M", "M", LocalDate.now(), 'M', new Mesto(11000))));
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public List<Sport> vratiSveSportove() throws Exception {
        SOVratiSveSportove so = new SOVratiSveSportove(new ArrayList<Sport>());
        so.opsteIzvrsenje();
        return so.getSportovi();
//        session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        TypedQuery query;
//        query = session.createQuery("from Sport");
//        List lista = query.getResultList();
//        session.close();
//        return lista;
    }

    public Object pronadjiMesto(int parseInt) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Mesto mesto = session.find(Mesto.class, parseInt);
        session.close();
        return mesto;
    }

//    public void sacuvajOsobu(Osoba osoba) {
//        session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
//        try {
//
//            tx = session.beginTransaction();
//            session.saveOrUpdate(osoba);
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//        } finally {
//            session.close();
//        }
//    }

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

    public List<Osoba> vratiSveOsobe() throws Exception {
        SOVratiSveOsobe so = new SOVratiSveOsobe(new ArrayList<Osoba>());
        so.opsteIzvrsenje();
        return so.getOsobe();
//        session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        TypedQuery<Clan> query;
//        query = session.createQuery("from Osoba");
//        List lista = query.getResultList();
//        session.getTransaction().commit();
//        return lista;
    }

    public List<Osoba> vratiSveOsobe(String pretraga) throws Exception {
        SONadjiOsobu so = new SONadjiOsobu(pretraga,new ArrayList<Osoba>());
        so.opsteIzvrsenje();
        return so.getOsobe();
//        session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        TypedQuery<Clan> query;
//        query = session.createQuery("from Osoba where lower(concat(ime,' ',prezime)) like :s").setParameter("s", pretraga + "%");
//        List lista = query.getResultList();
//        session.close();
//        return lista;
    }

    public void deleteUser(Korisnik korisnik) throws Exception {
        OpstaSO so = new SOObrisiKorisnika(korisnik);
        so.opsteIzvrsenje();
//        
//        session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
//        try {
//
//            tx = session.beginTransaction();
//
//            session.delete(korisnik.getOsoba());
//            session.delete(korisnik);
//
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//        } finally {
//            session.close();
//        }
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
        OpstaSO so = new SOIzmeniTrening(trening);
        so.opsteIzvrsenje();
//        
//        session = HibernateUtil.getSessionFactory().getCurrentSession();
//        
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            
//            session.update(trening);
//            
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            throw e;
//        } finally{
//            session.close();
//        }
    }

    public void sacuvaj(Trening noviTrening) throws Exception{
        
        OpstaSO so = new SOSacuvajTrening(noviTrening);
        so.opsteIzvrsenje();
        
//        session = HibernateUtil.getSessionFactory().getCurrentSession();
//
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            session.save(noviTrening);
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            throw e;
//        } finally {
//            session.close();
//        }
    }

    public void obrisi(Trening trening) throws Exception {
        OpstaSO so = new SOObrisiTrening(trening);
        so.opsteIzvrsenje();
//        session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
//        try {
//
//            tx = session.beginTransaction();
//
//            session.delete(trening);
//
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//        } finally {
//            session.close();
//        }
    }

}
