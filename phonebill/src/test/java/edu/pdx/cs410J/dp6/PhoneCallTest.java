package edu.pdx.cs410J.dp6;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for the {@link PhoneCall} class.
 *
 * You'll need to update these unit tests as you build out you program.
 */
public class PhoneCallTest {

  String callerNumber = null;
  String calleeNumber = null;
  String start = null;
  String end = null;




  @Test
  public void TestgetEndTimeString() {
   // PhoneCall call = new PhoneCall();
    PhoneCall call = new PhoneCall(callerNumber,calleeNumber,start,end);  // Refer to one of Dave's classes so that we can be sure it is on the classpath

    assertThat(call.getEndTimeString(), is(nullValue()));
  }
  @Test
  public void TestgetStartTimeString() {
    // PhoneCall call = new PhoneCall();
    PhoneCall call = new PhoneCall(callerNumber,calleeNumber,start,end);  // Refer to one of Dave's classes so that we can be sure it is on the classpath

    assertThat(call.getStartTimeString(), is(nullValue()));
  }

  @Test
  public void TestgetCallee() {
    // PhoneCall call = new PhoneCall();
    PhoneCall call = new PhoneCall(callerNumber,calleeNumber,start,end);  // Refer to one of Dave's classes so that we can be sure it is on the classpath

    assertThat(call.getCallee(), is(nullValue()));
  }


}
