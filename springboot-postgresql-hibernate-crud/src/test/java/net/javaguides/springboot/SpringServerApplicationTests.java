package net.javaguides.springboot;

import java.util.List;

import net.javaguides.springboot.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.javaguides.springboot.model.user.User;
import net.javaguides.springboot.model.user.UserDao;

@SpringBootTest
class SpringServerApplicationTests {

	@Autowired
	private UserDao userDao;
	@Test
	void contextLoads() {
		User user = new User();
		user.setUsername("caneGignte");
		user.setFirstName("Cane");
		user.setLastName("Giga");
		user.setEmail("cgiga@gmail.com");
		user.setPassword("1234");
		//userDao.save(user);
		String psw = userDao.findPasswordById("caneGignte");
		UserController uc = new UserController();
		//psw=uc.getPasswordById("marcolino");
		System.out.println(psw);
	}
	//@Test
	void getAllEmployeesAndDeleteThem() {
		List<User> users = userDao.getAllUsers();
		for(User user:users) {
			userDao.delete(user.getUsername());
		}
	}

}
