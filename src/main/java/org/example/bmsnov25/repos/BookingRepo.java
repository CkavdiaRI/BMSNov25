package org.example.bmsnov25.repos;

import org.example.bmsnov25.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Long> {
}
