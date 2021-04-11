package com.api.restfulApi.Repository;

import com.api.restfulApi.Models.DAOs.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <UserDAO, Long> {
    @Query("select u from UserDAO u where u.username = :username and u.pass = :pass")
    Optional<UserDAO> validateLogin(@Param("username")String username, @Param("pass")String pass);

    @Query("select u from UserDAO u where u.username = :username")
    Optional<UserDAO> findByUsername(@Param("username")String username);
}
