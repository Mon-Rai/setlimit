//package com.setlimit.controller;
//
//import com.setlimit.payload.TicketDTO;
//import com.setlimit.service.TicketService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//// TicketController.java
//@RestController
//@RequestMapping("/api/tickets")
//public class TicketController {
//
//    @Autowired
//    private TicketService ticketService;
//
//    @PostMapping("/book")
//    public ResponseEntity<List<TicketDTO>> bookTickets(@RequestBody Map<String, Double> ticketBookingMap) {
//        try {
//            List<String> ticketNumbers = new ArrayList<>(ticketBookingMap.keySet());
//            List<Double> amounts = new ArrayList<>(ticketBookingMap.values());
//
//            List<TicketDTO> bookedTickets = ticketService.bookTickets(ticketNumbers, amounts);
//            return new ResponseEntity<>(bookedTickets, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//}
