package com.api.restfulApi.Controllers;

import com.api.restfulApi.Business.UserBusiness;
import com.api.restfulApi.Models.DTOS.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserBusiness userBusiness;

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        return userBusiness.createUser(userDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return userBusiness.readAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        return userBusiness.readUser(id);
    }

    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO) {
        return userBusiness.updateUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") Long id) {
        return userBusiness.deleteUser(id);
    }


}
