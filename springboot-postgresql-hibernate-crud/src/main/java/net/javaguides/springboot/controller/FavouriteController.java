package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.accomodation.Accommodation;
import net.javaguides.springboot.model.accomodation.AccommodationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
@RestController
public class FavouriteController {
    @Autowired
    private FavouriteDao favouriteDao;

    @GetMapping("/Favourites/get-favouriteaccomodation-by-user")
    public List<Favourite> getFavouritesAccomodationByUser(@RequestBody String user){return favouriteDao.getFavouritesAccomodationByUser(user);}


}

 */