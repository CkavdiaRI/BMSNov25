package org.example.bmsnov25.controllers;

import org.example.bmsnov25.dtos.ResponseStatus;
import org.example.bmsnov25.dtos.SignUpUserRequestDTO;
import org.example.bmsnov25.dtos.SignUpUserResponseDTO;
import org.example.bmsnov25.models.User;
import org.example.bmsnov25.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public SignUpUserResponseDTO signUpUser(SignUpUserRequestDTO request){
        SignUpUserResponseDTO response = new SignUpUserResponseDTO();
        try{
            String name = request.getName();
            String email = request.getEmail();
            String password = request.getPassword();
            User user = userService.signUpUser(name, email, password);

            response.setMessage("User registered successfully");
            response.setStatus(ResponseStatus.SUCCESS);
            response.setUserId(user.getId());
        } catch(Exception e){
            response.setMessage("User registration failed: " + e.getMessage());
            response.setStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
