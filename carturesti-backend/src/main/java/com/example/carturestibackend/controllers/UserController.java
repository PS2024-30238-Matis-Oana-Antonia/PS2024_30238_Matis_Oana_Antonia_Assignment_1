package com.example.carturestibackend.controllers;

import com.example.carturestibackend.dtos.UserDTO;
import com.example.carturestibackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> dtos = userService.findUsers();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertProsumer(@RequestBody UserDTO userDTO) {
        long userID = userService.insert(userDTO);
        return new ResponseEntity<>(userID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id_user}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id_user") long userID) {
        UserDTO dto = userService.findUserById(userID);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id_user}")
    public ResponseEntity<String> deleteUser(@PathVariable("id_user") long userID) {
        // Call the service method to delete the user by ID
        userService.deleteUserById(userID);
        return new ResponseEntity<>("User with ID " + userID + " deleted successfully", HttpStatus.OK);
    }

    @PutMapping(value = "/{id_user}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id_user") String userID, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUser(Long.parseLong(userID), userDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

}