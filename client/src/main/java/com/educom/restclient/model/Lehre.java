package com.educom.restclient.model;


import java.util.Date;
import java.util.List;


public class Lehre extends Person{
    private Double stundenLohn;

    private VerfugbarkeitFurLehre verfugbarkeitFurLehre;

private List<Kurs> kanngeben;

    public Lehre(Double stundenLohn) {
        this.stundenLohn = stundenLohn;
    }

    public Lehre() {
    }

    public Lehre(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    public Lehre(String firstName, String lastName, String email, String phoneNumber, Gender gender, Date geburstDatum, String adres, String stadt, String land, String plz, Double stundenLohn) {
        super(firstName, lastName, email, phoneNumber, gender, geburstDatum, adres, stadt, land, plz);
        this.stundenLohn = stundenLohn;
    }


    public Double getStundenLohn() {
        return stundenLohn;
    }

    public void setStundenLohn(Double stundenLohn) {
        this.stundenLohn = stundenLohn;
    }

    public VerfugbarkeitFurLehre getVerfugbarkeitFurLehre() {
        return verfugbarkeitFurLehre;
    }

    public void setVerfugbarkeitFurLehre(VerfugbarkeitFurLehre verfugbarkeitFurLehre) {
        this.verfugbarkeitFurLehre = verfugbarkeitFurLehre;
    }

    public List<Kurs> getKanngeben() {
        return kanngeben;
    }

    public void setKanngeben(List<Kurs> kanngeben) {
        this.kanngeben = kanngeben;
    }

    @Override
    public String toString() {
        return  firstName + " " +
                lastName ;

    }
}
