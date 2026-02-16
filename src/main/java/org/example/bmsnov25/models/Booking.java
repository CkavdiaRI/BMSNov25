package org.example.bmsnov25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
@Entity
public class Booking extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Date bookingDate;
    @OneToMany
    private List<Payment> payments;
    @ManyToOne
    private Shows show;
    //@Enumerated(value = EnumType.ORDINAL)
    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;
    @OneToMany
    private List<ShowSeat> showSeats;
    private double amount;
}

// 1 user -> M booking
// 1 booking -> 1 user

// 1 booking -> M payment

// 1 booking -> 1 show
// 1 show -> M booking

// 1 booking -> M showSeats
// 1 showSeat -> 1 booking