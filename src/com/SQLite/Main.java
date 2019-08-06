package com.SQLite;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CreateStatement databaseFigureSkating = new CreateStatement();

        databaseFigureSkating.insertCompetition( "0000-00-00", "Olimpiada", "");
        databaseFigureSkating.insertCompetition( "0000-00-00", "Mistrzostwa Swiata", "");
        databaseFigureSkating.insertCompetition( "0000-00-00", "Mistrzostwa Europy", "");
        databaseFigureSkating.insertCompetition( "0000-00-00", "Grand Prix", "");

        databaseFigureSkating.insertTypesOfCompetition("Mistrzostwa Europy", "Rostelecom Cup");
        databaseFigureSkating.insertTypesOfCompetition("Grand Prix", "NHK Trophy");
        databaseFigureSkating.insertTypesOfCompetition("Mistrzostwa Swiata", "Zimowe Igrzyska Olimpijskie");
        databaseFigureSkating.insertTypesOfCompetition("Olimpiada", "Letnie Igrzyska Olimpijskie" );

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

        databaseFigureSkating.insertMark("102.00", "37.00", "", "" );
        databaseFigureSkating.insertMark("87.00", "45.00", "", "");
        databaseFigureSkating.insertMark("96.00", "56.00", "", "");
        databaseFigureSkating.insertMark("78.00", "37.00", "", "");
        databaseFigureSkating.insertMark("67.00", "45.00", "", "");
        databaseFigureSkating.insertMark("88.00", "45.00", "", "");
        databaseFigureSkating.insertMark("67.00", "32.00", "", "");
        databaseFigureSkating.insertMark("73.00", "30.00", "", "");
        databaseFigureSkating.insertMark("83.00", "45.00", "", "");
        databaseFigureSkating.insertMark("74.00", "36.00", "", "");
        databaseFigureSkating.insertMark("89.00", "50.00", "", "");
        databaseFigureSkating.insertMark("80.00", "45.00", "", "");
        databaseFigureSkating.insertMark("109.00", "55.00", "", "");
        databaseFigureSkating.insertMark("99.00", "66.00", "", "");

        databaseFigureSkating.insertReferee("", "Jodik");
        databaseFigureSkating.insertReferee("", "Wecko");
        databaseFigureSkating.insertReferee("", "Werko");
        databaseFigureSkating.insertReferee("", "Ragger");
        databaseFigureSkating.insertReferee("", "Amiszko");
        databaseFigureSkating.insertReferee("", "Stowic");
        databaseFigureSkating.insertReferee("", "Tyjko");

        databaseFigureSkating.insertScore("139.00", "dowolny", "");
        databaseFigureSkating.insertScore("152.00", "dowolny", "");
        databaseFigureSkating.insertScore("112.00", "dowolny", "");
        databaseFigureSkating.insertScore("99.00", "dowolny", "");
        databaseFigureSkating.insertScore("128.00", "dowolny", "");
        databaseFigureSkating.insertScore("139.00", "dowolny", "");
        databaseFigureSkating.insertScore("164.00", "dowolny", "");
        databaseFigureSkating.insertScore("132.00", "krotki", "");
        databaseFigureSkating.insertScore("115.00", "krotki", "");
        databaseFigureSkating.insertScore("133.00", "krotki", "");
        databaseFigureSkating.insertScore("103.00", "krotki", "");
        databaseFigureSkating.insertScore("110.00", "krotki", "");
        databaseFigureSkating.insertScore("125.00", "krotki", "");
        databaseFigureSkating.insertScore("165.00", "krotki", "");

        databaseFigureSkating.insertTeam("inwidualne");
        databaseFigureSkating.insertTeam("inwidualne");
        databaseFigureSkating.insertTeam("inwidualne");
        databaseFigureSkating.insertTeam("pary");
        databaseFigureSkating.insertTeam("pary");


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
