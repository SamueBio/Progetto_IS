package net.javaguides.springboot.model.favorites;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Favorites")
public class Favorites {

    @User
    @Column(name = "user", length = 50)
    private String user;

    @Column(name = "accommodation")
    private Integer accommodation;

    public Favorites {super();}

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Integer accommodation) {
        this.accommodation = accommodation;
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "user=" + user +
                ", accommodation='" + accommodation +
                '}';
    }
}