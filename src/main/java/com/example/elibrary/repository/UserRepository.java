package com.example.elibrary.repository;

import com.example.elibrary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    @Query("SELECT b FROM User b WHERE b.id= :user_id")
    User findByUserId(@Param("user_id") int user_id);

    @Query("SELECT b FROM User b WHERE b.username= :user_id")
    User findByUserIc(@Param("user_id") String user_id);

    @Query("SELECT b FROM User b WHERE b.approved= 'yes' ")
    List<User> findByApproved();

    @Query("SELECT b FROM User b WHERE b.approved= 'no' ")
    List<User> findByNotApproved();
}
