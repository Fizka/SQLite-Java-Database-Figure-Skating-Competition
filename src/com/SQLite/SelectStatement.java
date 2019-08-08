package com.SQLite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class SelectStatement extends InsertStatement implements DataBaseCommunication {


    public List<Competition> selectCompetition() {
        List<Competition> list_Competition = new LinkedList<Competition>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Competition");
            int id_Competition, id_Location;
            String  dateOfCompetition, typeOfCompetition;
            while(result.next()) {
                id_Competition = result.getInt("id_Competition");
                dateOfCompetition = result.getString("dateOfCompetition");
                typeOfCompetition = result.getString("typeOfCompetition");
                id_Location = result.getInt("id_Location");
                list_Competition.add(new Competition(id_Competition, dateOfCompetition, typeOfCompetition, id_Location));
            }
        } catch (SQLException e) {
            System.out.println("Error - Select Statement did not work");
            e.printStackTrace();
            return null;
        }
        return list_Competition;
    }


    public List<TypesOfCompetition> selectTypesOfCompetition() {
        List<TypesOfCompetition> list_TypesOfCompetition = new LinkedList<TypesOfCompetition>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM TypesOfCompetition");
            String typeOfCompetition, nameOfCompetition;
            while(result.next()) {
                typeOfCompetition = result.getString("typeOfCompetition");
                nameOfCompetition = result.getString("nameOfCompetition");
                list_TypesOfCompetition.add(new TypesOfCompetition(typeOfCompetition, nameOfCompetition));
            }
        } catch (SQLException e) {
            System.out.println("Error - Select Statement did not work");
            e.printStackTrace();
            return null;
        }
        return list_TypesOfCompetition;
    }


    public List<Competition_Referee> selectCompetition_Referee() {
        List<Competition_Referee> competition_Referee = new LinkedList<Competition_Referee>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Competition_Referee");
            int id_Competition,id_Referee;
            while(result.next()) {
                id_Competition = result.getInt("id_Competition");
                id_Referee = result.getInt("id_Referee");
                competition_Referee.add(new Competition_Referee(id_Competition, id_Referee));
            }
        } catch (SQLException e) {
            System.out.println("Error - Select Statement did not work");
            e.printStackTrace();
            return null;
        }
        return competition_Referee;
    }


    public List<Competition_Team> selectCompetition_Team() {
        List<Competition_Team> list_Competition_Team = new LinkedList<Competition_Team>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Competition_Team");
            int id_Team,id_Competition;
            while(result.next()) {
                id_Team = result.getInt("id_Team");
                id_Competition = result.getInt("id_Competition");
                list_Competition_Team.add(new Competition_Team(id_Team, id_Competition));
            }
        } catch (SQLException e) {
            System.out.println("Error - Select Statement did not work");
            e.printStackTrace();
            return null;
        }
        return list_Competition_Team;
    }


    public List<Contestant> selectContestant() {
        List<Contestant> list_Contestant = new LinkedList<Contestant>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Contestant");
            int id_Contestant;
            String last_Name, name;
            while(result.next()) {
                id_Contestant = result.getInt("id_Contestant");
                last_Name = result.getString("last_Name");
                name = result.getString("name");
                list_Contestant.add(new Contestant(id_Contestant, last_Name, name));
            }
        } catch (SQLException e) {
            System.out.println("Error - Select Statement did not work");
            e.printStackTrace();
            return null;
        }
        return list_Contestant;
    }


    public List<Contestant_Team> selectContestant_Team() {
        List<Contestant_Team> list_Contestant_Team = new LinkedList<Contestant_Team>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Contestant_Team");
            int id_Contestant,id_Team;
            while(result.next()) {
                id_Contestant = result.getInt("id_Contestant");
                id_Team = result.getInt("id_Team");
                list_Contestant_Team.add(new Contestant_Team(id_Contestant, id_Team));
            }
        } catch (SQLException e) {
            System.out.println("Error - Select Statement did not work");
            e.printStackTrace();
            return null;
        }
        return list_Contestant_Team;
    }


    public List<Location> selectLocation() {
        List<Location> list_Location = new LinkedList<Location>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Location");
            int id_Location;
            String city;
            while(result.next()) {
                id_Location = result.getInt("id_Location");
                city = result.getString("city");
                list_Location.add(new Location(id_Location, city));
            }
        } catch (SQLException e) {
            System.out.println("Error - Select Statement did not work");
            e.printStackTrace();
            return null;
        }
        return list_Location;
    }


    public List<Skating_Rink> selectSkating_Rink() {
        List<Skating_Rink> list_Skating_Rink = new LinkedList<Skating_Rink>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Skating_Rink");
            String city, country, name;
            while(result.next()) {
                city = result.getString("city");
                country = result.getString("country");
                name = result.getString("name");
                list_Skating_Rink.add(new Skating_Rink(city, country, name));
            }
        } catch (SQLException e) {
            System.out.println("Error - Select Statement did not work");
            e.printStackTrace();
            return null;
        }
        return list_Skating_Rink;
    }


    public List<Mark> selectMark() {
        List<Mark> list_Mark = new LinkedList<Mark>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Mark");
            int id_Mark, id_Score, id_Referee;
            double score_PC, score_TE;
            while(result.next()) {
                id_Mark = result.getInt("id_Mark");
                score_PC = result.getDouble("score_PC");
                score_TE = result.getDouble("score_TE");
                id_Score = result.getInt("id_Score");
                id_Referee = result.getInt("id_Referee");
                list_Mark.add(new Mark(id_Mark, score_PC, score_TE, id_Score, id_Referee));
            }
        } catch (SQLException e) {
            System.out.println("Error - Select Statement did not work");
            e.printStackTrace();
            return null;
        }
        return list_Mark;
    }


    public List<Referee> selectReferee() {
        List<Referee> list_Referee = new LinkedList<Referee>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Referee");
            int id_Referee;
            String name, last_Name;
            while(result.next()) {
                id_Referee = result.getInt("id_Referee");
                name = result.getString("name");
                last_Name = result.getString("last_Name");
                list_Referee.add(new Referee(id_Referee, name, last_Name));
            }
        } catch (SQLException e) {
            System.out.println("Error - Select Statement did not work");
            e.printStackTrace();
            return null;
        }
        return list_Referee;
    }


    public List<Score> selectScore() {
        List<Score> list_Score = new LinkedList<Score>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Score");
            int id_Score, id_Team;
            double score;
            String typeOfProgramme;
            while(result.next()) {
                id_Score = result.getInt("id_Score");
                score = result.getDouble("score");
                typeOfProgramme = result.getString("typeOfProgramme");
                id_Team = result.getInt("id_Team");
                list_Score.add(new Score(id_Score, score, typeOfProgramme, id_Team));
            }
        } catch (SQLException e) {
            System.out.println("Error - Select Statement did not work");
            e.printStackTrace();
            return null;
        }
        return list_Score;
    }


    public List<Team> selectTeam() {
        List<Team> list_Team = new LinkedList<Team>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Team");
            int id_Team;
            String category;
            while(result.next()) {
                id_Team = result.getInt("id_Team");
                category = result.getString("category");
                list_Team.add(new Team(id_Team, category));
            }
        } catch (SQLException e) {
            System.out.println("Error - Select Statement did not work");
            e.printStackTrace();
            return null;
        }
        return list_Team;
    }


}
