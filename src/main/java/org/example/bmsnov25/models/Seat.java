package org.example.bmsnov25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Seat extends BaseModel {
    private String name;
    private int rowVal;
    private int columnVal;
    @ManyToOne
    private SeatType seatType;
}

// Seat 1 : 1 SeatType
// SeatType 1 : M Seat