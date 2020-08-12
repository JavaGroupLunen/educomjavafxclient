package com.educom.restclient.model;

import java.util.Date;
import java.util.List;


public class Vertrag {

    private long id;
    private Date vertragsdatum;
    private Date vertragsbegin;
    private Date vertragsende;
    private ZahlungsType zahlungstype;
    private Double einmaligeKosten;
    private Double anmeldegebuhr;
    private Double materialprice;
    private Double summe;
    private Double monatlischeRate;
    private Double restbetrag;
    private int rabat;
    private int rabatPercent;

    private Schuler schuler;

    private List<Kurs> kursList;

    public Vertrag(long id, Date vertragsdatum, Date vertragsbegin, Date vertragsende, ZahlungsType zahlungstype, Double einmaligeKosten, Double anmeldegebuhr, Double materialprice, Double totalprice, Double monatlischeRate, Double restbetrag, int rabat, int rabatPercent, Schuler schuler, List<Kurs> kursList) {
        this.id = id;
        this.vertragsdatum = vertragsdatum;
        this.vertragsbegin = vertragsbegin;
        this.vertragsende = vertragsende;
        this.zahlungstype = zahlungstype;
        this.einmaligeKosten = einmaligeKosten;
        this.anmeldegebuhr = anmeldegebuhr;
        this.materialprice = materialprice;
        this.summe = totalprice;
        this.monatlischeRate = monatlischeRate;
        this.restbetrag = restbetrag;
        this.rabat = rabat;
        this.rabatPercent = rabatPercent;
        this.schuler = schuler;
        this.kursList = kursList;
    }

    public Vertrag() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getVertragsdatum() {
        return vertragsdatum;
    }

    public void setVertragsdatum(Date vertragsdatum) {
        this.vertragsdatum = vertragsdatum;
    }

    public Date getVertragsbegin() {
        return vertragsbegin;
    }

    public void setVertragsbegin(Date vertragsbegin) {
        this.vertragsbegin = vertragsbegin;
    }

    public Date getVertragsende() {
        return vertragsende;
    }

    public void setVertragsende(Date vertragsende) {
        this.vertragsende = vertragsende;
    }

    public ZahlungsType getZahlungstype() {
        return zahlungstype;
    }

    public void setZahlungstype(ZahlungsType zahlungstype) {
        this.zahlungstype = zahlungstype;
    }

    public Double getEinmaligeKosten() {
        return einmaligeKosten;
    }

    public void setEinmaligeKosten(Double einmaligeKosten) {
        this.einmaligeKosten = einmaligeKosten;
    }

    public Double getAnmeldegebuhr() {
        return anmeldegebuhr;
    }

    public void setAnmeldegebuhr(Double anmeldegebuhr) {
        this.anmeldegebuhr = anmeldegebuhr;
    }

    public Double getMaterialprice() {
        return materialprice;
    }

    public void setMaterialprice(Double materialprice) {
        this.materialprice = materialprice;
    }

    public Double getSumme() {
        return summe;
    }

    public void setSumme(Double summe) {
        this.summe = summe;
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

    public int getRabat() {
        return rabat;
    }

    public void setRabat(int rabat) {
        this.rabat = rabat;
    }

    public int getRabatPercent() {
        return rabatPercent;
    }

    public void setRabatPercent(int rabatPercent) {
        this.rabatPercent = rabatPercent;
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
