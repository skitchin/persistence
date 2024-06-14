package com.kitchin.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class PersistenceApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public PersistenceApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PersistenceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userService.saveUser(new User("Alice", 25));
        userService.saveUser(new User("John", 10));
        userService.saveUser(new User("Mary", 78));

        List<User> allUsers = userService.getAllUsers();
        System.out.println("All users: ");
        for (User user : allUsers) {
            System.out.println(user);
        }

        List<User> userByAge = userService.getUsersByAge(78);
        System.out.println("Users by age: ");
        for (User user : userByAge) {
            System.out.println(user);
        }
    }
}