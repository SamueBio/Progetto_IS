package net.javaguides.springboot.controller;

import java.util.List;

import net.javaguides.springboot.model.accomodation.Accommodation;
import net.javaguides.springboot.model.accomodation.AccommodationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.model.user.User;
import net.javaguides.springboot.model.user.UserDao;

@RestController
public class UserController {
	@Autowired
	private AccommodationDao accomodationDao;
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/Users/get-all")
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}

	// save user
	@PostMapping("/Users/save")
	public void save(@RequestBody User user) {userDao.save(user); }

	@GetMapping("/Accommodations/get-all")
	public List<Accommodation> getAllAccomodations(){return accomodationDao.getAllAccomodations();}

	@GetMapping("/Accomodations/get-accomodation-by-name")
	public List<Accommodation> getAccomodationsByName(@RequestParam String name){return accomodationDao.getAccomodationByName(name);}

	@GetMapping("/Accomodations/get-accomodation-by-services")
	public List<Accommodation> getAccomoddationByServices(@RequestParam Accommodation accommodation){return accomodationDao.getAccomodationByServices(accommodation);}

	@PostMapping("/Accommodations/save")
	public void save(@RequestBody Accommodation accomodation) {accomodationDao.save(accomodation); }
}
