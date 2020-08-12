package com.educom.restclient.model;


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

    public Lehre(String text, String text1, String text2) {
        super();
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
