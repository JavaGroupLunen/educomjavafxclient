package com.educom.restclient.model;


import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
public class Schuler extends Person{
    private long id;
    private String vater;
    private String mutter;


    private  Schule schule;

    private Set<Kurs> kurses = new HashSet<>();

    public Schuler(long id, String vater, String mutter, Schule schule, Set<Kurs> kurses) {
        this.id = id;
        this.vater = vater;
        this.mutter = mutter;
        this.schule = schule;
        this.kurses = kurses;
    }

    public Schuler(String vater, String mutter) {
        this.vater = vater;
        this.mutter = mutter;
    }

    public Schuler() {
    }

    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getVater() {
        return vater;
    }

    public void setVater(String vater) {
        this.vater = vater;
    }

    public String getMutter() {
        return mutter;
    }

    public void setMutter(String mutter) {
        this.mutter = mutter;
    }

    public Schule getSchule() {
        return schule;
    }

    public void setSchule(Schule schule) {
        this.schule = schule;
    }

    public Set<Kurs> getKurses() {
        return kurses;
    }

    public void setKurses(Set<Kurs> kurses) {
        this.kurses = kurses;
    }
}
