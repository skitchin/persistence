package com.kitchin.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * User entity representing a user in the system.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    /**
     * Default constructor for JPA.
     */
    public User() {
    }

    /**
     * Constructs a new User with the specified name and age.
     *
     * @param name the name of the user
     * @param age the age of the user
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Returns the ID of the user.
     *
     * @return the user ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     *
     * @param id the user ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the user.
     *
     * @return the user name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name the user name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the age of the user.
     *
     * @return the user age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the user.
     *
     * @param age the user age
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}