package edu.pdx.cs410J.dp6;

import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.PhoneBillDumper;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;


public class TextDumper implements PhoneBillDumper {


    File file;
    String fileName;
    String path=null;

    public TextDumper(String fileName) {
        this.fileName = fileName+".txt";
    }
    /**
     * Dumps a phone bill to some destination.
     *
     * @param call
     */
    @Override
    public void dump(AbstractPhoneBill call) throws IOException {
/*
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();


            PrintWriter writer = new PrintWriter(file);
            writer.write("Created on: "+dateFormat.format(date) + "\n");

            writer.write("Customer: "+ bill.getCustomer()+"\n");
            writer.write(bill.getPhoneCalls().toString());
            // All done
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

 */
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file, false);
        Collection<PhoneCall> calls = call.getPhoneCalls();

        for (PhoneCall each : calls) {
            String save = call.getCustomer() + ";" + each.getCaller() + ";" + each.getCallee() + ";" + each.getStartTimeString() + ";"+ each.getEndTimeString() + "\n";
            fileWriter.write(save);
        }
        fileWriter.close();
    }



    public void setFilePath(String path){
        this.path = System.getProperty("user.dir");
        file = new File(this.path+ "/" + path + ".txt");

    }
}