package net.javaguides.springboot.model.favourites;

//import net.javaguides.springboot.model.accomodation.Accommodation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteDao {
    @Autowired
    private FavouriteRepository favouritesRepository;

    public void save(Favourite favourites){favouritesRepository.save(favourites);}

    public List<Favourite> getFavouritesAccomodationByUser(String user){return favouritesRepository.findFavouritesAccommodationByUser(user);}
}