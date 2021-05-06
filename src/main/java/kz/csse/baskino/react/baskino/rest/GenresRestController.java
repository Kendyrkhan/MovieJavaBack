package kz.csse.baskino.react.baskino.rest;

import kz.csse.baskino.react.baskino.entities.Genres;
import kz.csse.baskino.react.baskino.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class GenresRestController {

    @Autowired
    private GenreService genreService;


    @GetMapping(value = "/allGenres")
    public ResponseEntity<?> getAllGenres(){
        List<Genres> cards=genreService.getAllGenres();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }



    @GetMapping(value = "/getOneGenre/{id}")
    public ResponseEntity<?> getOneGenre(@PathVariable(name = "id") Long id){
        Genres genre = genreService.getOneGenres(id);
        if(genre!=null){
            return ResponseEntity.ok(genre);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/deleteGenre")
    public ResponseEntity<?> deleteGenre(@RequestBody Genres genre){
        System.out.println("zhatuu " + genre);
        Genres genre2 = genreService.getOneGenres(genre.getId());
        if(genre2!=null){
            genreService.deleteGenres(genre2);
            return ResponseEntity.ok(genre2);
        }
        return ResponseEntity.ok(genre2);
    }

    @PostMapping(value = "/addGenre")
    public ResponseEntity<?> addGenre(@RequestBody Genres genre){
        genreService.addGenres(genre);
        return ResponseEntity.ok(genre);
    }


    @PutMapping(value = "/saveGenre/{id}")
    public ResponseEntity<?> saveGenre(@RequestBody Genres genres,@PathVariable(name = "id") Long id){
        System.out.println("Hello");
        Genres genres1=genreService.getOneGenres(id);
        genres1.setName(genres.getName());
        System.out.println("ss :"  + genres1.getName());
        genreService.saveGenres(genres1);
        return ResponseEntity.ok(genres1);
    }





}
