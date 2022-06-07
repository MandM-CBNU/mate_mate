package com.example.meetandmeet;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Friends {
    public String name;
    public String phone;
    public String birth;

    public Friends() { }
    public Friends(String name, String phone, String birth) {
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

    public void setAge(String birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirth() {
        return birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", birth=" + birth +
                '}';
    }
}