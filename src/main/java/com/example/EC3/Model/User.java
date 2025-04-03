package com.example.EC3.Model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;
    private String password;
    private String role;
    private Boolean isEnabled;

    public User() {
    }

    public User(String userName, String password, String role,Boolean isEnabled) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.isEnabled = isEnabled;
    }
    //getters

    public Long getId() {
        return id;
    }

    public Boolean isEnabled() {
        return isEnabled;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getUserName() {
        return userName;
    }


    //setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
