package com.SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

//główna klasa do komunikacji z bazą danych
public class Main {

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:biblioteka.db";

    private Connection conn;
    private Statement stat;

    public Main() {

        try {
            Class.forName(Main.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }

        createTables();

    }

    public static void main(String[] args) {

    }


    public boolean createTables()  {

        String createCompetition =
                "CREATE TABLE IF NOT EXISTS `Competition` ( " +
                "id_Competition INTEGER  AUTOINCREMENT NOT NULL," +
                "`dateOfCompetition` date NOT NULL," +
                "`typeOfCompetition` text  NOT NULL, `id_Location` INTEGER NOT NULL," +
                " FOREIGN KEY(`id_Location`) REFERENCES `Location` (`id_Location`)" +
                "ON DELETE CASCADE ON UPDATE NO ACTION," +
                "FOREIGN KEY(`typeOfCompetition`) REFERENCES `TypesOfCompetition` (`typeOfCompetition`)" +
                "ON DELETE CASCADE ON UPDATE NO ACTION" +
                " )";


        String createTypesOfCompetition =
                "CREATE TABLE IF NOT EXISTS `TypesOfCompetition` (" +
                "`typeOfCompetition` PRIMARY KEY text NOT NULL," +
                "`nameOfCompetition` varchar(255)  NOT NULL" +
                ")";

        String createCompetition_Referee =
                "CREATE TABLE IF NOT EXISTS `Competition_Referee` (" +
                "`id_Competition` INTEGER NOT NULL," +
                "`id_Referee` INTEGER NOT NULL," +
                "PRIMARY KEY(`id_Competition`,`id_Referee`)," +
                "FOREIGN KEY(`id_Competition`) REFERENCES `Competition` (`id_Competition`)" +
                "ON DELETE CASCADE ON UPDATE NO ACTION," +
                "FOREIGN KEY(`id_Referee`) REFERENCES `Referee` (`id_Referee`)" +
                "ON DELETE CASCADE ON UPDATE NO ACTION" +
                ")";

        String createCompetition_Team =
                "CREATE TABLE IF NOT EXISTS `Competition_Team` (" +
                "`id_Team` INTEGER NOT NULL," +
                "`id_Competition` INTEGER NOT NULL," +
                "PRIMARY KEY(`id_Competition`,`id_Team`)," +
                "FOREIGN KEY(`id_Team`) REFERENCES `Team` (`id_Team`)" +
                "ON DELETE CASCADE ON UPDATE NO ACTION," +
                "FOREIGN KEY(`id_Competition`) REFERENCES `Competition` (`id_Competition`)" +
                "ON DELETE CASCADE ON UPDATE NO ACTION" +
                ")";

        String createContestant =
                "CREATE TABLE IF NOT EXISTS `Contestant` (" +
                "`id_Contestant` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "`last_Name` varchar(255)  NOT NULL," +
                "`name` varchar(255)  NOT NULL" +
                ")";

        String createContestant_Team =
                "CREATE TABLE IF NOT EXISTS `Contestant_Team` (" +
                " `id_Contestant` INTEGER  NOT NULL," +
                "`id_Team` INTEGER  NOT NULL," +
                "PRIMARY KEY(`id_Contestant`,`id_Team`)," +
                "FOREIGN KEY(`id_Contestant`) REFERENCES `Contestant` (`id_Contestant`)" +
                "ON DELETE CASCADE ON UPDATE NO ACTION," +
                "FOREIGN KEY(`id_Team`) REFERENCES `Team` (`id_Team`)" +
                "ON DELETE CASCADE ON UPDATE NO ACTION" +
                ")";

        String createLocation =
                "CREATE TABLE IF NOT EXISTS `Location` (" +
                "`id_Location` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "`city` varchar(255)  NOT NULL," +
                "FOREIGN KEY(`city`) REFERENCES `Skating_Rink` (`city`)" +
                "ON DELETE CASCADE ON UPDATE NO ACTION" +
                ")";

        String createSkating_Rink =
                "CREATE TABLE IF NOT EXISTS `Skating_Rink` (" +
                "`city`  varchar(255) PRIMARY KEY  NOT NULL," +
                "`country` varchar(255)  NOT NULL," +
                "`name` varchar(255)  NOT NULL" +
                ")";

        String createMark =
                "CREATE TABLE IF NOT EXISTS `Mark` (" +
                "`id_Mark` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "`score_PC` double(10,2) NOT NULL," +
                "`score_TE` double(10,2) NOT NULL," +
                "`id_Score` INTEGER NOT NULL," +
                "`id_Referee` INTEGER NOT NULL," +
                "FOREIGN KEY(`id_Score`) REFERENCES `Score` (`id_Score`)" +
                "ON DELETE CASCADE ON UPDATE NO ACTION," +
                "FOREIGN KEY(`id_Referee`) REFERENCES `Referee` (`id_Referee`)" +
                "ON DELETE CASCADE ON UPDATE NO ACTION" +
                ")";

        String createReferee =
                "CREATE TABLE IF NOT EXISTS `Referee` (" +
                "`id_Referee` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "`name` INTEGER NOT NULL," +
                "`last_Name` varchar(255)  NOT NULL" +
                ")";

        String createScore =
                "CREATE TABLE IF NOT EXISTS `Score` (" +
                "`id_Score`  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "`score` double(10,2) NOT NULL," +
                "`typeOfProgramme` text  NOT NULL," +
                "`id_Team` INTEGER NOT NULL," +
                "FOREIGN KEY(id_Team) REFERENCES `Team` (`id_Team`)" +
                "ON DELETE CASCADE ON UPDATE NO ACTION" +
                ")";

        String createTeam =
                "CREATE TABLE IF NOT EXISTS Team (" +
                "id_Team INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "category varchar(255) NOT NULL" +
                ")";

        try {
            stat.execute(createCompetition);
            stat.execute(createTypesOfCompetition);
            stat.execute(createCompetition_Referee);
            stat.execute(createCompetition_Team);
            stat.execute(createContestant);
            stat.execute(createContestant_Team);
            stat.execute(createLocation);
            stat.execute(createSkating_Rink);
            stat.execute(createMark);
            stat.execute(createReferee);
            stat.execute(createScore);
            stat.execute(createTeam);
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean insertCompetition (String dateOfCompetition, String typeOfCompetition, String id_Location) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Competition values (NULL, ?, ?, ?);");
            prepStmt.setString(1, dateOfCompetition);
            prepStmt.setString(2, typeOfCompetition);
            prepStmt.setString(3, id_Location);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu Competition");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean insertTypesOfCompetition(String typeOfCompetition, String nameOfCompetition) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into TypesOfCompetition values (?, ?);");
            prepStmt.setString(1, typeOfCompetition);
            prepStmt.setString(1, nameOfCompetition);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu TypesOfCompetition");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean insertCompetition_Referee(String id_Competition, String id_Referee) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Competition_Referee values ( ?, ?);");
            prepStmt.setString(1, id_Competition);
            prepStmt.setString(2, id_Referee);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu Competition_Referee");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean insertCompetition_Team(String id_Team, String id_Competition) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Competition_Team values ( ?, ?);");
            prepStmt.setString(1, id_Team);
            prepStmt.setString(2, id_Competition);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu Competition_Team");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean insertContestant(String last_Name, String name) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Contestant values (NULL, ?, ?);");
            prepStmt.setString(1, last_Name);
            prepStmt.setString(2, name);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu Contestant");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean insertContestant_Team(String id_Contestant, String id_Team) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Contestant_Team values ( ?, ?);");
            prepStmt.setString(1, id_Contestant);
            prepStmt.setString(2, id_Team);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu Contestant_Team");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean insertLocation(String city) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Location values (NULL, ?);");
            prepStmt.setString(1, city);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu Location");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean insertSkating_Rink(String city, String country, String name) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Skating_Rink values ( ?, ?, ?);");
            prepStmt.setString(1, city);
            prepStmt.setString(2, country);
            prepStmt.setString(3, name);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu Skating_Rink");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertMark(String score_PC, String score_TE, String id_Score, String id_Referee ) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Mark values (NULL, ?, ?, ?, ?);");
            prepStmt.setString(1, score_PC);
            prepStmt.setString(2, score_TE);
            prepStmt.setString(3, id_Score);
            prepStmt.setString(4, id_Referee);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu Mark");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean insertReferee(String name, String last_Name) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Referee values (NULL, ?, ?);");
            prepStmt.setString(1, name);
            prepStmt.setString(2, last_Name);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu Referee");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean insertScore(String score, String typeOfProgramme, String id_Team) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Score values (NULL, ?, ?, ?);");
            prepStmt.setString(1, score);
            prepStmt.setString(2, typeOfProgramme);
            prepStmt.setString(3, id_Team);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu Score");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean insertTeam(String category) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Team values (NULL, ?);");
            prepStmt.setString(1, category);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu Team");
            e.printStackTrace();
            return false;
        }
        return true;
    }


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
            e.printStackTrace();
            return null;
        }
        return list_Team;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
}
