package kz.csse.baskino.react.baskino.repositories;

import kz.csse.baskino.react.baskino.entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MoviesRepository extends JpaRepository<Movies,Long> {

    List<Movies> findAllByTitleContains(String text);
}
