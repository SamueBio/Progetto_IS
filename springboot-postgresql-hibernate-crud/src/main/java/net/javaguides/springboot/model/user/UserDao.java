package net.javaguides.springboot.model.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
	@Autowired
	private UserRepository repository;
	
	public void save(User user) {
		repository.save(user);
	}
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		Streamable.of(repository.findAll())
		.forEach(users::add);
		return users;
	}
	
	public void delete(String username) {
		repository.deleteById(username);
	}

	public String findPasswordById(String username){
		String psw = repository.findPasswordByUsername(username);
		System.out.println(psw);
		return psw;
	}

	public boolean checkPassword(String username, String pswToCheck){
		return repository.checkPassword(username,pswToCheck);
	}
}
