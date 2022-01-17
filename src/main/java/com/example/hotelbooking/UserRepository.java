package com.example.hotelbooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String> {
    User findUserByid(int id);
    User deleteUserByid(int id);
}
