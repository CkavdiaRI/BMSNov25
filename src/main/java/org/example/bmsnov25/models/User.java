package org.example.bmsnov25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class User extends BaseModel{
    public String name;
    public String email;
    public String password;
    @OneToMany(mappedBy = "user")
    public List<Booking> bookings;
}