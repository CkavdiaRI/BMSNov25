package org.example.bmsnov25.repos;

import org.example.bmsnov25.models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepo extends JpaRepository<Shows, Long> {
}
