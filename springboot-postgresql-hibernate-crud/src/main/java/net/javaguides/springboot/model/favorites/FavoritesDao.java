package net.javaguides.springboot.model.favorites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class FavoritesDao {
    private FavoritesRepository favoritesRepository;

    public void save(Favorites favorites){favoritesRepository.save(favorites);}

    public List<Accommodation> getFavoritesAccomodationByUser(String user){return favoritesRepository.findFavoritesAccommodationByUser(user);}
}