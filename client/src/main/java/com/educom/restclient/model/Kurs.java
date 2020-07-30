package com.educom.restclient.model;

import lombok.Data;
import lombok.ToString;
import java.util.List;

@Data
@ToString
public class Kurs {

    private long id;

    private String name;

    private String raum;

    private Lehre lehre;

    private List<Schuler> schulerList;

    public Kurs(String name, String raum, Lehre lehre, List<Schuler> schulerList) {
        this.name = name;
        this.raum = raum;
        this.lehre = lehre;
        this.schulerList = schulerList;
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

    public Lehre getLehre() {
        return lehre;
    }

    public void setLehre(Lehre lehre) {
        this.lehre = lehre;
    }

    public List<Schuler> getSchulerList() {
        return schulerList;
    }

    public void setSchulerList(List<Schuler> schulerList) {
        this.schulerList = schulerList;
    }
}
