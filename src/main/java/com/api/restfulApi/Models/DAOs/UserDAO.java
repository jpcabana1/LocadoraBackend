package com.api.restfulApi.Models.DAOs;


import com.api.restfulApi.Models.DTOS.UserDTO;
import lombok.Getter;
import lombok.Setter;

import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name = "tb_user", schema = "locadora")
@NoArgsConstructor
@Getter
@Setter

public class UserDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "pass", nullable = false)
    private String pass;

    public UserDAO(Long id, String name, String username, String pass) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.pass = encriptyPassword(name, username, pass);
    }

    public static String encriptyPassword(String name, String username, String pass){
        Integer nameCharacterSum = 0;
        Integer nameUsernameSum = 0;
        Integer namePassSum = 0;

        for(int i=0; i<name.length(); i++)
            nameCharacterSum = nameCharacterSum + name.charAt(i);

        for(int i=0; i<username.length(); i++)
            nameUsernameSum = nameUsernameSum + username.charAt(i);

        for(int i=0; i<pass.length(); i++)
            namePassSum = namePassSum + pass.charAt(i);

        Long hash = Math.abs((nameCharacterSum * nameUsernameSum * namePassSum)) + (pass.charAt(0) + 1l);
        return hash.toString();
    }

    public static UserDTO convertToDto(UserDAO userDAO){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userDAO.id);
        userDTO.setName(userDAO.name);
        userDTO.setUser(userDAO.username);
        userDTO.setPass(userDAO.pass);
        return userDTO;
    }

}
