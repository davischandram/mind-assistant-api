package com.example.mindassistantapi.models;

import java.util.Objects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
// @Table(name="students")
@DiscriminatorValue("student")
public class StudentUser extends User {

    private String school1;

    public StudentUser() {
    }

    public StudentUser(String school) {
        this.school1 = school;
    }

    public String getSchool1() {
        return this.school1;
    }

    public void setSchool(String school) {
        this.school1 = school;
    }

    public StudentUser school(String school) {
        this.school1 = school;
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
        return Objects.equals(school1, studentUser.school1);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(school1);
    }

    @Override
    public String toString() {
        return "{" +
                " school='" + getSchool1() + "'" +
                "}";
    }

}