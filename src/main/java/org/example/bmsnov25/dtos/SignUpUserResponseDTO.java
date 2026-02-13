package org.example.bmsnov25.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignUpUserResponseDTO {
    private String message;
    private ResponseStatus status;
    private int userId;
}
