package net.javaguides.springboot.model.review;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
@Entity
@Table(name="reviews")
public class Review {
    @Id
    @Column(name="username")
    private String username;
    @Column(name="accommodation")
    private int accommodation;
    @Column(name="text")
    private String text;
    @Column(name = "stars")
    private int stars;
    @Column(name="date")
    private Date date;

    public Review(){super();}

    public Review(String username, int accommodation, String text, int stars, Date date) {
        this.username = username;
        this.accommodation = accommodation;
        this.text = text;
        this.stars = stars;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(int accommodation) {
        this.accommodation = accommodation;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
