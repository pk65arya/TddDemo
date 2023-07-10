package com.cabtest;


import com.cabinvoice.CabInvoiceGenerator;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator cabInvoiceGenerator=new CabInvoiceGenerator();
    @Test
    public void TotalFare(){
        double distance=2.0;
        int time=0;
        double result=cabInvoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25.0,result,5);
    }

}
