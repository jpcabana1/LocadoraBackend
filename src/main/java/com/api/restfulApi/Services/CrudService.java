package com.api.restfulApi.Services;

import com.api.restfulApi.Models.DAOs.UserDAO;
import com.api.restfulApi.Models.DTOS.UserDTO;

import java.util.List;
import java.util.Optional;

public interface CrudService {

    Optional<UserDAO> create(UserDTO userDTO);
    Optional<UserDAO> read(Long id);
    List<UserDAO> readAll();
    Optional<UserDAO> update(UserDTO userDTO);
    void delete(Long id);

}
