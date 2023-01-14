import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Model.SortingLogic;
import Model.Vehicle;
import Service.Fastag;
import Service.Payment;
import Service.Tollbooth;
import emums.vehicle;
import exception.TollCalculatorException;


public class Geektrust {
    public static void main(String[] args)  {
        try {
        	
        	if (args.length != 1) {
                throw new TollCalculatorException("Input file not supplied. Please provide the input file");
              }
        	
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream("C://Users//hp//Desktop//freshers-drive-java-starter-kit-toll-collector//sample_input//input1.txt");
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               String inputCommand = sc.nextLine();
               
                   
                //Spliting the string based on space
                 String input[]=inputCommand.split(" ");
                 
                 
                 
                 //Registering the fastag vehicle with Amount balance.
                 if(input[0].equals("FASTAG")) {
                	 
                	 Map<String, Integer> fsatag= Fastag.getFastag();
                	 fsatag.put(input[1], Integer.parseInt(input[2])); 
                	 Fastag.setFastag(fsatag);
                	 
                 }else if(input[0].equals("COLLECT_TOLL")) {
                	 
                	 //calling tollbooth class to perform required operations
                	 Tollbooth.collectAmount(vehicle.valueOf(input[1]), input[2]);
                	 
                 }else if(input[0].equals("PRINT_COLLECTION")){
                	 
                	 //geting total collection
                	 int total=Payment.getCashpayment()+Payment.getFsatagPayment(); 
                	 
                	 //printing 
                	 System.out.println("TOTAL_COLLECTION"+" "+total+" "+Payment.getDiscount());
                	 System.out.println("PAYMENT_SUMMARY"+" "+Payment.getFsatagPayment()+" "+Payment.getCashpayment());  
                	 
                	 //sorting vehicle based on amount then by vehicle name 
                	 Set<Vehicle> veh=Tollbooth.getAllvehicle();
                	  for(Vehicle v:veh) 
                		 System.out.println(v.getV()+" "+v.getCount());
                		  
                    	
                	 
                 }
                 
                 
               //Add your code here to process input commands.
//              String output = ""; //process the input command and get the output
               //Once it is processed print the output using the command System.out.println()
//             System.out.println(output);
            }
               
             
            sc.close(); // closes the scanner
        } catch (IOException e) {
        	
        	System.out.println(e.getMessage());
        	
        	
        }
	}
}
