package com.SQLite;

public class Location {

    int id_Location; //NOT NULL
    String city; //NOT NULL varchar(25)

    public Location(int id_Location, String city) {
        this.id_Location = id_Location;
        this.city = city;
    }

    public int getId_Location() {

        return id_Location;
    }

    public void setId_Location(int id_Location) {
        this.id_Location = id_Location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id_Location=" + id_Location +
                ", city='" + city + '\'' +
                '}';
    }
}
