package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.accomodation.Accommodation;
import net.javaguides.springboot.model.accomodation.AccommodationBoolean;
import net.javaguides.springboot.model.accomodation.AccommodationDao;
import net.javaguides.springboot.model.accomodation.AccommodationFavourite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class AccomodationController {
    @Autowired
    private AccommodationDao accomodationDao;

    @GetMapping("/Accommodations/get-all")
    public List<Accommodation> getAllAccomodations(){return accomodationDao.getAllAccomodations();}

    @GetMapping("/Accommodations/search")
    public List<AccommodationBoolean> getAccommodationFavourite(@RequestBody AccommodationFavourite accommodationFavourite){
        return accomodationDao.getAccommodationFavourite(accommodationFavourite);
    }
    @GetMapping("/Accommodations/get-all-b")
    public List<AccommodationBoolean> getAllAccommodationBoolean(AccommodationFavourite accommodationFavourite){return accomodationDao.getAllAccommodationBoolean(accommodationFavourite);}

    @GetMapping("/Accommodations/get-accomodation-by-name")
    public List<Accommodation> getAccomodationsByName(@RequestBody String name){return accomodationDao.getAccomodationByName(name);}

    @PostMapping("/Accommodations/get-accomodation-by-services")
    public ResponseEntity getAccomoddationByServices(@RequestBody Accommodation accommodation){
        List<Accommodation> acc = accomodationDao.getAccomodationByServices(accommodation);
        return new ResponseEntity(acc, HttpStatus.OK);
    }
    @PostMapping("/Accommodations/search")
    public ResponseEntity search(@RequestBody AccommodationFavourite accommodationFavourite){
        List<AccommodationBoolean> accommodationBooleanList = accomodationDao.search(accommodationFavourite);
        return new ResponseEntity(accommodationBooleanList,HttpStatus.OK);
    }
    @PostMapping("/Accommodations/save")
    public void save(@RequestBody Accommodation accomodation) {accomodationDao.save(accomodation); }

}
