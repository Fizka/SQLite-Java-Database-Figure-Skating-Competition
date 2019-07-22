package com.SQLite;

public class Mark {

    int id_Mark; //NOT NULL
    double score_PC; //NOT NULL (10,2)
    double score_TE; //NOT NULL (10,2)
    int id_Score; //NOT NULL
    int id_Referee; //NOT NULL

    public Mark(int id_Mark, double score_PC, double score_TE, int id_Score, int id_Referee) {
        this.id_Mark = id_Mark;
        this.score_PC = score_PC;
        this.score_TE = score_TE;
        this.id_Score = id_Score;
        this.id_Referee = id_Referee;
    }

    public int getId_Mark() {

        return id_Mark;
    }

    public void setId_Mark(int id_Mark) {
        this.id_Mark = id_Mark;
    }

    public double getScore_PC() {
        return score_PC;
    }

    public void setScore_PC(double score_PC) {
        this.score_PC = score_PC;
    }

    public double getScore_TE() {
        return score_TE;
    }

    public void setScore_TE(double score_TE) {
        this.score_TE = score_TE;
    }

    public int getId_Score() {
        return id_Score;
    }

    public void setId_Score(int id_Score) {
        this.id_Score = id_Score;
    }

    public int getId_Referee() {
        return id_Referee;
    }

    public void setId_Referee(int id_Referee) {
        this.id_Referee = id_Referee;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id_Mark=" + id_Mark +
                ", score_PC=" + score_PC +
                ", score_TE=" + score_TE +
                ", id_Score=" + id_Score +
                ", id_Referee=" + id_Referee +
                '}';
    }
}
