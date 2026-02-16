package org.example.bmsnov25.repos;

import org.example.bmsnov25.models.ShowSeatType;
import org.example.bmsnov25.models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepo extends JpaRepository<String, Long> {
    List<ShowSeatType> findByShow(Shows show);
}
