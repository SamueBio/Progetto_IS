package com.example.myapplication.model;

import java.time.LocalDate;
import java.util.Date;

public class Review {

    private String username;
    private String review;
    private Date data;
    private int stars;

    public Review() { super(); }

    public Review(String username, String review, Date data, int stars) {
        this.username = username;
        this.review = review;
        this.data = data;
        this.stars = stars;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
