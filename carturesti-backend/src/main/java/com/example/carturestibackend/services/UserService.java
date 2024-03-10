package com.example.carturestibackend.services;

import com.example.carturestibackend.dtos.UserDTO;
import com.example.carturestibackend.dtos.builders.UserBuilder;
import com.example.carturestibackend.entities.User;
import com.example.carturestibackend.repositories.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;

import java.util.stream.Collectors;

@Service
public class UserService {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(UserBuilder::toUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO findUserById(long id_user) {
        Optional<User> userOptional = userRepository.findById(id_user);
        if (!userOptional.isPresent()) {
            LOGGER.error("User with id {} was not found in db", id_user);
            throw new ResourceNotFoundException(User.class.getSimpleName() + " with id: " + id_user);
        }
        return UserBuilder.toUserDTO(userOptional.get());
    }
    public UserDTO findUserByName(String name) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByName(name));
        if (!userOptional.isPresent()) {
            LOGGER.error("User with name {} was not found in db", name);
            throw new ResourceNotFoundException(User.class.getSimpleName() + " with id: " + name);
        }
        return UserBuilder.toUserDTO(userOptional.get());
    }
    public UserDTO findUserByEmail(String email) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(email));
        if (!userOptional.isPresent()) {
            LOGGER.error("User with email {} was not found in db", email);
            throw new ResourceNotFoundException(User.class.getSimpleName() + " with id: " + email);
        }
        return UserBuilder.toUserDTO(userOptional.get());
    }

    public long insert(UserDTO userDTO) {
        User user = UserBuilder.fromUserDTO(userDTO);
        user = userRepository.save(user);
        LOGGER.debug("Person with id {} was inserted in db", user.getId_user());
        return user.getId_user();
    }

    public void deleteUserById(long id_user) {
        Optional<User> userOptional = userRepository.findById(id_user);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
        } else {
            throw new ResourceNotFoundException(User.class.getSimpleName() + " with id: " + id_user);
        }
    }

    public UserDTO updateUser(long id_user, UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findById(id_user);
        if (!userOptional.isPresent()) {
            LOGGER.error("User with id {} was not found in db", id_user);
            throw new ResourceNotFoundException(User.class.getSimpleName() + " with id: " + id_user);
        }

        User existingUser = userOptional.get();
        existingUser.setName(userDTO.getName());
        existingUser.setAge(userDTO.getAge());
        existingUser.setAddress(userDTO.getAddress());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setRole(userDTO.getRole());

        User updatedUser = userRepository.save(existingUser);
        LOGGER.debug("User with id {} was updated in db", updatedUser.getId_user());

        return UserBuilder.toUserDTO(updatedUser);
    }

}
