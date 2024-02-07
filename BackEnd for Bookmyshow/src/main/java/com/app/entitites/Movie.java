package com.app.entitites;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieId;

    
    
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Showtime> showtimes = new ArrayList<Showtime>();

    public void addShowtime(Showtime showtime) {
        showtimes.add(showtime);
        showtime.setMovie(this);
    }

    public void removeShowtime(Showtime showtime) {
        showtimes.remove(showtime);
        showtime.setMovie(null);
    }
    
    
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Rating> ratings = new ArrayList<>();

    // Other fields, constructors, getters, and setters...

    public void addRating(Rating rating) {
        ratings.add(rating);
        rating.setMovie(this);
    }

    public void removeRating(Rating rating) {
        ratings.remove(rating);
        rating.setMovie(null);
    }
    
    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "genre", length = 50)
    private String genre;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "director", length = 100)
    private String director;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "poster_url", length = 255)
    private String posterUrl;

    
}