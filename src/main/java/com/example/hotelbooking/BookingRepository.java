package com.example.hotelbooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BookingRepository extends JpaRepository<Booking, String> {
    Booking findBookingByid(int id);
    String deleteBookingByid(int id);
}
