package com.SQLite;

public class Skating_Rink {

    String city; // not null varchar(50)
    String country; // not null varchar(50)
    String name;  // not null varchar(50)

    public Skating_Rink(String city, String country, String name) {
        this.city = city;
        this.country = country;
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skating_Rink{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
