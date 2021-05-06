package kz.csse.baskino.react.baskino.services.impl;

import kz.csse.baskino.react.baskino.entities.Genres;
import kz.csse.baskino.react.baskino.repositories.GenresRepository;
import kz.csse.baskino.react.baskino.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenresServiceImpl implements GenreService {

    @Autowired
    private GenresRepository genresRepository;

    @Override
    public List<Genres> getAllGenres() {
        return genresRepository.findAll();
    }

    @Override
    public Genres addGenres(Genres genres) {
        return genresRepository.save(genres);
    }

    @Override
    public Genres saveGenres(Genres genres) {
        return genresRepository.save(genres);
    }

    @Override
    public Genres getOneGenres(Long id) {
        Optional<Genres> opt = genresRepository.findById(id);
        return opt.isPresent()?opt.get():null;
    }

    @Override
    public void deleteGenres(Genres genres) {
        genresRepository.delete(genres);
    }
}
