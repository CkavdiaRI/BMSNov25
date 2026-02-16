package org.example.bmsnov25.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.bmsnov25.models.Booking;

@Getter @Setter
public class BookMovieResponseDTO {
    private Booking booking;
    private String message;
    private ResponseStatus status;
}
