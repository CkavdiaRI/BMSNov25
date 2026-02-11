package org.example.bmsnov25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;
    private int price;
}

// ShowSeatType M : 1 Show
// ShowSeatType M : 1 SeatType