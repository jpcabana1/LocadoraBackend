package com.api.restfulApi.Services;

import com.api.restfulApi.Models.DAOs.UserDAO;
import com.api.restfulApi.Models.DTOS.UserDTO;
import com.api.restfulApi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Optional<UserDAO> create(UserDTO userDTO) {
        UserDAO userDAO = new UserDAO(userDTO.getId(), userDTO.getName(), userDTO.getUser(), userDTO.getPass());
        UserDAO response = repository.save(userDAO);
        return Optional.of(response);
    }

    @Override
    public Optional<UserDAO> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<UserDAO> readAll() {
        List<UserDAO> userDAOS = repository.findAll();
        Comparator<UserDAO> daoComparator = ((o1, o2) -> o1.getId().compareTo(o2.getId()));
        Collections.sort(userDAOS, daoComparator);
        return userDAOS;
    }

    @Override
    public Optional<UserDAO> update(UserDTO userDTO) {
        UserDAO userDAO = new UserDAO(userDTO.getId(), userDTO.getName(), userDTO.getUser(), userDTO.getPass());
        UserDAO response = repository.save(userDAO);
        return Optional.of(response);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
