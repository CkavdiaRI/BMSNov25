package org.example.bmsnov25;

import org.example.bmsnov25.controllers.UserController;
import org.example.bmsnov25.dtos.SignUpUserRequestDTO;
import org.example.bmsnov25.dtos.SignUpUserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BmsNov25Application implements CommandLineRunner {
    @Autowired
    private UserController userController;

    @Override
    public void run(String... args) throws Exception {
        SignUpUserRequestDTO request = new SignUpUserRequestDTO();
        request.setName("Chirag");
        request.setEmail("chirag@test.com");
        request.setPassword("password");

        SignUpUserResponseDTO response = userController.signUpUser(request);
        System.out.println("Response Message: " + response.getMessage());
        System.out.println("Response Status: " + response.getStatus());
    }

    public static void main(String[] args) {
        SpringApplication.run(BmsNov25Application.class, args);
    }

}
