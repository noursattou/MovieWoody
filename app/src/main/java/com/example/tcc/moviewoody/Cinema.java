package com.example.tcc.moviewoody;

/**
 * Created by TCC on 3/11/2018.
 */

public class Cinema {
  String cityName;
 String cinemaName;
 String location;
 MovieInformation [] movies;

    public Cinema() {
    }

    public Cinema(String city , String name , String location){
     this.cityName=city;
     this.cinemaName=name;
     this.location=location;

 }

    public  String getCityName() {
        return cityName;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public String getLocation() {
        return location;
    }

    public MovieInformation[] getMovies() {
        return movies;
    }
    public String toString(){
     return cityName;

    }
}
