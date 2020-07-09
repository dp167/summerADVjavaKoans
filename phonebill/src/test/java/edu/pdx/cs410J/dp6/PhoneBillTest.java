package edu.pdx.cs410J.dp6;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * class for testing phonebill class
 */
public class PhoneBillTest {
    static PhoneBill Billrecord;

    String customer = null;
    String callerNumber = null;
    String calleeNumber = null;
    String start = null;
    String end = null;


    PhoneCall call = new PhoneCall(callerNumber,calleeNumber,start,end);  // Refer to one of Dave's classes so that we can be sure it is on the classpath

    /**
     * test the getcaller function
     */
    @Test
    public void TestgetCaller() {
        Billrecord = new PhoneBill(customer, new PhoneCall(callerNumber, calleeNumber, start, end));

        assertThat(Billrecord.getCustomer(), is(nullValue()));
    }

    /**
     * tests the get phonecalls method
     */
    @Test
    public void TestgetPhoneCalls() {
        Billrecord = new PhoneBill(customer, new PhoneCall(callerNumber, calleeNumber, start, end));

        assertThat(Billrecord.getPhoneCalls(), equalTo(Billrecord.phoneCalls));
    }

}
