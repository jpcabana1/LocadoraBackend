package com.api.restfulApi.Business;

import com.api.restfulApi.Models.DAOs.UserDAO;
import com.api.restfulApi.Models.DTOS.UserDTO;
import com.api.restfulApi.Services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserBusiness {

    @Autowired
    private CrudService userService;

    public ResponseEntity<?> createUser(UserDTO userDTO) {
        try {
            return new ResponseEntity<>(userService.create(userDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> readUser(Long id) {
        try {
            return new ResponseEntity<>(userService.read(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> readAllUsers() {
        try {
            return new ResponseEntity<>(userService.readAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<?> updateUser(UserDTO userDTO) {
        try {
            Optional<UserDAO> userDAO = userService.read(userDTO.getId());
            if (userDAO.isPresent()) {
                userDTO.setName((userDTO.getName() != "") ? userDTO.getName() : userDAO.get().getName());
                userDTO.setUser((userDTO.getUser() != "") ? userDTO.getUser() : userDAO.get().getUsername());
                userDTO.setPass((userDTO.getPass() != "") ? UserDAO
                        .EncriptyPassword(userDAO.get().getName(),
                                userDAO.get().getUsername(),
                                userDAO.get().getPass()) : userDAO.get().getPass());
                userService.update(userDTO);
            } else {
                return new ResponseEntity<>(new Exception("Usuário não encontrado"), HttpStatus.NOT_ACCEPTABLE);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteUser(Long id) {
        try {
            userService.delete(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
