package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.accomodation.Accomodation;
import net.javaguides.springboot.model.accomodation.AccomodationDao;
import net.javaguides.springboot.model.accomodation.AccomodationRepository;
import net.javaguides.springboot.model.accomodation.Services;
import net.javaguides.springboot.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class AccomodationController {

    @Autowired
    private AccomodationDao accomodationDao;
    @GetMapping("/Accomodations/get-all")
    public List<Accomodation> getAllAccomodations(){return accomodationDao.getAllAccomodations();}

    @GetMapping("/Accomodations/get-accomodation-by-name")
    public List<Accomodation> getAccomodationsByName(@RequestParam String name){return accomodationDao.getAccomodationByName(name);}

    @GetMapping("/Accomodations/get-accomodation-by-services")
    public List<Accomodation> getAccomoddationByServices(@RequestParam Services services){return accomodationDao.getAccomodationByServices(services);}

    @PostMapping("/Accommodations/save")
    public void save(@RequestBody Accomodation accomodation) {accomodationDao.save(accomodation); }

}
