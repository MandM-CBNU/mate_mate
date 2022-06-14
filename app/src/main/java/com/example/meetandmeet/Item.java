package com.example.meetandmeet;

import android.widget.Button;

public class Item {

    private String name, phone, birthday;
    private int prograssBar;
    private int image;

    public Item(String name, String phone, String birthday, int prograssBar, int image) {
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        this.prograssBar = prograssBar;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){ this.name = name; }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public int getPrograssBar() { return prograssBar; }

    public void setPrograssBar(int prograssBar){
        this.prograssBar = prograssBar;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image){
        this.image = image;
    }


}

/*
public class Item {
    private String day;
    private String task;
    private String details;

    public Item(String day, String task, String details) {
        this.day=day;
        this.task=task;
        this.details=details;
    }

    public String getDay(){
        return day;
    }

    public String getTask(){
        return task;
    }

    public String getDetails(){
        return details;
    }
}
 */
