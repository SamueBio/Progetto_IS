package net.javaguides.springboot.model.services;

import net.javaguides.springboot.model.user.User;
import net.javaguides.springboot.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;

    public List<String> checkUsername(String username){
        return userRepository.checkUsername(username);
    }

    public String checkUserPasswordByUsername(String username){
        return userRepository.checkUserPasswordByUsername(username);
    }

    public User getUserDetailsByUsername(String username){
        return userRepository.GetUserDetailsByUsername(username);
    }
}
