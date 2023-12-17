package net.javaguides.springboot.model.favourites;

import jakarta.persistence.*;

@Entity
@Table(name="favourites")
public class Favourite {

    @Id
    @Column(name = "user")
    private String user;
    @Column(name = "accommodation")
    private Integer accommodation;

    public Favourite() {
        super();
    }

    public Favourite(String user, Integer accommodation) {
        this.user = user;
        this.accommodation = accommodation;
    }

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