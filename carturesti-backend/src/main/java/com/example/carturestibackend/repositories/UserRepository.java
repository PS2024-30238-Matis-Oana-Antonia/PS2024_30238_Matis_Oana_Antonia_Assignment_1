package com.example.carturestibackend.repositories;

import com.example.carturestibackend.entities.Order;
import com.example.carturestibackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
    User findByEmail(String email);


}
