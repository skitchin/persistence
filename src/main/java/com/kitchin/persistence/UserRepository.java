package com.kitchin.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Repository interface for {@link User} instances.
 * Provides basic CRUD operations due to the extension of {@link JpaRepository}.
 * Includes custom query methods.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds users with the specified age.
     *
     * @param age the age to compare
     * @return a list of users with the specified age
     */
    @Query("SELECT u FROM User u WHERE u.age = :age")
    List<User> findUsersByAge(int age);

    /**
     * Deletes users with the specified age.
     *
     * @param age the age of users to delete
     */
    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.age = :age")
    void deleteUsersByAge(int age);
}