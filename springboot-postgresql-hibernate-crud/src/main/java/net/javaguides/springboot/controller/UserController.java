package net.javaguides.springboot.controller;

import java.util.List;

import net.javaguides.springboot.model.accomodation.Accomodation;
import net.javaguides.springboot.model.accomodation.AccomodationDao;
import net.javaguides.springboot.model.accomodation.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.model.user.User;
import net.javaguides.springboot.model.user.UserDao;
import net.javaguides.springboot.model.user.UserRepository;

@RestController
public class UserController {
	@Autowired
	private AccomodationDao accomodationDao;
	
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
	public List<Accomodation> getAllAccomodations(){return accomodationDao.getAllAccomodations();}

	@GetMapping("/Accomodations/get-accomodation-by-name")
	public List<Accomodation> getAccomodationsByName(@RequestParam String name){return accomodationDao.getAccomodationByName(name);}

	@GetMapping("/Accomodations/get-accomodation-by-services")
	public List<Accomodation> getAccomoddationByServices(@RequestParam Services services){return accomodationDao.getAccomodationByServices(services);}

	@PostMapping("/Accommodations/save")
	public void save(@RequestBody Accomodation accomodation) {accomodationDao.save(accomodation); }
}
