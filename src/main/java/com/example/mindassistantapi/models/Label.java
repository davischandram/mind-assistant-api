package com.example.mindassistantapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "labels")
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String status = "private";

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToOne
    @JsonIgnore
    private com.example.mindassistantapi.models.Folder folder;


    // On the target side that is Label, we only have to provide the name of the field, 
    // which maps the relationship. Therefore, we set the mappedBy attribute of the @ManyToMany annotation
    // the mappedBy value is taken from labels attribute name in the Note class.

    @ManyToMany(mappedBy = "labels")
    @JsonIgnore
    private List<Note> notes;

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

    public com.example.mindassistantapi.models.Folder getFolder() {
        return folder;
    }

    public void setFolder(com.example.mindassistantapi.models.Folder folder) {
        this.folder = folder;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Label)) {
            return false;
        }
        Label label = (Label) o;
        return id == label.id && Objects.equals(title, label.title) && Objects.equals(status, label.status) && Objects.equals(user, label.user) && Objects.equals(folder, label.folder) && Objects.equals(notes, label.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, status, user, folder, notes);
    }

}
