package org.example.bmsnov25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
@Entity
public class Show extends BaseModel{
    @ManyToOne
    private Theatre theatre;
    @ManyToOne
    private Screen screen;
    @ManyToOne
    private Movie movie;
    private String startTime;
    private String endTime;
    private Date showDate;
    @OneToMany
    private List<ShowSeat> seats;
    @OneToMany
    private List<ShowSeatType> seatTypes;

}

// Show M : 1  Screen
// Show M : 1  Movie
// Show M : 1  Theatre

// Show 1 : M  ShowSeat
// Show 1 : M  ShowSeatType