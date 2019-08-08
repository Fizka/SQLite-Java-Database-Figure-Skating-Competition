package com.SQLite;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SelectStatement databaseFigureSkating = new SelectStatement();

        databaseFigureSkating.insertTypesOfCompetition("Mistrzostwa Europy", "Rostelecom Cup");
        databaseFigureSkating.insertTypesOfCompetition("Grand Prix", "NHK Trophy");
        databaseFigureSkating.insertTypesOfCompetition("Mistrzostwa Swiata", "Zimowe Igrzyska Olimpijskie");
        databaseFigureSkating.insertTypesOfCompetition("Olimpiada", "Letnie Igrzyska Olimpijskie" );

        databaseFigureSkating.insertCompetition( "0000-00-00", "Olimpiada", "1");
        databaseFigureSkating.insertCompetition( "0000-00-00", "Mistrzostwa Swiata", "4");
        databaseFigureSkating.insertCompetition( "0000-00-00", "Mistrzostwa Europy", "2");
        databaseFigureSkating.insertCompetition( "0000-00-00", "Grand Prix", "3");


        databaseFigureSkating.insertContestant("Golo" , "Kuba");
        databaseFigureSkating.insertContestant("Mikos", "Kamil");
        databaseFigureSkating.insertContestant("Adryk", "Zuzana");
        databaseFigureSkating.insertContestant("Kowalski", "Patryk");
        databaseFigureSkating.insertContestant("Twokot", "Arkadiusz");
        databaseFigureSkating.insertContestant("Rekaman", "Anna");
        databaseFigureSkating.insertContestant("Huka", "Fredryk");

        databaseFigureSkating.insertLocation("Berlin");
        databaseFigureSkating.insertLocation("Moskwa");
        databaseFigureSkating.insertLocation("Warszawa");
        databaseFigureSkating.insertLocation("Wieden");

        databaseFigureSkating.insertSkating_Rink("Berlin", "Niemcy", "COS");
        databaseFigureSkating.insertSkating_Rink("Moskwa", "Rosja", "GUM");
        databaseFigureSkating.insertSkating_Rink("Warszawa", "Polska", "Erika Hess");
        databaseFigureSkating.insertSkating_Rink("Wieden", "Austria", "Donaustadt");

        databaseFigureSkating.insertMark("102.00", "37.00", "1", "4" );
        databaseFigureSkating.insertMark("87.00", "45.00", "8", "5");
        databaseFigureSkating.insertMark("96.00", "56.00", "2", "4");
        databaseFigureSkating.insertMark("78.00", "37.00", "9", "5");
        databaseFigureSkating.insertMark("67.00", "45.00", "3", "2");
        databaseFigureSkating.insertMark("88.00", "45.00", "10", "4");
        databaseFigureSkating.insertMark("67.00", "32.00", "4", "2");
        databaseFigureSkating.insertMark("73.00", "30.00", "11", "4");
        databaseFigureSkating.insertMark("83.00", "45.00", "5", "7");
        databaseFigureSkating.insertMark("74.00", "36.00", "12", "3");
        databaseFigureSkating.insertMark("89.00", "50.00", "6", "7");
        databaseFigureSkating.insertMark("80.00", "45.00", "13", "3");
        databaseFigureSkating.insertMark("109.00", "55.00", "7", "5");
        databaseFigureSkating.insertMark("99.00", "66.00", "14", "1");

        databaseFigureSkating.insertReferee("Adam", "Jodik");
        databaseFigureSkating.insertReferee("Patryk", "Wecko");
        databaseFigureSkating.insertReferee("Romek", "Werko");
        databaseFigureSkating.insertReferee("Atomek", "Ragger");
        databaseFigureSkating.insertReferee("Apolo", "Amiszko");
        databaseFigureSkating.insertReferee("Veno", "Stowic");
        databaseFigureSkating.insertReferee("Bianka", "Tyjko");

        databaseFigureSkating.insertScore("139.00", "dowolny", "5");
        databaseFigureSkating.insertScore("152.00", "dowolny", "4");
        databaseFigureSkating.insertScore("112.00", "dowolny", "3");
        databaseFigureSkating.insertScore("99.00", "dowolny", "2");
        databaseFigureSkating.insertScore("128.00", "dowolny", "1");
        databaseFigureSkating.insertScore("139.00", "dowolny", "1");
        databaseFigureSkating.insertScore("164.00", "dowolny", "2");
        databaseFigureSkating.insertScore("132.00", "krotki", "5");
        databaseFigureSkating.insertScore("115.00", "krotki", "4");
        databaseFigureSkating.insertScore("133.00", "krotki", "3");
        databaseFigureSkating.insertScore("103.00", "krotki", "2");
        databaseFigureSkating.insertScore("110.00", "krotki", "1");
        databaseFigureSkating.insertScore("125.00", "krotki", "1");
        databaseFigureSkating.insertScore("165.00", "krotki", "2");

        databaseFigureSkating.insertTeam("inwidualne");
        databaseFigureSkating.insertTeam("inwidualne");
        databaseFigureSkating.insertTeam("inwidualne");
        databaseFigureSkating.insertTeam("pary");
        databaseFigureSkating.insertTeam("pary");

        /*
        databaseFigureSkating.insertCompetition_Referee("1","4");
        databaseFigureSkating.insertCompetition_Referee("1","5");
        databaseFigureSkating.insertCompetition_Referee("2","2");
        databaseFigureSkating.insertCompetition_Referee("2","4");
        databaseFigureSkating.insertCompetition_Referee("3","1");
        databaseFigureSkating.insertCompetition_Referee("3","5");
        databaseFigureSkating.insertCompetition_Referee("4","3");
        databaseFigureSkating.insertCompetition_Referee("4","7");

        databaseFigureSkating.insertContestant_Team("1","1");
        databaseFigureSkating.insertContestant_Team("2","2");
        databaseFigureSkating.insertContestant_Team("3","3");
        databaseFigureSkating.insertContestant_Team("4","4");
        databaseFigureSkating.insertContestant_Team("4","5");
        databaseFigureSkating.insertContestant_Team("5","4");
        databaseFigureSkating.insertContestant_Team("6","5");
        databaseFigureSkating.insertContestant_Team("7","5");

        databaseFigureSkating.insertCompetition_Team("1","1");
        databaseFigureSkating.insertCompetition_Team("2","1");
        databaseFigureSkating.insertCompetition_Team("3","2");
        databaseFigureSkating.insertCompetition_Team("4","2");
        databaseFigureSkating.insertCompetition_Team("5","3");
        databaseFigureSkating.insertCompetition_Team("4","4");
        databaseFigureSkating.insertCompetition_Team("5","4");
*/

        List<Competition> competitionsList = databaseFigureSkating.selectCompetition();
        List<Contestant> contestantList = databaseFigureSkating.selectContestant();
        List<Location> locationList = databaseFigureSkating.selectLocation();
        List<Mark> markList = databaseFigureSkating.selectMark();
        List<Referee> refereeList = databaseFigureSkating.selectReferee();
        List<Score> scoreList = databaseFigureSkating.selectScore();
        List<Skating_Rink> skating_RinkList = databaseFigureSkating.selectSkating_Rink();
        List<TypesOfCompetition> typesOfCompetitionList = databaseFigureSkating.selectTypesOfCompetition();
        List<Team> teamList = databaseFigureSkating.selectTeam();


        System.out.println("Competition list: ");
        for(Competition c: competitionsList)
            System.out.println(c);

        System.out.println("Contestant list: ");
        for(Contestant c: contestantList)
            System.out.println(c);

        System.out.println("Location list: ");
        for(Location c: locationList)
            System.out.println(c);

        System.out.println("Mark list: ");
        for(Mark c: markList)
            System.out.println(c);

        System.out.println("Referee list: ");
        for(Referee c: refereeList)
            System.out.println(c);

        System.out.println("Score list: ");
        for(Score c: scoreList)
            System.out.println(c);

        System.out.println("Skating Rink list: ");
        for(Skating_Rink c: skating_RinkList)
            System.out.println(c);

        System.out.println("TypesOfCompetition list: ");
        for(TypesOfCompetition c: typesOfCompetitionList)
            System.out.println(c);

        System.out.println("Team list: ");
        for(Team c: teamList)
            System.out.println(c);


        databaseFigureSkating.closeConnection();
    }

}
