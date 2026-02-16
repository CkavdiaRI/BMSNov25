package org.example.bmsnov25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

// Lombok dependencies allows use to use annotations like @Getter and @Setter
// to automatically generate getter and setter methods for class fields.

// Entity annotation specifies that the class is an entity and is mapped to a database table.

@Getter @Setter
//@Entity
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedAt;
}
