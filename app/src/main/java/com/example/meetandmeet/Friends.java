package com.example.meetandmeet;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Friends {
    public String name;
    public String phone;
    public String birth;
    public String bmark;

    public Friends() { }
    public Friends(String name, String phone, String birth) {
        this.name = name;
        this.phone = phone;
        this.birth = birth;
    }

    public Friends(String bmark) {
        this.bmark = bmark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setBMark(String birth) {
        this.bmark = bmark;
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

    public String getBMark() {
        return bmark;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", birth='" + birth + '\'' +
                ", bmark=" + bmark +
                '}';
    }
}