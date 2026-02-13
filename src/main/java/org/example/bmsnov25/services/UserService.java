package org.example.bmsnov25.services;

import org.example.bmsnov25.models.User;
import org.example.bmsnov25.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User signUpUser(String name, String email, String password){
        // Check if user already exists using email
        Optional userOptional = userRepo.findByEmail(email);
        if(userOptional.isPresent()){
            throw new RuntimeException("User with this email already exists");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        // Encrypt the password before saving to database
        return userRepo.save(user);
    }
}


//