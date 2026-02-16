package org.example.bmsnov25.controllers;

import org.example.bmsnov25.dtos.BookMovieRequestDTO;
import org.example.bmsnov25.dtos.BookMovieResponseDTO;
import org.example.bmsnov25.dtos.ResponseStatus;
import org.example.bmsnov25.models.Booking;
import org.example.bmsnov25.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;

    public BookMovieResponseDTO bookMovie(BookMovieRequestDTO request){
        BookMovieResponseDTO responseDTO = new BookMovieResponseDTO();
        try{
            Booking booking = bookingService.bookMovie(
                request.getUserId(),
                request.getShowId(),
                request.getShowSeatIds()
            );

            responseDTO.setBooking(booking);
            responseDTO.setMessage("Booking successful");
            responseDTO.setStatus(ResponseStatus.SUCCESS);

        } catch(Exception e){
            responseDTO.setMessage("Booking failed: " + e.getMessage());
            responseDTO.setStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}


// Book a ticket
// Validate the input from the user (userId, showId, showSeatIds)