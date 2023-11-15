//package com.setlimit.service.impl;
//
//import com.setlimit.entity.Ticket;
//import com.setlimit.payload.TicketDTO;
//import com.setlimit.repository.TicketRepository;
//import com.setlimit.service.TicketService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//// TicketServiceImpl.java
//@Service
//public class TicketServiceImpl implements TicketService {
//
//    @Autowired
//    private TicketRepository ticketRepository;
//
//    @Override
//    public List<TicketDTO> bookTickets(List<String> ticketNumbers, List<Double> amounts) {
//        if (ticketNumbers.size() != amounts.size()) {
//            throw new IllegalArgumentException("Ticket numbers and amounts lists must be of the same size.");
//        }
//
//        List<TicketDTO> bookedTickets = new ArrayList<>();
//
//        for (int i = 0; i < ticketNumbers.size(); i++) {
//            String ticketNumber = ticketNumbers.get(i);
//            Double amount = amounts.get(i);
//
//            // Fetch the ticket by ticket number
//            Ticket ticket = ticketRepository.findByTicketNumber(ticketNumber)
//                    .orElseThrow(() -> new RuntimeException("Ticket not found for ticket number: " + ticketNumber));
//
//            if (amount <= ticket.getAmount()) {
//                // Decrease the amount by the booking amount
//                ticket.setAmount(ticket.getAmount() - amount);
//
//                // Save the updated ticket
//                ticketRepository.save(ticket);
//
//                // Convert entity to DTO for response
//                TicketDTO ticketDTO = new TicketDTO();
//                ticketDTO.clone(ticket.getTicketNumber());
//                ticketDTO.setAmount(amount);
//
//                bookedTickets.add(ticketDTO);
//            } else {
//                throw new RuntimeException("Amount exceeds the remaining amount for ticket number: " + ticketNumber);
//            }
//        }
//
//        return bookedTickets;
//    }
//}
