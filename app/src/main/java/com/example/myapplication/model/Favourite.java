package com.example.myapplication.model;

public class Favourite {
    private String user;
    private Integer accomodation;

    public Favourite() {
        super();
    }

    public Favourite(String user,Integer accomodation){
        super();
        this.user = user;
        this.accomodation = accomodation;
    }

    public String getUser() {
        return user;
    }

    public Integer getAccomodation() {
        return accomodation;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public void setAccomodation(Integer accomodation) {
        this.accomodation = accomodation;
    }
}
