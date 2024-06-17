package com.kitchin.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller for managing {@link User} entities.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Creates a new user.
     *
     * @param user the user to create
     * @return the created user
     */
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * Retrieves all users.
     *
     * @return a list of all users
     */
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    /**
     * Retrieves users with the specified age.
     *
     * @param age the age to compare
     * @return a list of users with the specified age
     */
    @GetMapping("/age")
    public List<User> getUsersByAge(@RequestParam int age) {
        return userService.getUsersByAge(age);
    }

    /**
     * Deletes users with the specified age.
     *
     * @param age the age of users to delete
     */
    @DeleteMapping("/age")
    public void deleteUsersByAge(@RequestParam int age) {
        userService.deleteUsersByAge(age);
    }
}
