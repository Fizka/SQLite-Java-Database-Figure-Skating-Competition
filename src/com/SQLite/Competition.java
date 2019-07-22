package com.SQLite;



public class Competition {

    int id_Competition; //NOT NULL
    date dateOfCompetition_change;
    String dateOfCompetition;//NOT NULL
    int id_Location; //NOT NULL
    String typeOfCompetition;
    //Co z enumem typeOfCompetition   "Mistrzostwa Europy","Grand Prix" ,"Mistrzostwa Swiata",Olimpiada; //NOT NULL

    public Competition(int id_Competition, String dateOfCompetition, String typeOfCompetition,  int id_Location) {
        this.id_Competition = id_Competition;
        this.dateOfCompetition = dateOfCompetition;
        this.id_Location = id_Location;
        this.typeOfCompetition = typeOfCompetition;
    }

    private class date{

        private int day, year, month;

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        @Override
        public String toString() {
            return day + "/" + month + "/" + year;
        }
    }


    public int getId_Competition() {
        return id_Competition;
    }

    public void setId_Competition(int id_Competition) {
        this.id_Competition = id_Competition;
    }

    public int getId_Location() {
        return id_Location;
    }

    public void setId_Location(int id_Location) {
        this.id_Location = id_Location;
    }

    public date getDateOfCompetition_change() {
        return dateOfCompetition_change;
    }

    public void setDateOfCompetition_change(date dateOfCompetition_change) {
        this.dateOfCompetition_change = dateOfCompetition_change;
    }

    public String getDateOfCompetition() {
        return dateOfCompetition;
    }

    public void setDateOfCompetition(String dateOfCompetition) {
        this.dateOfCompetition = dateOfCompetition;
    }

    public String getTypeOfCompetition() {
        return typeOfCompetition;
    }

    public void setTypeOfCompetition(String typeOfCompetition) {
        this.typeOfCompetition = typeOfCompetition;
    }


    @Override
    public String toString() {
        return "Competition{" +
                "id_Competition=" + id_Competition +
                ", dateOfCompetition=" + dateOfCompetition +
                ", typeOfCompetition=" + typeOfCompetition +
                ", id_Location=" + id_Location +
                '}';
    }
}
