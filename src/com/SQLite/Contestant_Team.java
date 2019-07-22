package com.SQLite;

public class Contestant_Team {

    int id_Contestant; //  NOT NULL
    int id_Team; //  NOT NULL

    public Contestant_Team(int id_Contestant, int id_Team) {
        this.id_Contestant = id_Contestant;
        this.id_Team = id_Team;
    }

    public int getId_Contestant() {

        return id_Contestant;
    }

    public void setId_Contestant(int id_Contestant) {
        this.id_Contestant = id_Contestant;
    }

    public int getId_Team() {
        return id_Team;
    }

    public void setId_Team(int id_Team) {
        this.id_Team = id_Team;
    }

    @Override
    public String toString() {
        return "Contestant_Team{" +
                "id_Contestant=" + id_Contestant +
                ", id_Team=" + id_Team +
                '}';
    }
}
