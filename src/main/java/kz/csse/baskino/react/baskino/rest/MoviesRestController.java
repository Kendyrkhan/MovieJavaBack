package kz.csse.baskino.react.baskino.rest;

import kz.csse.baskino.react.baskino.entities.Actors;
import kz.csse.baskino.react.baskino.entities.Genres;
import kz.csse.baskino.react.baskino.entities.Movies;
import kz.csse.baskino.react.baskino.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class MoviesRestController {

    @Autowired
    private MoviesService moviesService;


    @GetMapping(value = "/allMovies")
    public ResponseEntity<?> getAllMovies(){
        List<Movies> movies=moviesService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }


    @GetMapping(value = "/getOneMovie/{id}")
    public ResponseEntity<?> getOneMovie(@PathVariable(name = "id") Long id){
        Movies movies = moviesService.getOneMovie(id);
        if(movies!=null){
            return ResponseEntity.ok(movies);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/deleteMovie")
    public ResponseEntity<?> deleteMovie(@RequestBody Movies movies){
        System.out.println("zhatuu " + movies);
        Movies movies1 = moviesService.getOneMovie(movies.getId());
        if(movies1!=null){
            moviesService.deleteMovie(movies1);
            return ResponseEntity.ok(movies1);
        }
        return ResponseEntity.ok(movies1);
    }

    @PostMapping(value = "/addMovie")
    public ResponseEntity<?> addMovie(@RequestBody Movies movies){
        System.out.println("Add Moive +" + movies.getGenresList().size());
        moviesService.addMovie(movies);
        return ResponseEntity.ok(movies);
    }


    @PutMapping(value = "/saveMovie/{id}")
    public ResponseEntity<?> saveMovie(@RequestBody Movies movies,@PathVariable(name = "id") Long id){
        System.out.println("Hello");
        Movies movies1=moviesService.getOneMovie(id);

        movies1.setTitle(movies.getTitle());
        movies1.setDescription(movies.getDescription());
        movies1.setPicURL(movies.getPicURL());

        movies1.setImdb(movies.getImdb());
        movies1.setRashod(movies.getRashod());
        movies1.setSbor(movies.getSbor());

        movies1.setYear(movies.getYear());
        movies1.setCreatedDate(movies.getCreatedDate());
        movies1.setAddedDate(movies.getAddedDate());

        movies1.setActorsList(movies.getActorsList());
        movies1.setGenresList(movies.getGenresList());

        moviesService.saveMovie(movies1);
        return ResponseEntity.ok(movies1);
    }
}
