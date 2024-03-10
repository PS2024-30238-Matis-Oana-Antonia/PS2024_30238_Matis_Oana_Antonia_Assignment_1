package com.example.carturestibackend.repositories;

import com.example.carturestibackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
    User findByEmail(String email);
    //User findByEmailAndPass(String email, String pass);
}
