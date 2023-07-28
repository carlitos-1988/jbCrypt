package com.bcrypt.jbCrypt.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
    String userName;
    String password;

    @OneToMany(mappedBy = "siteUser")
    List<Blog> blogs;

    protected SiteUser(){}

    public SiteUser( String userName, String password) {

        this.userName = userName;
        this.password = password;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
