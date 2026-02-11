package org.example.bmsnov25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Region extends BaseModel{
    private String name;
    @OneToMany
    private List<Theatre> theatres;
}

// Region 1 : M   Theatre
// Theatre 1 : 1   Region