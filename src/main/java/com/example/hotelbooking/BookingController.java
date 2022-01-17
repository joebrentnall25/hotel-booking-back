package com.example.hotelbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {
    @Autowired
    UserRepository userRepository;

    // User Endpoints

    // Get Requests
    @GetMapping("/users")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getUsersById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findUserByid(Integer.parseInt(id)));
    }

    // Post Request
    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user){
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User added " + user.getUsername());
    }

    // Delete Request
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable String id){
        userRepository.deleteUserByid(Integer.parseInt(id));
        return ResponseEntity.status(HttpStatus.OK).body("User with id " + id + " deleted.");
    }
}
