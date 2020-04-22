package com.example.mindassistantapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(
//     discriminatorType = DiscriminatorType.STRING,
//     // name = "user_type_id",
//     columnDefinition = "VARCHAR(200)"
// )
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="username", unique=true)
    private String username;
    private String password;
    private String fname;
    private String lname;
    private String role;
    private String school;
    private String occupation;

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private com.example.mindassistantapi.models.Profile profile;

    @OneToMany(mappedBy = "user")
    private List<com.example.mindassistantapi.models.Note> notes;

    @OneToMany(mappedBy = "user")
    private List<com.example.mindassistantapi.models.Folder> folders;

    @OneToMany(mappedBy = "user")
    private List<com.example.mindassistantapi.models.Label> labels;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public com.example.mindassistantapi.models.Profile getProfile() {
        return profile;
    }

    public void setProfile(com.example.mindassistantapi.models.Profile profile) {
        this.profile = profile;
    }

    public List<com.example.mindassistantapi.models.Note> getNotes() {
        return notes;
    }

    public void setNotes(List<com.example.mindassistantapi.models.Note> notes) {
        this.notes = notes;
    }

    public List<com.example.mindassistantapi.models.Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<com.example.mindassistantapi.models.Folder> folders) {
        this.folders = folders;
    }

    public List<com.example.mindassistantapi.models.Label> getLabels() {
        return labels;
    }

    public void setLabels(List<com.example.mindassistantapi.models.Label> labels) {
        this.labels = labels;
    }

    public boolean equals(User other){
        boolean result = true;
        if(this.id == other.id){
            result = result && true;
        }
        if(this.username.equals(other.username)){
            result = result && true;
        }
        if(this.password.equals(other.password)){
            result = result && true;
        }
        if(this.fname.equals(other.fname)){
            result = result && true;
        }
        if(this.lname.equals(other.lname)){
            result = result && true;
        }
        if(this.role.equals(other.role)){
            result = result && true;
        }
        return  result;
    }
}
