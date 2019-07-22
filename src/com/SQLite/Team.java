package com.SQLite;

public class Team {

    int id_Team; // NOT NULL
    String category; // NOT NULL varchar(25)

    public Team(int id_Team, String category) {
        this.id_Team = id_Team;
        this.category = category;
    }

    public int getId_Team() {
        return id_Team;
    }

    public void setId_Team(int id_Team) {
        this.id_Team = id_Team;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id_Team=" + id_Team +
                ", category='" + category + '\'' +
                '}';
    }
}
