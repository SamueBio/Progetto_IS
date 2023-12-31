package net.javaguides.springboot.model.accomodation;

import net.javaguides.springboot.model.favourites.Favourite;

import java.util.Date;

public class AccommodationFavourite {
    private Accommodation accommodation;
    private String username;
	
	public AccommodationFavourite(String username,Accommodation accommodation) {
		this.accommodation = accommodation;
        this.username = username;
    }
	
	public Accommodation getAccommodation() {
        return accommodation;
	}
	
	public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
	}
	
	public String getUsername() {
        return username;
	}
	
	public void setUsername(String username) {
        this.username = username;
	}
}
