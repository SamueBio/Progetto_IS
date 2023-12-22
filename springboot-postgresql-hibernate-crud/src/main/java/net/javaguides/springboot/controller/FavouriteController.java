package net.javaguides.springboot.controller;


import net.javaguides.springboot.model.favourites.Favourite;
import net.javaguides.springboot.model.favourites.FavouriteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class FavouriteController {
    @Autowired
    private FavouriteDao favouriteDao;

    @GetMapping("/Favourites/get-favouriteaccomodation-by-user")
    public List<Favourite> getFavouritesAccomodationByUser(@RequestBody String user){return favouriteDao.getFavouritesAccomodationByUser(user);}

    @PostMapping("/Favourites/save")
    public void save(@RequestBody Favourite favourite) {favouriteDao.save(favourite); }
}

