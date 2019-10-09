package org.gmnz.hr;


import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;


public class FraudulentActivityNotificationTest {

    @Test
    public void testCase0() throws IOException {
        FraudulentActivityNotification fan = new FraudulentActivityNotification("fraud-testCase0.txt");
        Assert.assertEquals(1, fan.getResult());
    }



    @Test
    public void testCase1() throws IOException {
        FraudulentActivityNotification fan = new FraudulentActivityNotification("fraud-testCase1.txt");
        Assert.assertEquals(633, fan.getResult());
    }



    @Test
    public void testCase2() throws IOException {
        FraudulentActivityNotification fan = new FraudulentActivityNotification("fraud-testCase2.txt");
        Assert.assertEquals(770, fan.getResult());
    }



    @Test
    public void testCase3() throws IOException {
        FraudulentActivityNotification fan = new FraudulentActivityNotification("fraud-testCase3.txt");
        Assert.assertEquals(1026, fan.getResult());
    }



    @Test
    public void testCase4() throws IOException {
        FraudulentActivityNotification fan = new FraudulentActivityNotification("fraud-testCase4.txt");
        Assert.assertEquals(492, fan.getResult());
    }



    @Test
    public void testCase5() throws IOException {
        FraudulentActivityNotification fan = new FraudulentActivityNotification("fraud-testCase5.txt");
        Assert.assertEquals(926, fan.getResult());
    }
}