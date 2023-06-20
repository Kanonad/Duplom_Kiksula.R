package com.example.directory;

public class User {
    public String id, name, pname, email;

    public User(String id, String coment) {
    }

    public User(String id, String name, String pname, String email) {
        this.id = id;
        this.name = name;
        this.pname = pname;
        this.email = email;
    }
}
