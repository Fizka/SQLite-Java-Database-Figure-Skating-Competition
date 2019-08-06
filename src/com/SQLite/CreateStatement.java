package com.SQLite;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStatement extends InsertStatement implements DataBaseCommunication{

    private Connection conn;
    private Statement stat;

    public CreateStatement() {

        try {
            Class.forName(DataBaseCommunication.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Error - no JDBC driver");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Error - no connection to the database");
            e.printStackTrace();
        }

        createTables();

    }

    public boolean createTables()  {

        String createCompetition =
                "CREATE TABLE IF NOT EXISTS `Competition` ( " +
                        "id_Competition INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "`dateOfCompetition` varchar(255) NOT NULL," +
                        "`typeOfCompetition` varchar(255)  NOT NULL," +
                        " `id_Location` INT NOT NULL," +
                        " FOREIGN KEY(`id_Location`) REFERENCES `Location` (`id_Location`)" +
                        "ON DELETE CASCADE ON UPDATE NO ACTION," +
                        "FOREIGN KEY(`typeOfCompetition`) REFERENCES `TypesOfCompetition` (`typeOfCompetition`)" +
                        "ON DELETE CASCADE ON UPDATE NO ACTION" +
                        " )";


        String createTypesOfCompetition =
                "CREATE TABLE IF NOT EXISTS `TypesOfCompetition` (" +
                        "`typeOfCompetition` varchar(255) PRIMARY KEY  NOT NULL," +
                        "`nameOfCompetition` varchar(255)  NOT NULL" +
                        ")";

        String createCompetition_Referee =
                "CREATE TABLE IF NOT EXISTS `Competition_Referee` (" +
                        "`id_Competition` INT NOT NULL," +
                        "`id_Referee` INT NOT NULL," +
                        "PRIMARY KEY(`id_Competition`,`id_Referee`)," +
                        "FOREIGN KEY(`id_Competition`) REFERENCES `Competition` (`id_Competition`)" +
                        "ON DELETE CASCADE ON UPDATE NO ACTION," +
                        "FOREIGN KEY(`id_Referee`) REFERENCES `Referee` (`id_Referee`)" +
                        "ON DELETE CASCADE ON UPDATE NO ACTION" +
                        ")";

        String createCompetition_Team =
                "CREATE TABLE IF NOT EXISTS `Competition_Team` (" +
                        "`id_Team` INT NOT NULL," +
                        "`id_Competition` INT NOT NULL," +
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
                        " `id_Contestant` INT  NOT NULL," +
                        "`id_Team` INT  NOT NULL," +
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
                        "`score_PC` INT NOT NULL," +
                        "`score_TE` INT NOT NULL," +
                        "`id_Score` INT NOT NULL," +
                        "`id_Referee` INT NOT NULL," +
                        "FOREIGN KEY(`id_Score`) REFERENCES `Score` (`id_Score`)" +
                        "ON DELETE CASCADE ON UPDATE NO ACTION," +
                        "FOREIGN KEY(`id_Referee`) REFERENCES `Referee` (`id_Referee`)" +
                        "ON DELETE CASCADE ON UPDATE NO ACTION" +
                        ")";

        String createReferee =
                "CREATE TABLE IF NOT EXISTS `Referee` (" +
                        "`id_Referee` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "`name` varchar(255) NOT NULL," +
                        "`last_Name` varchar(255)  NOT NULL" +
                        ")";

        String createScore =
                "CREATE TABLE IF NOT EXISTS `Score` (" +
                        "`id_Score`  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "`score` int NOT NULL," +
                        "`typeOfProgramme` varchar(255)  NOT NULL," +
                        "`id_Team` INT NOT NULL," +
                        "FOREIGN KEY(id_Team) REFERENCES `Team` (`id_Team`)" +
                        "ON DELETE CASCADE ON UPDATE NO ACTION" +
                        ")";

        String createTeam =
                "CREATE TABLE IF NOT EXISTS Team (" +
                        "id_Team INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "category varchar(255) NOT NULL" +
                        ")";
        int num = 0;
        try {

            stat.execute(createCompetition);
            num++;
            stat.execute(createTypesOfCompetition);
            num++;
            stat.execute(createCompetition_Referee);
            num++;
            stat.execute(createCompetition_Team);
            num++;
            stat.execute(createContestant);
            num++;
            stat.execute(createContestant_Team);   num++;
            stat.execute(createLocation);  num++;
            stat.execute(createSkating_Rink);  num++;
            stat.execute(createMark);  num++;
            stat.execute(createReferee);  num++;
            stat.execute(createScore);  num++;
            stat.execute(createTeam);  num++;
        } catch (SQLException e) {
            System.err.println("Error - table not created " + num);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error - connection to the database is still open");
            e.printStackTrace();
        }
    }

}
