package com.example.tcc.moviewoody;

/**
 * Created by nour sattouf on 3/2/2018.
 */

public class MovieInformation {
    public String name;
    public  String genre;
    public  String duration;
    public String id;
    public MovieInformation(){

    }

    public MovieInformation(String name, String genre, String duration, String id) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public String getId() {
        return id;
    }
}
