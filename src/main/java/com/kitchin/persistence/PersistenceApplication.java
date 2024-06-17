package com.kitchin.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

/**
 * Main application class for Spring Boot.
 */
@SpringBootApplication
public class PersistenceApplication implements CommandLineRunner {

    private final UserService userService;

    /**
     * Constructs a new PersistenceApplication with the specified UserService.
     *
     * @param userService the user service to be used for user operations
     */
    @Autowired
    public PersistenceApplication(UserService userService) {
        this.userService = userService;
    }

    /**
     * Entry point of the Spring Boot application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(PersistenceApplication.class, args);
    }

    /**
     * Executes on application startup.
     *
     * @param args the input arguments
     * @throws Exception if an error occurs
     */
    @Override
    public void run(String... args) throws Exception {
        // Insert some users
        userService.saveUser(new User("Alice", 25));
        userService.saveUser(new User("John", 10));
        userService.saveUser(new User("Mary", 78));

        // Fetch all users
        List<User> allUsers = userService.getAllUsers();
        System.out.println("All users:");
        for (User user : allUsers) {
            System.out.println(user);
        }

        // Fetch users with specified age
        List<User> userByAge = userService.getUsersByAge(78);
        System.out.println("Users by age 78");
        for (User user : userByAge) {
            System.out.println(user);
        }

        // Delete users with specified age
        userService.deleteUsersByAge(78);
        System.out.println("Deleted users with age 78");

        // Fetch all users again to verify deletion
        List<User> remainingUsers = userService.getAllUsers();
        System.out.println("Remaining users:");
        for (User user : remainingUsers) {
            System.out.println(user);
        }
    }
}