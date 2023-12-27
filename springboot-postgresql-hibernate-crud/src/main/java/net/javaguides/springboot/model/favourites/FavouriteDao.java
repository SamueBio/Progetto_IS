package net.javaguides.springboot.model.favourites;

//import net.javaguides.springboot.model.accomodation.Accommodation;
import net.javaguides.springboot.model.accomodation.Accommodation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteDao {
    @Autowired
    private FavouriteRepository favouritesRepository;
    public List<Favourite> getAllFavourites(){
        return favouritesRepository.findAll();
    }

    public void save(Favourite favourites){favouritesRepository.saveFavourite(favourites);}

    public List<Accommodation> getFavouritesAccomodationByUser(Favourite favourites){return favouritesRepository.findFavouritesAccommodationByUser(favourites);}
}