package com.educom.restclient.model;


import lombok.Data;

import java.util.Date;


@Data
public abstract class Person {
   private long id;
   private  String firstName;
   private  String lastName ;
   private  String email;
    private String phoneNumber;
    private Gender gender;
    private Date geburstDatum;
    private String address;
    private String stadt;
    private String land;
    private String plz;


}
