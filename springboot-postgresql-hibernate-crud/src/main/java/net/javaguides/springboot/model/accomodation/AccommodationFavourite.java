package net.javaguides.springboot.model.accomodation;

import net.javaguides.springboot.model.favourites.Favourite;

public class AccommodationFavourite {
    private Accommodation accommodation;
    private Favourite favourite;

    public AccommodationFavourite(Accommodation accommodation, Favourite favourite) {
        this.accommodation = accommodation;
        this.favourite = favourite;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public Favourite getFavourite() {
        return favourite;
    }

    public void setFavourite(Favourite favourite) {
        this.favourite = favourite;
    }
}
