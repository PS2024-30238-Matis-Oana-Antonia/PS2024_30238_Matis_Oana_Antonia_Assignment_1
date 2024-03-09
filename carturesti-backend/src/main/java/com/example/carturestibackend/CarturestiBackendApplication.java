package com.example.carturestibackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class CarturestiBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarturestiBackendApplication.class, args);
    }

}
