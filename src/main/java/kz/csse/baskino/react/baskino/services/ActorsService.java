package kz.csse.baskino.react.baskino.services;

import kz.csse.baskino.react.baskino.entities.Actors;
import kz.csse.baskino.react.baskino.entities.Movies;
import kz.csse.baskino.react.baskino.entities.Users;

import java.util.List;

public interface ActorsService {



    List<Actors> getAllActors();
    Actors addActors(Actors actors);
    Actors saveActors(Actors actors);
    Actors getOneActors(Long id);
    void deleteActors(Actors actors);
}
