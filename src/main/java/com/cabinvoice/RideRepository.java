package com.cabinvoice;

import java.util.HashMap;

public class RideRepository {
    HashMap<String, Ride[]> rideHashMap = new HashMap<>();

    public void addRides(String userId, Ride[] rides) {
        if (rideHashMap.containsKey(userId)) {
            System.out.println("This userId already exists.");
        } else {
            rideHashMap.put(userId, rides);
        }
    }

    public Ride[] getRideFromUserId(String userId) {
        Ride[] rides = rideHashMap.get(userId);
        return rides;
    }
    public Invoice getInvoiceFromUserId(String userId) {
        Ride[] rides = rideHashMap.get(userId);
        CabInvoiceGenerator invoice = new CabInvoiceGenerator();
        return invoice.getInvoiceOfRides(rides);
    }
}
