package kz.csse.baskino.react.baskino.repositories;

import kz.csse.baskino.react.baskino.entities.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ActorsRepository extends JpaRepository<Actors,Long> {


}
