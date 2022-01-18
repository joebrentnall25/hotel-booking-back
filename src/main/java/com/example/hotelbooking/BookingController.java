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

    @Autowired
    RoomsRepository roomsRepository;

    @Autowired
    BookingRepository bookingRepository;

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


    // Room Endpoints

    // Get Requests
    @GetMapping("/rooms")
    public ResponseEntity getRooms(){
        return ResponseEntity.status(HttpStatus.OK).body(roomsRepository.findAll());
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity getRoomById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(roomsRepository.findRoomByid(Integer.parseInt(id)));
    }

    // Post Request
    @PostMapping("/rooms")
    public ResponseEntity<String> createRoom(@RequestBody Room room){
        roomsRepository.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).body("Room added " + room.getRoomNumber());
    }

    // Delete Request
    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<String> deleteRoomById(@PathVariable String id){
        roomsRepository.deleteRoomByid(Integer.parseInt(id));
        return ResponseEntity.status(HttpStatus.OK).body("Room with id " + id + " deleted.");
    }


    // Booking Endpoints

    // Get Requests
    @GetMapping("/bookings")
    public ResponseEntity getBookings(){
        return ResponseEntity.status(HttpStatus.OK).body(bookingRepository.findAll());
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity getBookingById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(bookingRepository.findBookingByid(Integer.parseInt(id)));
    }

    // Post Request
    @PostMapping("/bookings")
    public ResponseEntity<String> createBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body("RoomId Booked: " + booking.getRoomId() + ", Booked for user with id: "+booking.getUserId());
    }

    // Delete Request
    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<String> deleteBookingById(@PathVariable String id){
        bookingRepository.deleteBookingByid(Integer.parseInt(id));
        return ResponseEntity.status(HttpStatus.OK).body("Booking with id " + id + " deleted.");
    }
}
