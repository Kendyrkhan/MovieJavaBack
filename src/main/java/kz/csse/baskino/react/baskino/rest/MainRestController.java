package kz.csse.baskino.react.baskino.rest;

import kz.csse.baskino.react.baskino.dto.JwtRequest;
import kz.csse.baskino.react.baskino.dto.JwtResponse;
import kz.csse.baskino.react.baskino.dto.UserDTO;
import kz.csse.baskino.react.baskino.entities.UserPassword;
import kz.csse.baskino.react.baskino.entities.Users;
import kz.csse.baskino.react.baskino.jwt.JwtTokenGenerator;
import kz.csse.baskino.react.baskino.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")

public class MainRestController {

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;






    @GetMapping(value = "/profile")
    public ResponseEntity<?> profilePage(){
        Users user = getUser();
        return new ResponseEntity<>(new UserDTO(user.getId() , user.getEmail() , user.getRoles(), user.getFull_name()), HttpStatus.OK);
    }

    private Users getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            Users user = (Users) authentication.getPrincipal();
            return user;
        }
        return null;
    }

    @RequestMapping(value = "/auth")
    public ResponseEntity<?> auth(@RequestBody JwtRequest request) throws Exception {
        System.out.println(request.getPassword());
        authenticate(request.getEmail(), request.getPassword());
        final UserDetails userDetails = userService.loadUserByUsername(request.getEmail());
        final String token = jwtTokenGenerator.generateToken(userDetails);
        System.out.println("hihi  "+token);
        return ResponseEntity.ok(new JwtResponse(token));
    }


    @PostMapping(value = "/registration")
    public ResponseEntity<?> registration(@RequestBody Users users){
        System.out.println("osynda");
        System.out.println(users.getEmail());


        System.out.println(users.getFull_name());
        userService.createUser(users);
        return ResponseEntity.ok(users);
    }

    @PutMapping(value = "/updateFullName")
    public ResponseEntity<?> updateFullName(@RequestBody Users users){

        Users myUsers=userService.getUserByEmail(users.getEmail());
        myUsers.setFull_name(users.getFull_name());
        userService.saveUser(myUsers);
        return ResponseEntity.ok(myUsers);
    }


    @PostMapping(value = "/updatePassword")
    public ResponseEntity<?> updatePassword(@RequestBody UserPassword userPassword) {
        Users user = getUser();
        user = userService.updateUserPassword(user, userPassword.getOldPassword(), userPassword.getPassword());
        if (user != null) {
            return new ResponseEntity<>(new UserDTO(user.getId(), user.getEmail(), user.getRoles(), user.getFull_name()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    public void authenticate(String email, String password) throws Exception{

        try{

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        }catch (DisabledException e){
            throw new Exception("USER_DISABLED", e);
        }catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS", e);
        }

    }

    @GetMapping(value = "/allUsers")
    public ResponseEntity<?> getAllItems(){
        List<Users> users=userService.getAllUsers();


        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestBody Users users){
        System.out.println("zhatuu " + users);
        Users users2 = userService.getUser(users.getId());
        if(users2!=null){
            userService.deleteUser(users2);
            return ResponseEntity.ok(users2);
        }
        return ResponseEntity.ok(users2);
    }

    @PutMapping(value = "/saveUser/{id}")
    public ResponseEntity<?> saveUser(@RequestBody Users users,@PathVariable(name = "id") Long id){
        System.out.println("Hello");
        Users users1=userService.getUser(id);
        users1.setFull_name(users.getFull_name());
        users1.setEmail(users.getEmail());
        System.out.println("ss :"  + users1.getFull_name());

        userService.saveUser(users1);
        return ResponseEntity.ok(users1);
    }




















}
