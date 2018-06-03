

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

// import com.sumeer.ParkingLot.*;
import java.io.*;


public class ParkingLotTest {

	private static final PrintStream os = null;
	private static BufferedReader inputLine = null;
	private static boolean closed = false;
	private static ParkingSlot PS = new ParkingSlot();
	
	public static void main(String args[]) {
	    
		
	    if (args.length > 0) {
	    	System.out.println(args[0]);
			String fileName = args[0];        
			String line = null;

			try {
				// FileReader reads text files in the default encoding.
			    FileReader fileReader = new FileReader(fileName);

			    // Always wrap FileReader in BufferedReader.
			    BufferedReader bufferedReader = new BufferedReader(fileReader);

			    while((line = bufferedReader.readLine()) != null) {
			    	System.out.println(line);
			    	handle_read_string(line);
			    }   

			    // Always close files.
			    bufferedReader.close();         
			}
			catch(FileNotFoundException ex) {
			      System.out.println("Unable to open file '" + fileName + "'");                
			}
			catch(IOException ex) {
			      System.out.println("Error reading file '" + fileName + "'");                  
			      // Or we could just do this: 
			      // ex.printStackTrace();
			}
			    
		}
		 
		
		inputLine = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (!closed) {
				System.out.println("waiting...");
				String str =  inputLine.readLine().trim();
				System.out.println(str);
				str.trim();
				handle_read_string(str);
			
			} 
		} catch (IOException e) {
				 
		}
	}

	public static void handle_read_string(String str) {

		if (str.startsWith("create_parking_lot")) {
				String[] tokens = str.split(" ");
				int number = Integer.parseInt(tokens[1]);	
				PS = new ParkingSlot(number);
			}
		else
			if (str.startsWith("park")) {
				String[] tokens = str.split(" ");
				String carNumber = tokens[1];
				String carColor = tokens[2];
				//park <reg> <color>
				int slotNumber = PS.AddVehicle(carNumber, carColor);
				//slot number to be printed is 1 more than the index returned
				System.out.println("Allocated slot number: " + slotNumber);
			}
			else if (str.startsWith("leave")) {
					String[] tokens = str.split(" ");
					int slotNumber = Integer.parseInt(tokens[1]);	
					//leave <slotNumber>
					//error checks have to be put in
					PS.removeVehicle(slotNumber);
					System.out.println("Slot number " + slotNumber + " is free");
			
			} else if (str.startsWith("status")) {
				PS.getParkingStatus();
			}
			else if (str.startsWith("registration_numbers_for_cars_with_colour")) {
				
				String[] tokens = str.split(" ");
				String carColor = tokens[1];
				// System.out.println("inside registration_numbers_for_cars_with_colour " + carColor);
				String retString = PS.handle_registration_number_for_cars_with_color(carColor);
			
			}
			else if (str.startsWith("slot_numbers_for_cars_with_colour")) {
				
				String[] tokens = str.split(" ");
				String carColor = tokens[1];
				String retStr = PS.handle_slot_number_for_cars_with_color(carColor);
				// System.out.println("slot for color " + carColor + "is " + retStr);
			
			} else if (str.startsWith("slot_number_for_registration_number")) {
				String[] tokens = str.split(" ");
				String carReg = tokens[1];
				// System.out.println("reg number " + carReg + " fo slot");
				int slotNumber = PS.handle_slot_number_for_registration_number(carReg);
				if (slotNumber > 0)
					System.out.println(slotNumber);
				else
					System.out.println("Not found");
					
			}
	}
}