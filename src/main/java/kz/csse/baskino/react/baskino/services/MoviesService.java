package kz.csse.baskino.react.baskino.services;

import kz.csse.baskino.react.baskino.entities.Movies;
import kz.csse.baskino.react.baskino.entities.Users;

import java.util.List;

public interface MoviesService {


    List<Movies> getAllMovies();
    Movies addMovie(Movies movies);
    Movies saveMovie(Movies movies);
    Movies getOneMovie(Long id);
    List<Movies> searchMovieByTitle(String text);
    void deleteMovie(Movies movies);
}
