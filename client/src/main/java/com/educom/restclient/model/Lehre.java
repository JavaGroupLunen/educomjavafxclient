package com.educom.restclient.model;



public class Lehre {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
   // private Integer age;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Lehre(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email= email;
    }

    public Lehre() {
    }

    public Lehre(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
