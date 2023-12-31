package net.javaguides.springboot.controller;

import java.util.List;
import java.util.Map;

import net.javaguides.springboot.model.accomodation.Accommodation;
import net.javaguides.springboot.model.accomodation.AccommodationDao;
import net.javaguides.springboot.model.user.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.model.user.User;
import net.javaguides.springboot.model.user.UserDao;

@RestController
public class UserController {

	
	@Autowired
	private UserDao userDao;

	@PostMapping("/Users/login")
	public ResponseEntity authenticateUser(@RequestBody Login login){
		List<String> username  = userDao.checkUsername(login.getUsername());
		if(username.isEmpty() || username == null){
			return new ResponseEntity("Username does not exists " + username, HttpStatus.NOT_FOUND);
		}
		String hashedPassword = userDao.checkUserPasswordByUsername(login.getUsername());
		if(!login.getPassword().equals(hashedPassword)){
			return new ResponseEntity("Incorrect username or password", HttpStatus.BAD_REQUEST);
		}

		User user = userDao.getUserDetailsByUsername(login.getUsername());
		return new ResponseEntity(user,HttpStatus.OK);
	}
	@GetMapping("/Users/get-all")
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}

	// save user
	@PostMapping("/Users/save")
	public void save(@RequestBody User user) {userDao.save(user); }

	@PostMapping("/Users/update-values")
	public void updateValues(@RequestBody User user){userDao.updateValues(user);}

	@PostMapping("/Users/update-password")
	public void updatePassword(@RequestBody User user){userDao.updatePassword(user);}
}
