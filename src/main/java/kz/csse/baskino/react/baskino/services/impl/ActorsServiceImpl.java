package kz.csse.baskino.react.baskino.services.impl;

import kz.csse.baskino.react.baskino.entities.Actors;
import kz.csse.baskino.react.baskino.repositories.ActorsRepository;
import kz.csse.baskino.react.baskino.services.ActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorsServiceImpl implements ActorsService {
    @Autowired
    ActorsRepository actorsRepository;


    @Override
    public List<Actors> getAllActors() {
        return actorsRepository.findAll();
    }

    @Override
    public Actors addActors(Actors actors) {
        return actorsRepository.save(actors);
    }

    @Override
    public Actors saveActors(Actors actors) {
        return actorsRepository.save(actors);
    }

    @Override
    public Actors getOneActors(Long id) {
        Optional<Actors> opt = actorsRepository.findById(id);
        return opt.isPresent()?opt.get():null;
    }

    @Override
    public void deleteActors(Actors actors) {
        actorsRepository.delete(actors);
    }
}
