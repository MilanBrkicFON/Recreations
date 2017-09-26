/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

/**
 *
 * @author Milan
 */
public abstract class OpstaSO {
    protected Session session;
    protected Transaction tx;
    
    public void opsteIzvrsenje() throws Exception{
        session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("SESIJA OTVORENA");
        tx = null;
        try{
            tx = session.beginTransaction();
            proveriPreduslove();
            izvrsi();
            System.out.println("IZVRSENA METODA OD STRANE: "+ this.getClass().getName());
            tx.commit();
        }catch(Exception e){
            System.out.println("U ROLLBACK:");
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }finally{
            System.out.println("SESIJA ZATVORENA");
            session.close();
        }
    }

    protected abstract void proveriPreduslove() throws Exception ;
    protected abstract void izvrsi() throws Exception;
}
