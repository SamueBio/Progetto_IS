package net.javaguides.springboot.model.accomodation;

import net.javaguides.springboot.model.favourites.Favourite;

import java.util.Date;

public class AccommodationBoolean {
    private Accommodation accommodation;
    private boolean favourite;
	
	public AccommodationBoolean(boolean favourite,Accommodation accommodation) {
		this.accommodation = accommodation;
        this.favourite = favourite;
    }
	
	public Accommodation getAccommodation() {
        return accommodation;
	}
	
	public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
	}
	
	public boolean getFavourite() {
        return favourite;
	}
	
	public void setFavourite(boolean favourite) {
        this.favourite = favourite;
	}
}
