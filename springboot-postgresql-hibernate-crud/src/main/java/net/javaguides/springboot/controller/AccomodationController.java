package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.accomodation.Accommodation;
import net.javaguides.springboot.model.accomodation.AccommodationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class AccomodationController {
    @Autowired
    private AccommodationDao accomodationDao;

    @GetMapping("/Accommodations/get-all")
    public List<Accommodation> getAllAccomodations(){return accomodationDao.getAllAccomodations();}

    @GetMapping("/Accommodations/get-accomodation-by-name")
    public List<Accommodation> getAccomodationsByName(@RequestBody String name){return accomodationDao.getAccomodationByName(name);}

    @GetMapping("/Accomodations/get-accomodation-by-services")
    public List<Accommodation> getAccomoddationByServices(@RequestBody Accommodation accommodation){return accomodationDao.getAccomodationByServices(accommodation);}

    @PostMapping("/Accommodations/save")
    public void save(@RequestBody Accommodation accomodation) {accomodationDao.save(accomodation); }
}
