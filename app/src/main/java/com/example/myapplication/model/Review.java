package com.example.myapplication.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Review {

    private String username;
    private int accommodation;
    private String text;
    private Timestamp date;
    private int stars;

    public Review() { super(); }

    public Review(String username, int accommodation, String review, int stars, Timestamp date) {
        this.username = username;
        this.accommodation = accommodation;
        this.text = review;
        this.date = date;
        this.stars = stars;
    }

    public static List<Review> parseString(String responseBody) {
        List<Review> reviewList = new ArrayList<>();
        Gson gson = new Gson();

        Type listType = new TypeToken<List<Review>>(){}.getType();
        reviewList = gson.fromJson(responseBody,listType);
        return reviewList;
    }

    public int getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(int accommodation) {
        this.accommodation = accommodation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public JsonObject generateJson(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username",username);
        jsonObject.addProperty("accommodation",accommodation);
        jsonObject.addProperty("text",text);
        jsonObject.addProperty("stars",stars);
        if(date != null)
            jsonObject.addProperty("date", date.toString());

        return jsonObject;
    }
}
