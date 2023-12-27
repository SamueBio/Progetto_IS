package com.example.myapplication.model;

import com.google.gson.JsonObject;

public class Favourite {
    private String user;
    private Integer accomodation;

    public Favourite(String user,Integer accomodation){
        super();
        this.user = user;
        this.accomodation = accomodation;
    }

    public Favourite() {
        super();
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

    public JsonObject generateJson(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username",user);
        jsonObject.addProperty("accommodation",accomodation);

        return jsonObject;
    }
}
