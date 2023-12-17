package net.javaguides.springboot.model.favourites;

import net.javaguides.springboot.model.accomodation.Accommodation;

import java.util.List;

public class FavouriteDao {
    private FavouriteRepository favouritesRepository;

    public void save(Favourite favourites){favouritesRepository.save(favourites);}

    public List<Favourite> getFavouritesAccomodationByUser(String user){return favouritesRepository.findFavouritesAccommodationByUser(user);}
}