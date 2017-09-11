/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Milan
 */
@Entity
public class Relationship implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "osoba_1_id")
    private Osoba osoba_1_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "osoba_2_id")
    private Osoba osoba_2_id;

    private int status;

    @Id
    @ManyToOne
    @JoinColumn(name = "akcija_osoba_id")
    private Osoba akcija_osoba_id;

    public Relationship() {
    }

    public Relationship(Osoba osoba_1_id, Osoba osoba_2_id, int status, Osoba akcija_osoba_id) {
        this.osoba_1_id = osoba_1_id;
        this.osoba_2_id = osoba_2_id;
        this.status = status;
        this.akcija_osoba_id = akcija_osoba_id;
    }

    public Osoba getOsoba_1_id() {
        return osoba_1_id;
    }

    public void setOsoba_1_id(Osoba osoba_1_id) {
        this.osoba_1_id = osoba_1_id;
    }

    public Osoba getOsoba_2_id() {
        return osoba_2_id;
    }

    public void setOsoba_2_id(Osoba osoba_2_id) {
        this.osoba_2_id = osoba_2_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Osoba getAkcija_osoba_id() {
        return akcija_osoba_id;
    }

    public void setAkcija_osoba_id(Osoba akcija_osoba_id) {
        this.akcija_osoba_id = akcija_osoba_id;
    }

    @Override
    public String toString() {
        return "Relationship{" + "osoba_1_id=" + osoba_1_id + ", osoba_2_id=" + osoba_2_id + ", status=" + status + ", akcija_osoba_id=" + akcija_osoba_id + '}';
    }
    
    
    
    private interface Status {
        public static final int NOT_FRIENDS = 0;
        public static final int FRIENDS = 1;
        public static final int PENDDING = 2;
    }
}
