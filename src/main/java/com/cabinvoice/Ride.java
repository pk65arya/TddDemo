package com.cabinvoice;

public class Ride {
    double distance;
    double time;
    String ridetype;

    public Ride(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }

    public Ride(double distance, double time, String ridetype) {
        this.distance = distance;
        this.time = time;
        this.ridetype = ridetype;
    }
}
