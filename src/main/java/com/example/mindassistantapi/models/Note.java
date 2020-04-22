package com.example.mindassistantapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String note;
    private String title;
    private String status = "private";

    @ManyToOne
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JsonIgnore
    private com.example.mindassistantapi.models.Folder folder;

    @ManyToMany
    @JsonIgnore
//    "@JoinTable" and its options are optional to avoid JPA defaults, 
//         otherwise JPA will choose how to name columns. Only one side of the many to many needs this.
//              Simply pick the side that makes most sense. Somewhat arbitrary.
//    @JoinTable(
//   name = "course_like", 
//   joinColumns = @JoinColumn(name = "student_id"), 
//   inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<com.example.mindassistantapi.models.Label> labels;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public com.example.mindassistantapi.models.Folder getFolder() {
        return folder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setFolder(com.example.mindassistantapi.models.Folder folder) {
        this.folder = folder;
    }

    public List<com.example.mindassistantapi.models.Label> getLabels() {
        return labels;
    }

    public void setLabels(List<com.example.mindassistantapi.models.Label> labels) {
        this.labels = labels;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Note)) {
            return false;
        }
        Note note = (Note) o;
        return id == note.id && Objects.equals(note, note.note) && Objects.equals(title, note.title) && Objects.equals(status, note.status) && Objects.equals(user, note.user) && Objects.equals(folder, note.folder) && Objects.equals(labels, note.labels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, note, title, status, user, folder, labels);
    }

}
