package com.example.mindassistantapi.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class StudentUser extends User {

    private String school;

    public StudentUser() {
    }

    public StudentUser(String school) {
        this.school = school;
    }

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public StudentUser school(String school) {
        this.school = school;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StudentUser)) {
            return false;
        }
        StudentUser studentUser = (StudentUser) o;
        return Objects.equals(school, studentUser.school);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(school);
    }

    @Override
    public String toString() {
        return "{" +
                " school='" + getSchool() + "'" +
                "}";
    }

}