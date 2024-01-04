package net.javaguides.springboot.controller;


import net.javaguides.springboot.model.accomodation.Accommodation;
import net.javaguides.springboot.model.accomodation.AccommodationBoolean;
import net.javaguides.springboot.model.favourites.Favourite;
import net.javaguides.springboot.model.favourites.FavouriteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class FavouriteController {
    @Autowired
    private FavouriteDao favouriteDao;
    @GetMapping("/Favourites/get-all")
    public List<Favourite> getAllAccomodations(){return favouriteDao.getAllFavourites();}

    @PostMapping("/Favourites/get-favouriteaccomodation-by-user")
    public List<AccommodationBoolean> getFavouritesAccomodationByUser(@RequestBody Favourite favourite){return favouriteDao.getFavouritesAccomodationByUser(favourite);}

    @PostMapping("/Favourites/save")
    public void save(@RequestBody Favourite favourite) {favouriteDao.save(favourite); }

    @PostMapping("/Favourites/delete")
    public void delete(@RequestBody Favourite favourite) {favouriteDao.delete(favourite);}
}

