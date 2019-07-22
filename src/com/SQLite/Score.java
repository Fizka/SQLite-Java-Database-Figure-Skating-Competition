package com.SQLite;

public class Score {

    int id_Score; //NOT NULL
    double score; //(10,2) NOT NULL
    int id_Team; //NOT NULL
    String typeOfProgramme;   //`typeOfProgramme` enum('krotki','dowolny') COLLATE utf8_unicode_ci NOT NULL,

    public Score(int id_Score, double score, String typeOfProgramme, int id_Team) {
        this.id_Score = id_Score;
        this.score = score;
        this.typeOfProgramme = typeOfProgramme;
        this.id_Team = id_Team;
    }

    public int getId_Score() {

        return id_Score;
    }

    public void setId_Score(int id_Score) {
        this.id_Score = id_Score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getId_Team() {
        return id_Team;
    }

    public void setId_Team(int id_Team) {
        this.id_Team = id_Team;
    }

    public String getTypeOfProgramme() {
        return typeOfProgramme;
    }

    public void setTypeOfProgramme(String typeOfProgramme) {
        this.typeOfProgramme = typeOfProgramme;
    }


    @Override
    public String toString() {
        return "Score{" +
                "id_Score=" + id_Score +
                ", score=" + score +
                ", typeOfProgramme=" + typeOfProgramme +
                ", id_Team=" + id_Team +
                '}';
    }
}
