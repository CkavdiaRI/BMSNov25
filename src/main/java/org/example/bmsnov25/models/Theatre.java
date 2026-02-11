package org.example.bmsnov25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Theatre extends BaseModel{
    private String name;
    private String address;
    @ManyToOne
    private Region region;
    @OneToMany
    private List<Screen> screens;
}

// Theatre M : 1   Region
// Theatre 1 : M   Screen