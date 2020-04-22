package com.example.mindassistantapi.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Objects;

@Entity
// @Table(name="generalusers")
@DiscriminatorValue("general")
public class GeneralUser extends User {
    private String occupation1;

    public GeneralUser() {
    }

    public GeneralUser(String occupation) {
        this.occupation1 = occupation;
    }

    public String getOccupation1() {
        return this.occupation1;
    }

    public void setOccupation1(String occupation) {
        this.occupation1 = occupation;
    }

    public GeneralUser occupation(String occupation) {
        this.occupation1 = occupation;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GeneralUser)) {
            return false;
        }
        GeneralUser generalUser = (GeneralUser) o;
        return Objects.equals(occupation1, generalUser.occupation1);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(occupation1);
    }

    @Override
    public String toString() {
        return "{" +
                " occupation='" + getOccupation1() + "'" +
                "}";
    }
}
