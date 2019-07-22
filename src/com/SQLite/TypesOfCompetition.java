package com.SQLite;

public class TypesOfCompetition {

    String nameOfCompetition, typeOfCompetition; //varchar(50) NOT NULL
// `typeOfCompetition` enum('Mistrzostwa Europy','Grand Prix','Mistrzostwa Swiata','Olimpiada') COLLATE utf8_unicode_ci NOT NULL,

    public TypesOfCompetition(String typeOfCompetition, String nameOfCompetition ) {
        this.nameOfCompetition = nameOfCompetition;
        this.typeOfCompetition = typeOfCompetition;

    }

    public String getNameOfCompetition() {
        return nameOfCompetition;
    }

    public void setNameOfCompetition(String nameOfCompetition) {
        this.nameOfCompetition = nameOfCompetition;
    }

    public String getTypeOfCompetition() {
        return typeOfCompetition;
    }

    public void setTypeOfCompetition(String typeOfCompetition) {
        this.typeOfCompetition = typeOfCompetition;
    }

    @Override
    public String toString() {
        return "TypesOfCompetition{" +
                "typeOfCompetition='" + typeOfCompetition + '\'' +
                "nameOfCompetition='" + nameOfCompetition + '\'' +
                '}';
    }
}
