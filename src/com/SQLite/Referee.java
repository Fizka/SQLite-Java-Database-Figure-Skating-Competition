package com.SQLite;

public class Referee {

    int id_Referee; //NOT NULL
    String name; //NOT NULL
    String last_Name; // NOT NULL varchar30

    public Referee(int id_Referee, String name, String last_Name) {
        this.id_Referee = id_Referee;
        this.name = name;
        this.last_Name = last_Name;
    }

    public int getId_Referee() {

        return id_Referee;
    }

    public void setId_Referee(int id_Referee) {
        this.id_Referee = id_Referee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_Name() {

        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    @Override
    public String toString() {
        return "Referee{" +
                "id_Referee=" + id_Referee +
                ", name=" + name +
                ", last_Name='" + last_Name + '\'' +
                '}';
    }
}
