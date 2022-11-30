package api;

import java.io.*;

public class User {
    private String name;
    private String surname;
    private String username;
    private int password;
    private String type;

    public User(String name, String surname, String username, int password, String type) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    //Getters
    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getUsername() {
        return this.username;
    }

    public int getPassword() {
        return this.password;
    }

    public String getType() {
        return this.type;
    }

    public void printUserData() {
        System.out.println("Name: " + this.name);
        System.out.println("Surname: " + this.surname);
    }
}
