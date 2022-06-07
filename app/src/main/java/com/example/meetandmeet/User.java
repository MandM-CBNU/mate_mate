package com.example.meetandmeet;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    public String name;
    public String phone;
    public String birth;

    public User() { }
    public User(String name, String phone, String birth) {
        this.name = name;
        this.phone = phone;
        this.birth = birth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.phone = email;
    }

    public void setAge(String age) {
        this.birth = age;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAge() {
        return birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + phone + '\'' +
                ", age=" + birth +
                '}';
    }
}