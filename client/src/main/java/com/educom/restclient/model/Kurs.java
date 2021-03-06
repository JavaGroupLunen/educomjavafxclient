package com.educom.restclient.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Kurs {

    private long id;

    private String name;

    private String raum;
    private Double kosten;
    private int dauer;
    private int kurslang;
    private Date anfangAb;
    private Date endeBis;

    private KursType kurstype;


    private Lehre lehre;


    private Set<Schuler> schulerSet = new HashSet<>();

    public Kurs(String name, String raum, Lehre lehre) {
        this.name = name;
        this.raum = raum;
        this.lehre = lehre;

    }

    public Kurs() {
    }

    public Kurs(String name, String raum) {
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

    public Double getKosten() {
        return kosten;
    }

    public void setKosten(Double kosten) {
        this.kosten = kosten;
    }

    public int getDauer() {
        return dauer;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    public int getKurslang() {
        return kurslang;
    }

    public void setKurslang(int kurslang) {
        this.kurslang = kurslang;
    }

    public Date getAnfangAb() {
        return anfangAb;
    }

    public void setAnfangAb(Date anfangAb) {
        this.anfangAb = anfangAb;
    }

    public Date getEndeBis() {
        return endeBis;
    }

    public void setEndeBis(Date endeBis) {
        this.endeBis = endeBis;
    }

    public KursType getKurstype() {
        return kurstype;
    }

    public void setKurstype(KursType kurstype) {
        this.kurstype = kurstype;
    }

    public Lehre getLehre() {
        return lehre;
    }

    public void setLehre(Lehre lehre) {
        this.lehre = lehre;
    }

    public Set<Schuler> getSchulerSet() {
        return schulerSet;
    }

    public void setSchulerSet(Set<Schuler> schulerSet) {
        this.schulerSet = schulerSet;
    }

    @Override
    public String toString() {
        return "Kurs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", raum='" + raum + '\'' +
                ", kosten=" + kosten +
                ", dauer=" + dauer +
                ", kurslang=" + kurslang +
                ", anfangAb=" + anfangAb +
                ", endeBis=" + endeBis +
                ", kurstype=" + kurstype +
                ", lehre=" + lehre +
                ", schulerSet=" + schulerSet +
                '}';
    }
}
