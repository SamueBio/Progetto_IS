package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.user.User;
import net.javaguides.springboot.model.user.UserDao;
import net.javaguides.springboot.model.user.UserRepository;

@RestController
public class UserController {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/Users/get-all")
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}

	// save user
	@PostMapping("/Users/save")
	public void save(@RequestBody User user) {userDao.save(user); }
}
