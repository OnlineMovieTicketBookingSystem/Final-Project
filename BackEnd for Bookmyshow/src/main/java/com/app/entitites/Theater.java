package com.app.entitites;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "theater")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theater_id")
    private int theaterId;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<Showtime> showtimes = new ArrayList<>();

    public void addShowtime(Showtime showtime) {
        showtimes.add(showtime);
        showtime.setTheater(this);
    }

    public void removeShowtime(Showtime showtime) {
        showtimes.remove(showtime);
        showtime.setTheater(null);
    }
    
    
    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "location", length = 255)
    private String location;

    @Column(name = "capacity")
    private Integer capacity;

    // Constructors, getters, and setters
}
