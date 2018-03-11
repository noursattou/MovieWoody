package com.example.tcc.moviewoody;

public class CinemaInformation {
    public String name;
    public  String city;
    public  String location;
    public String id;
    public CinemaInformation(){

    }

    public CinemaInformation(String name, String city, String location, String id) {
        this.name = name;
        this.city = city;
        this.location = location;
        this.id = id;


    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }
}