package com.SQLite;

public class Contestant {

    int id_Contestant; // NOT NULL
    String last_Name; // NOT NULL varchar(50)
    String name; // NOT NULL varchar(25)

    public Contestant(int id_Contestant, String last_Name, String name) {
        this.id_Contestant = id_Contestant;
        this.last_Name = last_Name;
        this.name = name;
    }

    public int getId_Contestant() {

        return id_Contestant;
    }

    public void setId_Contestant(int id_Contestant) {
        this.id_Contestant = id_Contestant;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Contestant{" +
                "id_Contestant=" + id_Contestant +
                ", last_Name='" + last_Name + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
