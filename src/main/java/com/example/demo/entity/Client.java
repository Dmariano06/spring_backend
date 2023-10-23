package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Client {
    @Column(name="email")
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="clientname")
    private String clientname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    @Column(name="type_project")
    private String type_project;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "username", length = 255)
    private String user;

    public Client() {
    }
    public Client(Long clientid, String clientname, String email, String password) {
        this.id = clientid;
        this.clientname = clientname;
        this.email = email;
        this.password = password;
    }
}
