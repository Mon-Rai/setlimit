package com.setlimit.repository;

import com.setlimit.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// TicketRepository.java
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findByTicketNumber(String ticketNumber);
}
