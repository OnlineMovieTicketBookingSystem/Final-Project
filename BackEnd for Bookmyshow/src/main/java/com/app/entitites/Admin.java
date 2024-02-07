package com.app.entitites;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private int adminId;

    @NonNull
    @Column(name = "username", length = 50, nullable = false)
    private String username;

    @NonNull
    @Column(name = "password", length = 255, nullable = false)
    private String password;
}