package com.app.entitites;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ratings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private int ratingId;

    @Column(name = "rating")
    private int rating;

    @Column(name = "review", columnDefinition = "TEXT")
    private String review;

    @Column(name = "rating_date")
    private LocalDateTime ratingDate;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Constructors, getters, and setters
}
