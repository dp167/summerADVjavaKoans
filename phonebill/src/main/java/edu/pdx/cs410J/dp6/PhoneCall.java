package edu.pdx.cs410J.dp6;

import edu.pdx.cs410J.AbstractPhoneCall;

/**
 * PhoneCall class that implements to functionality of the phonecall system
 */
public class PhoneCall extends AbstractPhoneCall {

  String callerNumber;
  String calleeNumber;
  String startTime;
  String endTime;

  /**
   *
   * @param callerNumber
   * @param calleeNumber
   * @param startTime
   * @param endTime
   */
  PhoneCall(String callerNumber, String calleeNumber, String startTime, String endTime)
  {
    this.callerNumber = callerNumber;
    this.calleeNumber = calleeNumber;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  /**
   *
   * @return the callers phone number
   */
  @Override
  public String getCaller() {
    return callerNumber;
  }

  /**
   *
   * @return returns the callees phone number
   */

  @Override
  public String getCallee() {
    return calleeNumber;
  }

  /**
   *
   * @return the start time of phone call
   */

  @Override
  public String getStartTimeString() {
    return startTime;
  }

  /**
   *
   * @return returns end time of phone call
   */

  @Override
  public String getEndTimeString() {
   return endTime;
  }
}
