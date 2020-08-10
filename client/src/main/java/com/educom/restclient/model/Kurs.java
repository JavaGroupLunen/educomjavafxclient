package com.educom.restclient.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Kurs {

    private long id;
    private String name;
    private String raum;
    private Double price;
    private int dauer;
    private int kurslang;
    private Date anfangenAb;
    private Date endeBis;
    private KursType kurstype;
    private Lehre lehre;

    private Set<Schuler> schulerSet = new HashSet<>();

    public Kurs(String name) {
        this.name = name;
    }

    public Kurs(String name, String raum, Lehre lehre) {
        this.name = name;
        this.raum = raum;
        this.lehre = lehre;
       
    }

    public Kurs() {
    }

    public Kurs(String name, String raum) {
    }

    public Lehre getLehre() {
        return lehre;
    }

    public void setLehre(Lehre lehre) {
        this.lehre = lehre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRaum() {
        return raum;
    }

    public void setRaum(String raum) {
        this.raum = raum;
    }



    public Set<Schuler> getSchulerSet() {
        return schulerSet;
    }

    public void setSchulerSet(Set<Schuler> schulerSet) {
        this.schulerSet = schulerSet;
    }
}
