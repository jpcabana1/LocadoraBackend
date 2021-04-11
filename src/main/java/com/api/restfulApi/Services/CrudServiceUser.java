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

@Service()
public class CrudServiceUser implements CrudService {

    @Autowired
    private UserRepository repository;

    @Override
    public Optional<UserDAO> create(UserDTO userDTO) {
        try {
            UserDAO userDAO = new UserDAO(userDTO.getId(), userDTO.getName(), userDTO.getUser(), userDTO.getPass());
            UserDAO response = repository.save(userDAO);
            return Optional.of(response);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Optional<UserDAO> read(Long id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public Optional<UserDAO> findByUser(String username) {
        try {
            return repository.findByUsername(username);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<UserDAO> readAll() {
        try {
            List<UserDAO> userDAOS = repository.findAll();
            Comparator<UserDAO> daoComparator = ((o1, o2) -> o1.getId().compareTo(o2.getId()));
            Collections.sort(userDAOS, daoComparator);
            return userDAOS;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Optional<UserDAO> update(UserDTO userDTO) {
        try {
            UserDAO userDAO = new UserDAO();
            userDAO.setId(userDTO.getId());
            userDAO.setName(userDTO.getName());
            userDAO.setUsername(userDTO.getUser());
            userDAO.setPass(userDTO.getPass());
            UserDAO response = repository.save(userDAO);
            return Optional.of(response);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }

}