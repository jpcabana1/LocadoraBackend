package com.api.restfulApi.Controllers;

import com.api.restfulApi.Models.DAOs.UserDAO;
import com.api.restfulApi.Models.DTOS.UserDTO;
import com.api.restfulApi.Services.UserService;
import com.api.restfulApi.Services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<UserDAO> createUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.create(userDTO).get());
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDAO>> findAll(){
        return new ResponseEntity<>(userService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDAO> findById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(userService.read(id).get());
    }

    @PutMapping()
    public ResponseEntity<UserDAO> updateUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.update(userDTO).get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") Long id){
        userService.delete(id);
        return ResponseEntity.ok(id);
    }


}
