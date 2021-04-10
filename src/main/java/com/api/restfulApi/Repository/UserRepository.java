package com.api.restfulApi.Repository;

import com.api.restfulApi.Models.DAOs.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserDAO, Long> {
}
