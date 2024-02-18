package com.multiplex.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.multiplex.models.Movie;

public interface MovieServiceInterface {

    void save(Movie movie, MultipartFile photo);

    List<Movie> listall();

    Movie findById(int id);

    void deleteMovie(int id);
}
