package com.app.entitites;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;

    
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    // Other fields, constructors, getters, and setters...

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        ticket.setBooking(this);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
        ticket.setBooking(null);
    }
    
    
    
    
    
    
    
    
    @Column(name = "seat_number", length = 10)
    private String seatNumber;

    @Column(name = "booking_date")
    private LocalDateTime bookingDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtime;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;


    public void addPayment(Payment payment) {
        this.payment = payment;
        payment.setBooking(this);
    }

    public void removePayment() {
        if (this.payment != null) {
            this.payment.setBooking(null);
            this.payment = null;
        }
    }
}
