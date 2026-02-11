package org.example.bmsnov25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@Entity
public class Payment extends BaseModel{
    private double amount;
    private Date paymentDate;
    @Enumerated(EnumType.STRING)
    private PaymentGateway paymentGateway;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private String refNum;
}
