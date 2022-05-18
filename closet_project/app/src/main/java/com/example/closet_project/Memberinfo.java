package com.example.closet_project;

public class Memberinfo {

    private String name;
    private String phone;
    private String birth;
    private String address;
    private String photoUrl;

    public Memberinfo(String name, String phone, String birth, String address, String photoUrl){
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.address = address;
        this.photoUrl = photoUrl;
    }

    public String getName(){
        return this.name;
    }
    public void setName(){
        this.name = name;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setPhone(){
        this.phone = phone;
    }
    public String getBirth(){
        return this.birth;
    }
    public void setBirth(){
        this.birth = birth;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(){
        this.address = address;
    }
    public String getPhotoUrl(){
        return this.photoUrl;
    }
    public void setPhotoUrl(){
        this.address = photoUrl;
    }

}
