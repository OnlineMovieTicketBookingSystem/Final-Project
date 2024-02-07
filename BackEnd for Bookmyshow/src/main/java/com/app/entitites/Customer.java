package com.app.entitites;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;



@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;
    
    
    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Booking> bookings = new HashSet<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
        booking.setCustomer(this);
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
        booking.setCustomer(null);
    }
    
    
    
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Rating> ratings = new ArrayList<>();

    // Other fields, constructors, getters, and setters...

    public void addRating(Rating rating) {
        ratings.add(rating);
        rating.setCustomer(this);
    }

    public void removeRating(Rating rating) {
        ratings.remove(rating);
        rating.setCustomer(null);
    }
    
    
    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @NonNull
    @Column(name = "username", length = 50, nullable = false)
    private String username;

    @NonNull
    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<BankInfo> bankInfoList;
    
 // Method to add bank information
    public void addBankInfo(BankInfo bankInfo) {
        bankInfo.setCustomer(this);
        bankInfoList.add(bankInfo);
    }

    // Method to remove bank information
    public void removeBankInfo(BankInfo bankInfo) {
        bankInfo.setCustomer(null);
        bankInfoList.remove(bankInfo);
    }
    
    
}