package edu.pdx.cs410J.dp6;

import edu.pdx.cs410J.AbstractPhoneCall;
import edu.pdx.cs410J.AbstractPhoneBill;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * PhoneBill class that implements the phonebill functinality
 */
public class PhoneBill extends AbstractPhoneBill {

    String customer;
    List<AbstractPhoneCall> phoneCalls;

    /**
     *
     * @param customer string for customer name
     * @param phonecall object of PhoneCall class
     */
    PhoneBill(String customer,PhoneCall phonecall)
    {
        this.customer = customer;
        phoneCalls = new ArrayList<AbstractPhoneCall>();
        addPhoneCall(phonecall);


    }

    /**
     *
     * @return returns customer name
     */
    @Override
    public String getCustomer() {
        return customer;
    }

    /**
     *
     * @param abstractPhoneCall object for the abstract class of PhoneCal
     */
    @Override
    public void addPhoneCall(AbstractPhoneCall abstractPhoneCall) {
        phoneCalls.add(abstractPhoneCall);

    }

    /**
     *
     * @return returns list of phone calls made
     */
    @Override
    public Collection getPhoneCalls() {
        return phoneCalls;
    }
}
