package com.setlimit.entity;

import javax.persistence.*;

// Ticket.java
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ticketNumber;

    private double amount;

//    public Double getAmount() {
//    }

    public void setAmount(double v) {
    }

//    public Object getTicketNumber() {
//    }

    // getters, setters, constructors
}
