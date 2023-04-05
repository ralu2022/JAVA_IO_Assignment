package org.example;

public class CompetitionNumber {

    String number;

    public CompetitionNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "CompetitionNumber: " +
                 number + "\n" ;
    }
}
