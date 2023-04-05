package org.example;

import java.util.*;

/**
 * DESCRIPTION - Ski Biathlon Standings
 * <p>
 * - write a software that takes as an input a CSV file where every entry represents the results of a biathlon athlete
 * - based on the entries identify the first 3 places (Winner, Runner-up and Third Place)
 * - the rules are simple, each athlete has a time-results for the entire skiing session, and 3 shooting range results
 * - each shooting range has 5 shot results
 * - for every missed shot the athlete obtains a 10 seconds penalty which affects the final time-result
 * - final standings are based on the time-results that have been updated with the shooting range results
 * <p>
 * CSV example:
 * <p>
 * 11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo
 * <p>
 * 1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo
 * <p>
 * 27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx
 * <p>
 * COLUMN:
 * <p>
 * AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange.SecondShooting,ThirdShooting
 * <p>
 * - every shooting range consists of 5 characters, where x means hit, o mean miss
 * - for every o there should be 10 seconds added to the final time
 * <p>
 * RESULTS:
 * <p>
 * Winner - Piotr Smitzer 30:10 (30:10 + 0)
 * Runner-up - Jimmy Smiles 30:15 (29:15 + 60)
 * Third Place - Umar Jorgson 30:57 (30:27 + 30)
 * <p>
 * TASK:
 * <p>
 * - write tests for the CSV parsing and the standing calculation
 * - in the tests you must not use real files
 * - make sure the CSVs are read from memory to keep the tests fast
 * - use Comparator / Comparable for sorting
 * - use at least 1 Enum (in any situation) and at least 2 Annotations (they don't need to be custom)
 */


public class App {
    public static void main(String[] args) {

        Set<CompetitionNumber> competitionNumberList = new HashSet<>();
        List<Athlete> athleteList = new ArrayList<>();
        List<String> countryList = new ArrayList<>();
        List<ResultPerTiming> resultsPerTiming = new ArrayList<>();
        List<ShotType> firstShot = new ArrayList<>();
        List<ShotType> secondShot = new ArrayList<>();
        List<ShotType> thirdShot = new ArrayList<>();


        String number = " ";
        while (!number.equalsIgnoreCase("0")) {
            Scanner scannerCompetitionNumber = new Scanner(System.in);
            number = scannerCompetitionNumber.nextLine();
            CompetitionNumber competitionNumber = new CompetitionNumber(number);
            competitionNumberList.add(competitionNumber);
        }

        String firstName = " ";
        String lastName = " ";
        while (!firstName.equalsIgnoreCase("N/A") && !lastName.equalsIgnoreCase("N/A")) {
            Scanner scannerFirstName = new Scanner(System.in);
            firstName = scannerFirstName.nextLine();
            Scanner scannerLastName = new Scanner(System.in);
            lastName = scannerLastName.nextLine();
            Athlete athlete = new Athlete(lastName, firstName);
            athleteList.add(athlete);
        }

        String country = " ";
        while (!country.equalsIgnoreCase("US")) {
            Scanner scannerCountry = new Scanner(System.in);
            country = scannerCountry.nextLine();

            for (Country countryEnum : Country.values()) {
                if (country == countryEnum.name()) {
                    countryList.add(country);
                    return;
                } else {
                    System.out.println("Country does not participate");
                }

            }
        }

        int minute = 0;
        int second = 0;

        while (minute != 0 && second != 0) {
            Scanner scannerMinut = new Scanner(System.in);
            Scanner scannerSeconds = new Scanner(System.in);
            minute = Integer.parseInt(scannerMinut.nextLine());
            second = Integer.parseInt(scannerMinut.nextLine());
            ResultPerTiming resultPerTiming = new ResultPerTiming(minute, second);
            resultsPerTiming.add(resultPerTiming);
        }
    }



}
