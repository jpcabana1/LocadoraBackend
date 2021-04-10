package com.api.restfulApi.Models.DAOs;

import lombok.AllArgsConstructor;
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
        this.pass = EncriptyPassword(name, username, pass);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
       this.pass = pass;
    }

    public static String EncriptyPassword(String name, String username,String pass){
        Long hash = Math.abs((name.hashCode() * username.hashCode()) + (pass.charAt(0) + 1l));
        return hash.toString();
    }


}
