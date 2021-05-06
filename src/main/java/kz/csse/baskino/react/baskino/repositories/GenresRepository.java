package kz.csse.baskino.react.baskino.repositories;

import kz.csse.baskino.react.baskino.entities.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface GenresRepository extends JpaRepository<Genres,Long> {


}
