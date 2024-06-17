package com.kitchin.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service class for managing {@link User} entities.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Saves a user.
     *
     * @param user the user to save
     * @return the saved user
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Retrieves all users.
     *
     * @return a list of all users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Finds users with the specified age.
     *
     * @param age the age to compare
     * @return a list of users with the specified age
     */
    public List<User> getUsersByAge(int age) {
        return userRepository.findUsersByAge(age);
    }

    /**
     * Deletes users with the specified age.
     *
     * @param age the age of users to delete
     */
    public void deleteUsersByAge(int age) {
        userRepository.deleteUsersByAge(age);
    }
}