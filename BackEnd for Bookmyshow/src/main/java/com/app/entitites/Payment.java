package com.app.entitites;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "payment_amount")
    private BigDecimal paymentAmount;

    @Column(name = "payment_method", length = 50)
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

}
