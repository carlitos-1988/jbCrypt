package com.bcrypt.jbCrypt.models;

import jakarta.persistence.*;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String nameOfBlog;
    String topic;

    @ManyToOne
    SiteUser siteUser;


    protected Blog(){};

    public Blog(String nameOfBlog, String topic) {
        this.nameOfBlog = nameOfBlog;
        this.topic = topic;
    }
}
