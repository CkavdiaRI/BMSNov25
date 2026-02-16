package org.example.bmsnov25.services;

import org.example.bmsnov25.models.ShowSeat;
import org.example.bmsnov25.models.ShowSeatType;
import org.example.bmsnov25.models.Shows;
import org.example.bmsnov25.repos.ShowSeatTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookingAmountCalculationService {
    @Autowired
    private ShowSeatTypeRepo showSeatTypeRepo;

        public double calculateTotalAmount(List<ShowSeat> showSeats) {
            Shows show = showSeats.get(0).getShow();
            List<ShowSeatType> seatTypes = showSeatTypeRepo.findByShow(show);

            int amount = 0;
            for(ShowSeat showSeat : showSeats) {
                for(ShowSeatType seatType : seatTypes) {
                    if(showSeat.getSeat().getSeatType().equals(seatType.getSeatType())) {
                        amount += seatType.getPrice();
                        break;
                    }
                }
            }

            return amount;
        }
}
