package com.cabtest;


import com.cabinvoice.CabInvoiceGenerator;
import com.cabinvoice.Invoice;
import com.cabinvoice.Ride;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator cabInvoiceGenerator=new CabInvoiceGenerator();
    private TestCase Assertions;

    @Test
    public void TotalFare(){
        double distance=2.0;
        int time=5;
        double result=cabInvoiceGenerator.calculatefare(distance,time);
        Assert.assertEquals(25.0,result,0);
    }
//Added this for testing
@Test
  public void givenMultipleRidesShould_ReturnAggregateFare() {
        CabInvoiceGenerator cabinvoice = new CabInvoiceGenerator();
        Ride[] rides ={new Ride(12.0,3.0),new Ride(14.0,5.0),new Ride(0.1,3.0)};
      //  Ride[] rides = {new Ride(12.0, 3.0), new Ride(14.0, 5.0), new Ride(0.1, 3.0)};
        double totalFare = cabinvoice.calculatefare(rides);
        Assertions.assertEquals(273.0,totalFare);
      //  Assertions.assertEquals(273, totalFare);
    }
    @Test
    public void givenMultipleRidesShould_ReturnInvoice_ForPremiumRides() {
        Ride[] rides = {new Ride(12.34, 6), new Ride(10, 4)};
        CabInvoiceGenerator cabInvoice = new CabInvoiceGenerator();
        Invoice actualInvoice = cabInvoice.getInvoiceOfPremiumRides(rides);
        Invoice expectedInvoice = new Invoice(2, 355.1, 177.55);
        Assertions.assertEquals(expectedInvoice, actualInvoice);
    }

    @Test
    public void givenMultipleRidesShould_ReturnInvoice_ForNormalAndPremiumRides() {
        Ride[] rides = {new Ride(12, 3, "Normal"), new Ride(13.4, 4, "Premium"), new Ride(17, 8, "Premium")};
        CabInvoiceGenerator cabInvoice = new CabInvoiceGenerator();
        Invoice actualInvoice = cabInvoice.getInvoiceOfRidesOfBothRides(rides);
        Invoice expectedInvoice = new Invoice(3, 603, 201);
        Assertions.assertEquals(expectedInvoice, actualInvoice);
    }
}
