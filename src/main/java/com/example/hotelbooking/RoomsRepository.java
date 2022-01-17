package com.example.hotelbooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoomsRepository extends JpaRepository<Room, String> {
    Room findRoomByid(int id);
    String deleteRoomByid(int id);
}
