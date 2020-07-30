package com.educom.restclient.model;


import java.util.Date;
import java.util.List;


public class Vertrag {

    private long id;
    private Date  vertragDatum;

    private Schuler schuler;

    private List<Kurs> kursList;

    public Vertrag(Date vertragDatum, Schuler schuler, List<Kurs> kursList) {
        this.vertragDatum = vertragDatum;
        this.schuler = schuler;
        this.kursList = kursList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getVertragDatum() {
        return vertragDatum;
    }

    public void setVertragDatum(Date vertragDatum) {
        this.vertragDatum = vertragDatum;
    }

    public Schuler getSchuler() {
        return schuler;
    }

    public void setSchuler(Schuler schuler) {
        this.schuler = schuler;
    }

    public List<Kurs> getKursList() {
        return kursList;
    }

    public void setKursList(List<Kurs> kursList) {
        this.kursList = kursList;
    }
}
