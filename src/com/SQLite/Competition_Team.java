package com.SQLite;

public class Competition_Team {

    int id_Team;//NOT NULL
    int id_Competition; //NOT NULL

    public Competition_Team(int id_Team, int id_Competition) {
        this.id_Team = id_Team;
        this.id_Competition = id_Competition;
    }

    public int getId_Team() {

        return id_Team;
    }

    public void setId_Team(int id_Team) {
        this.id_Team = id_Team;
    }

    public int getId_Competition() {
        return id_Competition;
    }

    public void setId_Competition(int id_Competition) {
        this.id_Competition = id_Competition;
    }

    @Override
    public String toString() {
        return "Competition_Team{" +
                "id_Team=" + id_Team +
                ", id_Competition=" + id_Competition +
                '}';
    }
}
