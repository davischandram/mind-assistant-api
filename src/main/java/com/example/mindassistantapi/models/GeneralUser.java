package com.example.mindassistantapi.models;

import java.util.Objects;

public class GeneralUser extends User {
    private String occupation;

    public GeneralUser() {
    }

    public GeneralUser(String occupation) {
        this.occupation = occupation;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public GeneralUser occupation(String occupation) {
        this.occupation = occupation;
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
        return Objects.equals(occupation, generalUser.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(occupation);
    }

    @Override
    public String toString() {
        return "{" +
                " occupation='" + getOccupation() + "'" +
                "}";
    }
}
