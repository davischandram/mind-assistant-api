package com.example.mindassistantapi.models;

import javax.persistence.*;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @Column(name = "id")
    private int id;
    private String picture;
    private String bio;

    @OneToOne
    @MapsId
    private User user;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean equals(Profile other){
        boolean result = true;
        if(this.id == other.id){
            result = result && true;
        }
        if(this.picture.equals(other.picture)){
            result = result && true;
        }
        if(this.bio.equals(other.bio)){
            result = result && true;
        }
        return  result;
    }
}
