package com.sedatram.model;
import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;
    @Column(nullable = false)
    private String user;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
