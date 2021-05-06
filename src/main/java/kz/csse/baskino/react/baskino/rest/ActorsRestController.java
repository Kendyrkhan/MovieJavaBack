package kz.csse.baskino.react.baskino.rest;

import kz.csse.baskino.react.baskino.entities.Actors;
import kz.csse.baskino.react.baskino.services.ActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class ActorsRestController {


    @Autowired
    private ActorsService actorsService;




    @GetMapping(value = "/allActors")
    public ResponseEntity<?> getAllActors(){
        List<Actors> actors=actorsService.getAllActors();
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }


    @GetMapping(value = "/getOneActor/{id}")
    public ResponseEntity<?> getOneActor(@PathVariable(name = "id") Long id){
        Actors actors = actorsService.getOneActors(id);
        if(actors!=null){
            return ResponseEntity.ok(actors);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/deleteActor")
    public ResponseEntity<?> deleteActor(@RequestBody Actors actors){
        System.out.println("zhatuu " + actors);
        Actors actors1 = actorsService.getOneActors(actors.getId());
        if(actors1!=null){
            actorsService.deleteActors(actors1);
            return ResponseEntity.ok(actors1);
        }
        return ResponseEntity.ok(actors1);
    }

    @PostMapping(value = "/addActor")
    public ResponseEntity<?> addActor(@RequestBody Actors actors){
        actorsService.addActors(actors);
        return ResponseEntity.ok(actors);
    }


    @PutMapping(value = "/saveActor/{id}")
    public ResponseEntity<?> saveActor(@RequestBody Actors actors,@PathVariable(name = "id") Long id){
        System.out.println("Hello");
        Actors actors1=actorsService.getOneActors(id);

        actors1.setName(actors.getName());
        actors1.setAvatar(actors.getAvatar());
        actors1.setBiography(actors.getBiography());
        actors1.setSurname(actors.getSurname());
        actors1.setBirthday(actors.getBirthday());
        System.out.println("ss :"  + actors1.getName());
        actorsService.saveActors(actors1);
        return ResponseEntity.ok(actors1);
    }
}
