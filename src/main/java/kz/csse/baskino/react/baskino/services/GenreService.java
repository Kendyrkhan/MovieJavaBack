package kz.csse.baskino.react.baskino.services;

import kz.csse.baskino.react.baskino.entities.Genres;

import java.util.List;

public interface GenreService {

    List<Genres> getAllGenres();
    Genres addGenres(Genres genres);
    Genres saveGenres(Genres genres);
    Genres getOneGenres(Long id);
    void deleteGenres(Genres genres);
}



