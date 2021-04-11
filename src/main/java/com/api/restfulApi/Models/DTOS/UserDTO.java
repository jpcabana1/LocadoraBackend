package com.api.restfulApi.Models.DTOS;

import com.api.restfulApi.Models.DAOs.UserDAO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("username")
    private String user;
    @JsonProperty("pass")
    private String pass;

    public static UserDAO convertToDao(UserDTO userDTO){
        UserDAO userDAO = new UserDAO();
        userDAO.setId(userDAO.getId());
        userDAO.setName(userDAO.getName());
        userDAO.setUsername(userDAO.getUsername());
        userDAO.setPass(userDAO.getPass());
        return userDAO;
    }

}
