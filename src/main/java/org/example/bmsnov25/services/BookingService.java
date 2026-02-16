package org.example.bmsnov25.services;

import org.example.bmsnov25.models.*;
import org.example.bmsnov25.repos.BookingRepo;
import org.example.bmsnov25.repos.ShowRepo;
import org.example.bmsnov25.repos.ShowSeatRepo;
import org.example.bmsnov25.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ShowRepo showRepo;
    @Autowired
    private ShowSeatRepo showSeatRepo;
    @Autowired
    private bookingAmountCalculationService bookingAmountCalculationService;
    @Autowired
    private BookingRepo bookingRepo;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long showId, List<Long> showSeatIds) {

        // Get the user by userId from userRepo
        Optional<User> userOptional = userRepo.findById(userId);
        // Validate if user exists
        if(!userOptional.isPresent()){
            throw new RuntimeException("User not found with id: " + userId);
        }
        User user = userOptional.get();

        // Get the show by showId from showRepo
        Optional<Shows> showOptional = showRepo.findById(showId);
        // Validate if show exists
        if(!showOptional.isPresent()){
            throw new RuntimeException("Show not found with id: " + showId);
        }
        Shows show = showOptional.get();

        // Get the showSeats by showSeatIds from showSeatRepo
        List<ShowSeat> showSeats = showSeatRepo.findAllById(showSeatIds);

        // Check if the showSeats are available
        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new RuntimeException("ShowSeat not available: " + showSeat.getId());
            }
        }

        // Mark the seats as blocked
        for(ShowSeat showSeat : showSeats){
            showSeat.setStatus(ShowSeatStatus.BLOCKED);
            // Update the show seat status in the database
            showSeatRepo.save(showSeat);
        }

        // Create the booking object
        // Can use builder pattern if there are lot of attributes to set in the booking object
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShow(show);
        booking.setBookingDate(new java.util.Date());
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShowSeats(showSeats);
        // Set the booking amount
        booking.setAmount(bookingAmountCalculationService.calculateTotalAmount(showSeats));

        // Payment logic can be implemented here
        // Payement service can be called to make the payment

        // Save the booking object in the database using bookingRepo
        bookingRepo.save(booking);


        // Mark the seats available if payment is not processed successfully

        return null;
    }
}


// Book Movie Logic Flow:

// 1. Validate the input parameters (userId, showId, showSeatIds).
    // Validate if userId is not null and exists in the database.
    // Validate if showId is not null and exists in the database.
    // Validate showSeatIds.
        // if they are not available, throw an exception or return an error response.
    // If avaialable, then take a lock on those show seats to prevent other concurrent bookings from booking the same seats.
    // Double check the seat status even after aquiring the lock
    // Mark the seats as booked in the database.
    // Book the ticket
    // Release the lock