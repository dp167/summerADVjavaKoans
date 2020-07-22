package edu.pdx.cs410J.dp6;

import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.AbstractPhoneCall;
import edu.pdx.cs410J.ParserException;

import java.io.File;
import java.io.IOException;
import java.util.Collection;


/**
 * The main class for the CS410J Phone Bill Project
 * by David Poole on 07/08/2020
 */
public class Project2{

    static PhoneCall PhoneRecord;
    static PhoneBill Billrecord;

   // static TextParser parser;
    //static TextDumper dumper;

    static String customer = null;
    static String callerNumber = null;
    static String calleeNumber = null;
    static String start = null;
    static String end = null;

    static AbstractPhoneBill currentPhoneBill;
    static AbstractPhoneBill nextPhoneBill;

    /**
     * this is the main method that runs the program
     *
     * @param args this is the command line arguments
     */
    public static void main(String[] args) throws ParserException {



        readCL(args);// read from command line
        output(args);// output based on command line input
    }

    /**
     * This function Reads from the command line
     *
     * @param args is the command line arguments in string format
     */

    public static void readCL(String[] args) {
        if (args.length == 0)
            errorout("No command line arguments");
/*
        if (args.length < 8)
            errorout("Missing command line arguments");
*/


        if (args.length == 1 && args[0].contains("-README"))
            Readme();

        if(args[0].startsWith("-textFile")) {

            if (args.length == 2) {
                TextParser parser = new TextParser(args[1]);
                TextDumper dumper = new TextDumper(args[1]);

                parser = new TextParser(args[1]);
                parser.setFilePath(args[1]);
                if (parser.ifFileExists()) {
                    try {
                        currentPhoneBill = parser.parse();
                    } catch (ParserException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                } else {
                    currentPhoneBill = new PhoneBill();
                    dumper = new TextDumper(args[1]);
                   // dumper.setFilePath(args[1]);
                    try {
                        dumper.dump(currentPhoneBill);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }


            }
            else if(args.length == 3)
            {
                if(args[0].contains("-textFile"))
                {

                    TextParser parser = new TextParser(args[1]);
                    TextDumper dumper = new TextDumper(args[1]);
                    parser = new TextParser(args[1]);
                   // parser.setFilePath(args[1]);
                    try {
                        currentPhoneBill = parser.parse();
                    } catch (ParserException e) {
                        e.printStackTrace();
                    }
                }
                else if (args[0].contains("-README"))
                {
                    Readme();
                    System.exit(0);

                }
            }
            else


            {

                TextParser parser = new TextParser(args[1]);
                TextDumper dumper = new TextDumper(args[1]);

                parser = new TextParser(args[1]);
             //   parser.setFilePath(args[1]);
                try {
                    currentPhoneBill = parser.parse();
                } catch (ParserException e) {
                    System.out.println(e);
                }

                try {
                    if(args.length <=7)
                        throw new IllegalArgumentException("Missing command line arguments");
                    else {
                        customer = args[2];
                        callerNumber = args[3];
                        calleeNumber = args[4];

                        start = args[5] + " ";
                        start += args[6];

                        end = args[7] + " ";
                        end += args[8];
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (customer == null)
                    errorout("Missing command line arguments");
                else if (callerNumber == null)
                    errorout("Missing command line arguments");
                else if (start.contains("null"))
                    errorout("Missing command line arguments");
                else if (end.contains("null"))
                    errorout("Missing command line arguments");
                else if (start.contains("\"") || end.contains("\""))
                    errorout("Date and time cannot contain quotes");
                else if (!callerNumber.matches("\\d{3}-\\d{3}-\\d{4}$") || !calleeNumber.matches("\\d{3}-\\d{3}-\\d{4}$"))
                    errorout("Phone numbers must contain 10 digits with dashes");
                else if (!args[5].matches("(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)") || !args[7].matches("(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)"))
                    errorout("Date format must follow mm/dd/yyyy");
                else if (!args[6].matches("([01]?[0-9]|2[0-3]):[0-5][0-9]") || !args[8].matches("([01]?[0-9]|2[0-3]):[0-5][0-9]"))
                    errorout("Time format must be mm:hh (24 hour time)");
            }
            return;
        }


        try {
            if(args.length <=7)
                throw new IllegalArgumentException("Missing command line arguments");
            else {
                customer = args[1];
                callerNumber = args[2];
                calleeNumber = args[3];

                start = args[4] + " ";
                start += args[5];

                end = args[6] + " ";
                end += args[7];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (customer == null)
            errorout("Missing command line arguments");
        else if (callerNumber == null)
            errorout("Missing command line arguments");
        else if (start.contains("null"))
            errorout("Missing command line arguments");
        else if (end.contains("null"))
            errorout("Missing command line arguments");
        else if (start.contains("\"") || end.contains("\""))
            errorout("Date and time cannot contain quotes");
        else if (!callerNumber.matches("\\d{3}-\\d{3}-\\d{4}$") || !calleeNumber.matches("\\d{3}-\\d{3}-\\d{4}$"))
            errorout("Phone numbers must contain 10 digits with dashes");
        else if (!args[4].matches("(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)") || !args[6].matches("(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)"))
            errorout("Date format must follow mm/dd/yyyy");
        else if (!args[5].matches("([01]?[0-9]|2[0-3]):[0-5][0-9]") || !args[7].matches("([01]?[0-9]|2[0-3]):[0-5][0-9]"))
            errorout("Time format must be mm:hh (24 hour time)");
    }

    /**
     * Output function writes to standard out based on user input
     *
     * @param args is the command line arguments in string form
     */

    public static void output(String[] args) {

        PhoneCall PhoneRecord = new PhoneCall(callerNumber, calleeNumber, start, end);  // Refer to one of Dave's classes so that we can be sure it is on the classpath

        PhoneBill Billrecord = new PhoneBill(customer, new PhoneCall(callerNumber, calleeNumber, start, end));

        int loopvar = 0;
        while (loopvar < args.length) {
            if (loopvar > 8)
                break;
            if (args[loopvar] == "-README")
                break;
            else if (args[loopvar] == "-print")
                System.out.println(PhoneRecord.toString());
            else if (args[loopvar] == "-textFile")
                if (args[loopvar + 1] != null) {

                    TextParser parser = new TextParser(args[1]);
                    TextDumper dumper = new TextDumper(args[1]);
                    nextPhoneBill = new PhoneBill(null);
                   // parser = new TextParser(args[1]);
                   // dumper = new TextDumper(args[1]);
                   // parser.setFilePath(args[1]);
                    try {
                        nextPhoneBill = parser.parse();
                    } catch (ParserException e) {
                        System.out.println(e);
                    }
                    if(args[2]==Billrecord.getCustomer()) {
                        nextPhoneBill.addPhoneCall(PhoneRecord);

                        try {
                            dumper.dump(nextPhoneBill);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else
                    {
                        File file = new File(args[1]);
                        if(file.exists()) {
                            Billrecord.addPhoneCall(PhoneRecord);
                            System.out.println("Customer does not have a bill");
                        }
                        else
                        {

                            Billrecord.addPhoneCall(PhoneRecord);
                            try{
                                dumper.dump(Billrecord);
                            }catch(IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }





                   /*
                    if (parser.ifFileExists()) {
                        try {
                            nextPhoneBill = parser.parse();
                        } catch (ParserException e) {
                            e.printStackTrace();
                        }
                        if (Billrecord.getCustomer().equals(nextPhoneBill.getCustomer())) {
                            Collection tempPhoneCalls = nextPhoneBill.getPhoneCalls();
                            tempPhoneCalls.forEach(obj -> Billrecord.addPhoneCall((AbstractPhoneCall) obj));

                            dumper = new TextDumper(args[1]);
                            dumper.setFilePath(args[loopvar]);
                            try {
                                dumper.dump(Billrecord);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    } else {
                        dumper = new TextDumper(args[1]);
                        dumper.setFilePath(args[loopvar]);
                        try {
                            dumper.dump(Billrecord);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                     */
                }
                 else {

                    throw new IllegalArgumentException("with -textFile you must have a valid file name ");
                }


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
        System.out.println("Usage: java edu.pdx.cs410J.<login-id>.Project2 [options] <args>\n" +
                "   args are (in this order):\n" +
                "       customer               Person whose phone bill we’re modeling\n" +
                "       callerNumber           Phone number of caller\n" +
                "       calleeNumber           Phone number of person who was called\n" +
                "       startTime              Date and time the call began (24-hour time)\n" +
                "       endTime                Date and time the call ended (24-hour time)\n" +
                "   options are (options may appear in any order):\n" +
                "       -textFile file         Where to read/write the phone bill\n"+
                "       -print                 Prints a description of the new phone call\n" +
                "       -README                Prints a README for this project and exits\n" +
                "   Date and time should be in the format: mm/dd/yyyy hh:mm");
        System.exit(2);
    }


}