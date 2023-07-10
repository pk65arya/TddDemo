package com.cabtest;

import com.cabinvoice.CabInvoiceGenerator;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator cab=new CabInvoiceGenerator();
    @Test
    public void TotalFare(){
        double distance=2.0;
         int time=5;
double result =CabInvoiceGenerator.calculatefare(distance,time);
        Assert.assertEquals(25,result);

    }
}
