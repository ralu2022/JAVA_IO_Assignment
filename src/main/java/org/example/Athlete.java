package org.example;

import java.util.Set;

public class Athlete {
    private String firstName;
    private String lastName;

    public Athlete(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " +
                 lastName + "\n";
    }
}


