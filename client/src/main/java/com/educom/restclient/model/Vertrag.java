package com.educom.restclient.model;

import java.util.Date;
import java.util.List;


public class Vertrag {

    private long id;
    private Date vertragDatum;
    private Date anfangsdatum;
    private Date endeDatum;
    private ZahlungsType zahlungstype;
    private Double einmaligeprice;
    private Double anmeldeGebuhr;
    private Double materialprice;
    private Double totalprice;
    private Double monatlischeRate;
    private Double restbetrag;
    private int rabatprice;
    private int rabatPercent;

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

    public Date getAnfangsdatum() {
        return anfangsdatum;
    }

    public void setAnfangsdatum(Date anfangsdatum) {
        this.anfangsdatum = anfangsdatum;
    }

    public Date getEndeDatum() {
        return endeDatum;
    }

    public void setEndeDatum(Date endeDatum) {
        this.endeDatum = endeDatum;
    }

    public ZahlungsType getZahlungstype() {
        return zahlungstype;
    }

    public void setZahlungstype(ZahlungsType zahlungstype) {
        this.zahlungstype = zahlungstype;
    }

    public Double getEinmaligeprice() {
        return einmaligeprice;
    }

    public void setEinmaligeprice(Double einmaligeprice) {
        this.einmaligeprice = einmaligeprice;
    }

    public Double getAnmeldeGebuhr() {
        return anmeldeGebuhr;
    }

    public void setAnmeldeGebuhr(Double anmeldeGebuhr) {
        this.anmeldeGebuhr = anmeldeGebuhr;
    }

    public Double getMaterialprice() {
        return materialprice;
    }

    public void setMaterialprice(Double materialprice) {
        this.materialprice = materialprice;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public Double getMonatlischeRate() {
        return monatlischeRate;
    }

    public void setMonatlischeRate(Double monatlischeRate) {
        this.monatlischeRate = monatlischeRate;
    }

    public Double getRestbetrag() {
        return restbetrag;
    }

    public void setRestbetrag(Double restbetrag) {
        this.restbetrag = restbetrag;
    }

    public int getRabatprice() {
        return rabatprice;
    }

    public void setRabatprice(int rabatprice) {
        this.rabatprice = rabatprice;
    }

    public int getRabatPercent() {
        return rabatPercent;
    }

    public void setRabatPercent(int rabatPercent) {
        this.rabatPercent = rabatPercent;
    }
}
