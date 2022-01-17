package com.example.hotelbooking;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {
    @Autowired
    UserRepository userRepository;

    // User Endpoints

    @GetMapping("/users")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getUsersById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findUserByid(Integer.parseInt(id)));
    }
}
