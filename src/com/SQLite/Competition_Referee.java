package com.SQLite;

public class Competition_Referee {

    int id_Competition;
    int id_Referee;

    public Competition_Referee(int id_Competition, int id_Referee) {
        this.id_Competition = id_Competition;
        this.id_Referee = id_Referee;
    }

    public int getId_Competition() {

        return id_Competition;
    }

    public void setId_Competition(int id_Competition) {
        this.id_Competition = id_Competition;
    }

    public int getId_Referee() {
        return id_Referee;
    }

    public void setId_Referee(int id_Referee) {
        this.id_Referee = id_Referee;
    }


}
