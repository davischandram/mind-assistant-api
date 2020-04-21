package com.example.mindassistantapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "folders")
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToOne
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "folder")
    private List<Note> notes;

    @OneToMany(mappedBy = "folder")
    private List<Label> labels;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean equals(Folder other){
        boolean result = true;
        if(this.id == other.id){
            result = result && true;
        }
        if(this.title.equals(other.title)){
            result = result && true;
        }
        if(this.getUser().equals(other.getUser())){
            result = result && true;
        }
        return  result;
    }
}
