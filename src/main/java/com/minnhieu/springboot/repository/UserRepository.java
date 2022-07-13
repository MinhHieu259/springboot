package com.minnhieu.springboot.repository;

import com.minnhieu.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("from User where userName=:username")
    User findByUserName(@Param("username") String username);
}
