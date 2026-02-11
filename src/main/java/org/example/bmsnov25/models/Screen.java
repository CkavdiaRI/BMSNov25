package org.example.bmsnov25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Screen extends BaseModel{
    private String name;
    @ManyToOne
    private Theatre theatre;
    @OneToMany
    private List<Seat> seats;
}

// Screen 1 :  1  Theatre
// Theatre 1 : M   Screen

// Screen 1 : M   Seats
// Seat 1 : 1   Screen