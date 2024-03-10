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


/**
 * Service class to handle business logic related to users.
 */
@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    /**
     * Constructs a new UserService with the specified UserRepository.
     *
     * @param userRepository The UserRepository used to interact with user data in the database.
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves all users from the database.
     *
     * @return A list of UserDTO objects representing the users.
     */
    public List<UserDTO> findUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(UserBuilder::toUserDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id_user The ID of the user to retrieve.
     * @return The UserDTO object representing the retrieved user.
     * @throws ResourceNotFoundException if the user with the specified ID is not found.
     */
    public UserDTO findUserById(long id_user) {
        Optional<User> userOptional = userRepository.findById(id_user);
        if (!userOptional.isPresent()) {
            LOGGER.error("User with id {} was not found in db", id_user);
            throw new ResourceNotFoundException(User.class.getSimpleName() + " with id: " + id_user);
        }
        return UserBuilder.toUserDTO(userOptional.get());
    }

    /**
     * Retrieves a user by their name.
     *
     * @param name The name of the user to retrieve.
     * @return The UserDTO object representing the retrieved user.
     * @throws ResourceNotFoundException if the user with the specified name is not found.
     */
    public UserDTO findUserByName(String name) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByName(name));
        if (!userOptional.isPresent()) {
            LOGGER.error("User with name {} was not found in db", name);
            throw new ResourceNotFoundException(User.class.getSimpleName() + " with name: " + name);
        }
        return UserBuilder.toUserDTO(userOptional.get());
    }

    /**
     * Retrieves a user by their email.
     *
     * @param email The email of the user to retrieve.
     * @return The UserDTO object representing the retrieved user.
     * @throws ResourceNotFoundException if the user with the specified email is not found.
     */
    public UserDTO findUserByEmail(String email) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(email));
        if (!userOptional.isPresent()) {
            LOGGER.error("User with email {} was not found in db", email);
            throw new ResourceNotFoundException(User.class.getSimpleName() + " with email: " + email);
        }
        return UserBuilder.toUserDTO(userOptional.get());
    }

    /**
     * Inserts a new user into the database.
     *
     * @param userDTO The UserDTO object representing the user to insert.
     * @return The ID of the newly inserted user.
     */
    public long insert(UserDTO userDTO) {
        User user = UserBuilder.fromUserDTO(userDTO);
        user = userRepository.save(user);
        LOGGER.debug("User with id {} was inserted in db", user.getId_user());
        return user.getId_user();
    }

    /**
     * Deletes a user from the database by their ID.
     *
     * @param id_user The ID of the user to delete.
     * @throws ResourceNotFoundException if the user with the specified ID is not found.
     */
    public void deleteUserById(long id_user) {
        Optional<User> userOptional = userRepository.findById(id_user);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
        } else {
            throw new ResourceNotFoundException(User.class.getSimpleName() + " with id: " + id_user);
        }
    }

    /**
     * Updates an existing user in the database.
     *
     * @param id_user  The ID of the user to update.
     * @param userDTO The updated UserDTO object representing the new state of the user.
     * @return The updated UserDTO object.
     * @throws ResourceNotFoundException if the user with the specified ID is not found.
     */
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

