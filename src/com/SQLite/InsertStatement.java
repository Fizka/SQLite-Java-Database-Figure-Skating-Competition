package com.SQLite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStatement extends CreateStatement implements DataBaseCommunication{

    public boolean insertCompetition (String dateOfCompetition, String typeOfCompetition, String id_Location) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Competition values (NULL, ?, ?, ?);");
            prepStmt.setString(1, dateOfCompetition);
            prepStmt.setString(2, typeOfCompetition);
            prepStmt.setString(3, id_Location);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Error - Values not insert into table Competition");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertTypesOfCompetition (String dateOfCompetition, String typeOfCompetition, String id_Location) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Competition values (NULL, ?, ?, ?);");
            prepStmt.setString(1, dateOfCompetition);
            prepStmt.setString(2, typeOfCompetition);
            prepStmt.setString(3, id_Location);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Error - Values not insert into table Competition");
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
            System.err.println("Error - Values not insert into table TypesOfCompetition");
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
            System.err.println("Error - Values not insert into table Competition_Referee");
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
            System.err.println("Error - Values not insert into table Competition_Team");
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
            System.err.println("Error - Values not insert into table Contestant");
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
            System.err.println("Error - Values not insert into table Contestant_Team");
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
            System.err.println("Error - Values not insert into table Location");
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
            System.err.println("Error - Values not insert into table Skating_Rink");
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
            System.err.println("Error - Values not insert into table Mark");
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
            System.err.println("Error - Values not insert into table Referee");
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
            System.err.println("Error - Values not insert into table Score");
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
            System.err.println("Error - Values not insert into table Team");
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
