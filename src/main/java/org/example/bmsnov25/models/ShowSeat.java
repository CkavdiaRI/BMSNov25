package org.example.bmsnov25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Shows show;
    @ManyToOne
    private Seat seat;
    private ShowSeatStatus status;
    private Date blockedAt;
}

// Showseat M : 1   Show
// Showseat M : 1   Seat