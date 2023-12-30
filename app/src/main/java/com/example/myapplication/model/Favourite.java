package com.example.myapplication.model;

import com.google.gson.JsonObject;

public class Favourite {
    private String user;
    private Integer accommodation;

    public Favourite(String user,Integer accommodation){
        super();
        this.user = user;
        this.accommodation = accommodation;
    }

    public Favourite() {
        super();
    }

    public String getUser() {
        return user;
    }

    public Integer getAccommodation() {
        return accommodation;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setAccommodation(Integer accommodation) {
        this.accommodation = accommodation;
    }

    public JsonObject generateJson(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("accommodation", accommodation);
        jsonObject.addProperty("username",user);

        return jsonObject;
    }
}
