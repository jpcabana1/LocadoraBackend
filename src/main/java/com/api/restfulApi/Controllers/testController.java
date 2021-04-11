package com.api.restfulApi.Controllers;

import com.api.restfulApi.Models.DTOS.Message;
import com.api.restfulApi.Repository.NativeQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class testController {

    @Autowired
    private NativeQueryRepository nativeQueryRepository;

    @GetMapping("/hello")
    public ResponseEntity<Message> exampleMessage() {
        return new ResponseEntity<>(new Message("Hello World!"), HttpStatus.OK);
    }

    @GetMapping("/query/{id}")
    public List<Object> nativeQuery(@PathVariable(value = "id") Long id) {
        return nativeQueryRepository.nativeQueryExample(id);
    }

}
