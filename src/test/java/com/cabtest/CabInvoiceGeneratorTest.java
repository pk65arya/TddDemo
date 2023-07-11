package com.cabtest;

import com.cabinvoice.Invoice;
import com.cabinvoice.Ride;
import com.cabinvoice.RideRepository;
import junit.framework.TestCase;
import com.cabinvoice.CabInvoiceGenerator;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator cabInvoiceGenerator=new CabInvoiceGenerator();
    private TestCase Assertions=null;
    @Test
    public void TotalFare(){
        double distance=2.0;
        int time=5;
        double result=cabInvoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25.0,result,0);
    }
    //Added this for testing
    @Test
    public void givenMultipleRidesShould_ReturnAggregateFare() {
        CabInvoiceGenerator cabinvoice = new CabInvoiceGenerator();
        Ride[] rides ={new Ride(12.0,3.0),new Ride(14.0,5.0),new Ride(0.1,3.0)};
        //  Ride[] rides = {new Ride(12.0, 3.0), new Ride(14.0, 5.0), new Ride(0.1, 3.0)};
        double totalFare = cabinvoice.calculatetotalfare(rides);
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
    @Test
    public void givenMultipleRidesShould_ReturnInvoice() {
        Invoice invoice = new Invoice();
        Ride[] rides = {new Ride(12.0, 3.0), new Ride(14.0, 5.0), new Ride(0.1, 3.0)};
        Invoice actualInvoice = cabInvoiceGenerator.getInvoiceOfRides(rides);
        Invoice expectedInvoice = new Invoice(3, 273, 91);
        Assertions.assertEquals(expectedInvoice, actualInvoice);
    }

        @Test
    public void givenUserId_OfMultipleRidesShould_ReturnInvoice(){
        Ride[] rides1 = {new Ride(12.0, 3.0), new Ride(14.0, 5.0), new Ride(0.1, 3.0)};
        Ride[] rides2 = {new Ride(12.5, 4.8), new Ride(34.4, 9.7)};
        RideRepository repository = new RideRepository();
        repository.addRides("user101", rides1);
        repository.addRides("user102", rides2);
        Invoice actualInvoice1 = repository.getInvoiceFromUserId("user102");
        Invoice actualInvoice2 = repository.getInvoiceFromUserId("user101");
        Invoice expectedInvoice1 = new Invoice(2, 483.5, 241.75);
        Invoice expectedInvoice2 = new Invoice(3, 273, 91);
        Assertions.assertEquals(expectedInvoice1, actualInvoice1);
        Assertions.assertEquals(expectedInvoice2, actualInvoice2);

    }
}
