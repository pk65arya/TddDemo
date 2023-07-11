package com.cabinvoice;

public class CabInvoiceGenerator {
 public static final    double costperkm=10.0;
 public static final double costpermin=1.0;
 public static final double min_fare=5;

 public static double calculatefare(double distance,double time){
     double totalValue=(distance*costperkm)+(time*costpermin);
     if (totalValue<5){
      return min_fare;
     }
     return totalValue;
 }
 public static final double FARE_FOR_PREMIUM_RIDES=15;
 public static final double PREMIUM_FARE_PER_MINUTE=2;
 public static final double PREMIUM_MINIMUM_FARE=20;
    public double getTotalFareForPremiumRides(double distance, double time) {
        double totalFare = CabInvoiceGenerator.FARE_FOR_PREMIUM_RIDES * distance + CabInvoiceGenerator.PREMIUM_FARE_PER_MINUTE* time;
        if (totalFare < CabInvoiceGenerator.PREMIUM_MINIMUM_FARE) {
            return CabInvoiceGenerator.PREMIUM_MINIMUM_FARE;
        } else
            return totalFare;
    }
    public double calculatefare(Ride[] rides) {
        double aggregateFare = 0;
        for (Ride ride : rides) {
            double totalFare = calculatefare(ride.distance, ride.time);
            aggregateFare += totalFare;
        }
        return aggregateFare;
    }

    public double getTotalFareForPremiumRides(Ride[] rides){
        double aggregateFare=0;
        for(Ride ride : rides){
            double totalFare=getTotalFareForPremiumRides(ride.distance,ride.time);
            aggregateFare += totalFare;
        }
        return aggregateFare;
    }
    public Invoice getInvoiceOfRides(Ride[] rides) {
        int numberOfRides = rides.length;
        double totalFare = calculatefare(rides);

        double averageRideFare = totalFare / numberOfRides;
        return new Invoice(numberOfRides, totalFare, averageRideFare);
    }
    public Invoice getInvoiceOfPremiumRides(Ride[] rides) {
        int numberOfRides = rides.length;
        double totalFare = getTotalFareForPremiumRides(rides);
        double averageRideFare = totalFare / numberOfRides;
        return new Invoice(numberOfRides, totalFare, averageRideFare);
    }



}


