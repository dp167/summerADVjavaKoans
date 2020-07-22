
package edu.pdx.cs410J.dp6;

import edu.pdx.cs410J.AbstractPhoneCall;
import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.PhoneBillParser;
//import sun.plugin.dom.core.Text;
import java.io.*;
import java.io.FileNotFoundException;


public class TextParser implements PhoneBillParser {
    File file;
    String path = null;
    Reader reader;
    String fileName;
    public PhoneBill bill = new PhoneBill(null);

    public TextParser(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public PhoneBill parse() throws ParserException {
        try {
            String byLine;
            FileReader input = new FileReader(this.fileName);

            BufferedReader br = new BufferedReader((input));


            while ((byLine = br.readLine()) != null) {
                String[] ParsedCalls = byLine.split(";");
                bill.setCustomer(ParsedCalls[0]);
                PhoneCall call = new PhoneCall(ParsedCalls[1], ParsedCalls[2], ParsedCalls[3], ParsedCalls[4]);
                bill.addPhoneCall(call);


            }
        } catch (FileNotFoundException e) {
            throw new ParserException("File not found.");
        }
        catch (IOException e) {
            throw new ParserException(("Invalid file"));
        }
        return bill;
    }


    public void setFilePath(String path){
        this.path = System.getProperty("user.dir");
        file = new File(this.path+ "/" + path + ".txt");
    }

    public boolean ifFileExists()
    {
        if(file.exists())
            return true;
        else
            return false;
    }

}


    //private String fileName;
    //public PhoneBill bill

/*

    File file;
    String path=null;
    /**
     * Parses some source and returns a phone bill
     *
     * @throws ParserException If the source cannot be parsed
     * @return
     */
/*
    @Override
    public PhoneBill parse() throws ParserException {
        BufferedReader reader = null;
        PhoneBill bill = null;
        try{
            reader=new BufferedReader(new FileReader(file));
            String line;
            String allLines="";
            while ((line = reader.readLine()) != null) {
                allLines+=line +"\n";
            }
            bill = ParseString(allLines);
        }
        catch(IOException ex){
            System.out.println("Error Reading From File "+ ex);
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return bill;
    }

    public void setFilePath(String path){
        this.path = System.getProperty("user.dir");
        file = new File(this.path+ "/" + path + ".txt");
    }

    public PhoneBill ParseString(String line){
        AbstractPhoneBill myPhoneBill=null;
        String callerNumber;
        String calleeNumber;
        String startTime;
        String endTime;

        //String[] tokens = line.split("\\s+|,\\s*|\\.\\s*");
        String[] tokens = line.split("\\r?\\n");
        int length = tokens.length;
        /*for(int x =0;x<tokens.length;x++)
        {
            System.out.println(x+": "+tokens[x]);
        }*/
/*
        myPhoneBill = new PhoneBill(tokens[1].substring(10));//add a customer to the phonebill

        for(int counter = 2;counter < length;counter++ ){
            if(tokens[counter] != null){
                String[] temp = tokens[counter].split("\\s+|,\\s*|\\.\\s*");
                if(temp.length>10) {
                    myPhoneBill.addPhoneCall(new PhoneCall(temp[3],temp[5],temp[7]+temp[8], temp[10]+temp[11].substring(0,temp[11].length()-1)));
                }
            }
        }
        return (PhoneBill) myPhoneBill;
    }
    public boolean ifFileExists()
    {
        if(file.exists())
            return true;
        else
            return false;
    }
}
*/