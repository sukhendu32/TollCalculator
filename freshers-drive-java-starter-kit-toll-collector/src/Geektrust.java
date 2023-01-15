import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import Model.SortingLogic;
import Model.Vehicle;
import Service.Fastag;
import Service.Payment;
import Service.Tollbooth;
import emums.vehicle;

public class Geektrust {
	public static void main(String[] args) {
		try {

			// the file to be opened for reading
			FileInputStream fis = new FileInputStream(args[0]);
			Scanner sc = new Scanner(fis); // file to be scanned
			// returns true if there is another line to read

			while (sc.hasNextLine()) {
				String inputCommand = sc.nextLine();
				String input[] = inputCommand.split(" ");

				if (input[0].equals("FASTAG")) {//storing in fastag

					Map<String, Integer> fsatag = Fastag.getFastag();
					fsatag.put(input[1], Integer.parseInt(input[2]));
					Fastag.setFastag(fsatag);

				} else if (input[0].equals("COLLECT_TOLL")) {//running tollcalculator operation in Tollbooth class

					Tollbooth.collectAmount(vehicle.valueOf(input[1]), input[2]);

				} else if (input[0].equals("PRINT_COLLECTION")) { //printing the desire result 

					int total = Payment.getCashpayment() + Payment.getFsatagPayment();

					System.out.println("TOTAL_COLLECTION" + " " + total + " " + Payment.getDiscount());
					System.out.println(
							"PAYMENT_SUMMARY" + " " + Payment.getFsatagPayment() + " " + Payment.getCashpayment());

					Set<Vehicle> ans = new TreeSet<Vehicle>(new SortingLogic());
					Set<Vehicle> veh = Tollbooth.getAllvehicle();

					for (Vehicle v : veh)
						ans.add(v);

					for (Vehicle v : ans)
						System.out.println(v.getV() + " " + v.getCount());

				}

				
				
				
			}

			sc.close(); // closes the scanner
		} catch (IOException e) {

			System.out.println(e.getMessage());

		}
	}
}
