package com.app.entitites;

import javax.persistence.*;
import lombok.*;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table(name = "discount")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private int discountId;

    @Column(name = "valid_from_date")
    private LocalDateTime validFromDate;

    @Column(name = "valid_to_date")
    private LocalDateTime validToDate;

    @Column(name = "discount_type", length = 50)
    private String discountType;

    @Column(name = "discount_value", precision = 10, scale = 2)
    private BigDecimal discountValue;

    @OneToMany(mappedBy = "discount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Customer> customers = new ArrayList<>();

    @OneToMany(mappedBy = "discount", cascade = CascadeType.ALL)
    private List<Showtime> showtimes = new ArrayList<>();
    
    public void addShowtime(Showtime showtime) {
        showtimes.add(showtime);
        showtime.setDiscount(this);
    }

    public void removeShowtime(Showtime showtime) {
        showtimes.remove(showtime);
        showtime.setDiscount(null);
    }
    
    // Add and remove methods for customers
    public void addCustomer(Customer customer) {
        customers.add(customer);
        customer.setDiscount(this);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
        customer.setDiscount(null);
    }

    // Constructors, getters, and setters
}
