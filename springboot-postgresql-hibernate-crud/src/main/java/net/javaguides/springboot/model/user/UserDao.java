package net.javaguides.springboot.model.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
	@Autowired
	private UserRepository userRepository;

	public List<String> checkUsername(String username){
		return userRepository.checkUsername(username);
	}

	public String checkUserPasswordByUsername(String username){
		return userRepository.checkUserPasswordByUsername(username);
	}

	public User getUserDetailsByUsername(String username){
		return userRepository.GetUserDetailsByUsername(username);
	}
	
	public void save(User user) {
		userRepository.save(user);
	}

	public void updateValues(User user){userRepository.updateValues(user);}

	public void updatePassword(User user){userRepository.updatePassword(user);}
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		Streamable.of(userRepository.findAll())
		.forEach(users::add);
		return users;
	}
	
	public void delete(User user) {
		userRepository.deleteById(user.getUsername());
	}

	public String findPasswordById(String username){
		String psw = userRepository.findPasswordByUsername(username);
		System.out.println(psw);
		return psw;
	}

	public boolean checkPassword(String username, String pswToCheck){
		return userRepository.checkPassword(username,pswToCheck);
	}
}
