package com.bridelabz.json.convertobjectlist;

public class User {
    // Attributes
    private int id;
    private String name;
    private int age;
    private String email;

    // Constructor
    public User(){}

    public User(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
}
