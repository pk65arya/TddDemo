package com.cabinvoice;

public class CabInvoiceGenerator {
 public static final    double costperkm=10.0;
 public static final double costpermin=1.0;
 public static final double min_fare=5;

 public static double calculatefare(double distance,int time){
     double totalValue=(distance*costperkm)+(time*costpermin);
     if (totalValue<5){
      return min_fare;
     }
     return totalValue;
 }
 //Added comments
}
