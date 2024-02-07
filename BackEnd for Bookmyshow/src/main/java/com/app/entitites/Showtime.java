package com.app.entitites;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "showtime")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "showtime_id")
    private int showtimeId;

    
    @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    // Other fields, constructors, getters, and setters...

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        ticket.setShowtime(this);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
        ticket.setShowtime(null);
    }
    
    
    
    
    
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    
    @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL)
    private Set<Booking> bookings = new HashSet<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
        booking.setShowtime(this);
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
        booking.setShowtime(null);
    }
    
    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;
    
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @Column(name = "showtime_datetime")
    private LocalDateTime showtimeDatetime;

    @Column(name = "price")
    private BigDecimal price;

}
