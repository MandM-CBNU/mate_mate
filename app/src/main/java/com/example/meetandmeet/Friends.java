package com.example.meetandmeet;
/// 코드 작성자 2020039017 임수연 ///
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Friends {
    public String name;
    public String phone;
    public String birth;
    public String bmark;
    public  int imgUrl;
    public int progressNum;

    public Friends() { }
    public Friends(String name, String phone, String birth, int imgUrl, int progressNum) {
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.imgUrl= imgUrl;
        this.progressNum =progressNum;
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

    public void setBMark(String bmark) {
        this.bmark = bmark;
    }

    public int setImgUrl(int imgUrl) {return imgUrl;}

    public int setProgressNum(int progressNum){return progressNum;}

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

    public int getImgUrl(){return imgUrl;}

    public int getProgressNum(){return progressNum;}

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