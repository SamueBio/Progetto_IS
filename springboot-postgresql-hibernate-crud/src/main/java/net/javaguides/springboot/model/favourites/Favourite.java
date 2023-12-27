package net.javaguides.springboot.model.favourites;

import jakarta.persistence.*;

@Entity
@Table(name="favourites")
public class Favourite {

    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "accommodation")
    private Integer accommodation;

    public Favourite() {
        super();
    }

    public Favourite(String user, Integer accommodation) {
        this.username = user;
        this.accommodation = accommodation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username = user;
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
                "user=" + username +
                ", accommodation='" + accommodation +
                '}';
    }
}