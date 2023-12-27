package com.example.myapplication.model;

public class AccommodationFavourite {
    private Accommodation accommodation;
    private boolean isFavourited;

    public AccommodationFavourite(Accommodation accommodation, boolean isFavourited) {
        this.accommodation = accommodation;
        this.isFavourited = isFavourited;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public boolean isFavourited() {
        return isFavourited;
    }

    public void setFavourited(boolean favourited) {
        isFavourited = favourited;
    }
}
