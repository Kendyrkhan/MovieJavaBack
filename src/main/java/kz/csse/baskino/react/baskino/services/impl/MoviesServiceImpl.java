package kz.csse.baskino.react.baskino.services.impl;

import kz.csse.baskino.react.baskino.entities.Movies;
import kz.csse.baskino.react.baskino.repositories.MoviesRepository;
import kz.csse.baskino.react.baskino.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    @Override
    public List<Movies> getAllMovies() {
        return moviesRepository.findAll();
    }

    @Override
    public Movies addMovie(Movies movies) {
        return moviesRepository.save(movies);
    }

    @Override
    public Movies saveMovie(Movies movies) {
        return moviesRepository.save(movies);
    }

    @Override
    public Movies getOneMovie(Long id) {
        Optional<Movies> opt = moviesRepository.findById(id);
        return opt.isPresent()?opt.get():null;
    }

    @Override
    public List<Movies> searchMovieByTitle(String text) {
        return moviesRepository.findAllByTitleContains(text);
    }

    @Override
    public void deleteMovie(Movies movies) {
        moviesRepository.delete(movies);
    }
}
