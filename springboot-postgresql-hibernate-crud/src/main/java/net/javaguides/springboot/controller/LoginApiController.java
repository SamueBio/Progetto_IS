package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.services.UserServices;
import net.javaguides.springboot.model.user.Login;
import net.javaguides.springboot.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginApiController {
    @Autowired
    UserServices userServices;
    @PostMapping("/Users/login")
    public ResponseEntity authenticateUser(@RequestBody Login login){
        List<String> username  = userServices.checkUsername(login.getUsername());
        if(username.isEmpty() || username == null){
            return new ResponseEntity("Username does not exists " + username, HttpStatus.NOT_FOUND);
        }
        String hashedPassword = userServices.checkUserPasswordByUsername(login.getUsername());
        if(!login.getPassword().equals(hashedPassword)){
            return new ResponseEntity("Incorrect username or password", HttpStatus.BAD_REQUEST);
        }

        User user = userServices.getUserDetailsByUsername(login.getUsername());
        return new ResponseEntity(user,HttpStatus.OK);
    }
}
