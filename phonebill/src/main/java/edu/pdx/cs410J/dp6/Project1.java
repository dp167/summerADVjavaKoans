package edu.pdx.cs410J.dp6;

import edu.pdx.cs410J.AbstractPhoneBill;

/**
 * The main class for the CS410J Phone Bill Project
 * by David Poole on 07/08/2020
 */
public class Project1 {

    static PhoneCall PhoneRecord;
    static PhoneBill Billrecord;

    static String customer = null;
    static String callerNumber = null;
    static String calleeNumber = null;
    static String start = null;
    static String end = null;

    /**
     * this is the main method that runs the program
     * @param args this is the command line arguments
     */
    public static void main(String[] args) {

        readCL(args);// read from command line
        output(args);// output based on command line input
    }

    /**
     *This function Reads from the command line
     * @param args is the command line arguments in string format
     *
     */

        public static void readCL(String[] args)
        {
            if (args.length ==0)
                errorout("No command line arguments");

            if(args.length != 8 )
                errorout("Missing command line arguments");



            if (args.length == 1 && args[0].contains("-README"))
                Readme();


            customer = args[0];
            callerNumber = args[1];
            calleeNumber = args[2];

            start = args[3] + " ";
            start += args[4];

            end = args[5] + " ";
            end += args[6];

            if (customer == null)
                errorout("Missing customer field!");
            else if (callerNumber == null)
                errorout("Missing caller number field!");
            else if (start == null)
                errorout("Missing start field!");
            else if (end == null)
                errorout("Missing end field!");
            else if (start.contains("\"") || end.contains("\""))
                errorout("Date and time cannot contain quotes");
            else if (!callerNumber.matches("\\d{3}-\\d{3}-\\d{4}$") || !calleeNumber.matches("\\d{3}-\\d{3}-\\d{4}$"))
                errorout("Phone numbers must contain 10 digits with dashes");
            else if (!args[3].matches("(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)") || !args[5].matches("(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)"))
                errorout("Date format must follow mm/dd/yyyy");
            else if (!args[4].matches("([01]?[0-9]|2[0-3]):[0-5][0-9]") || !args[6].matches("([01]?[0-9]|2[0-3]):[0-5][0-9]"))
                errorout("Time format must be mm:hh (24 hour time)");
        }

    /**
     * Output function writes to standard out based on user input
     * @param args is the command line arguments in string form
     */

        public static void output(String [] args)
        {

            PhoneRecord = new PhoneCall(callerNumber, calleeNumber, start, end);  // Refer to one of Dave's classes so that we can be sure it is on the classpath

            Billrecord = new PhoneBill(customer, new PhoneCall(callerNumber, calleeNumber, start, end));

           int loopvar= 7;
            while(loopvar<args.length)
            {
                if(loopvar > 8)
                    break;
                if(args[loopvar]== "-README")
                    break;
                else if(args[loopvar]=="-print")
                    System.out.println(PhoneRecord.toString());

                ++loopvar;

            }

            System.exit(0);
        }

    /**
     *
     * @param error this is a string with the error message to be output
     */
    private static void errorout(String error)
    {
        System.out.print(error);
        System.exit(3);
    }

    /**
     * this is the hard coded readme
      */
    private static void Readme() {
        System.out.println("README has been called");
        System.out.println("This program is a phonebill application which takes 5 arguments");
        System.out.println("You must provide a customer name, caller number, callee number, start time, and end time (mm/dd/yyyy mm:hh)");
        System.out.println();
        System.out.println("Usage: java edu.pdx.cs410J.<login-id>.Project1 [options] <args>\n" +
                "   args are (in this order):\n" +
                "       customer               Person whose phone bill we’re modeling\n" +
                "       callerNumber           Phone number of caller\n" +
                "       calleeNumber           Phone number of person who was called\n" +
                "       startTime              Date and time the call began (24-hour time)\n" +
                "       endTime                Date and time the call ended (24-hour time)\n" +
                "   options are (options may appear in any order):\n" +
                "       -print                 Prints a description of the new phone call\n" +
                "       -README                Prints a README for this project and exits\n" +
                "   Date and time should be in the format: mm/dd/yyyy hh:mm");
        System.exit(2);
    }


}

