package Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import Model.SortingLogic;
import Model.Vehicle;
import emums.vehicle;

public class Tollbooth {


	private static Set<Vehicle> allvehicle = new HashSet<>();
	private static Map<String, Boolean> checkVehicle = new HashMap<>(); // check for round trip

	
	//collecting amount and registering vehicles in the above set and map
	public static void collectAmount(vehicle v, String vehicleNumber) {
         
		
		boolean flag = true;//check for cash payment
		Integer amount = PriceChart.price().get(v);//grting price of vehicles

		
		
		if (checkVehicle.containsKey(vehicleNumber) && checkVehicle.get(vehicleNumber)) {

			amount = amount / 2; //discount
			Payment.setDiscount(Payment.getDiscount() + amount);//discount added in payment class
			boolean cashPay = makePayment(amount, v, vehicleNumber);

			checkVehicle.put(vehicleNumber, false);

			if (cashPay)
				amount = amount + 40;//cash payment flat fee added in amount if flag is true

		} else {

			boolean cashPay = makePayment(amount, v, vehicleNumber);
			checkVehicle.put(vehicleNumber, true);

			if (cashPay)
				amount = amount + 40;
		}

		
		
	
		for (Vehicle veh : allvehicle) {//all vehicles adding with amount and count

			if (veh.getV() == v) {

				veh.setAmount(veh.getAmount() + amount);
				veh.setCount(veh.getCount() + 1);

				allvehicle.add(veh);
				flag = false;
				break;

			}

		}
          
		if (flag) {

			Vehicle veh = new Vehicle(v, amount, 1);
			allvehicle.add(veh);
           
		}

	}

	
	//dividing the amount into cash,fastag amd discount
	public static boolean makePayment(Integer amount, vehicle v, String vehicleNumber) {

		boolean cashPay = false;
		Map<String, Integer> fastag = Fastag.getFastag();

		if (fastag.containsKey(vehicleNumber)) {
			if (fastag.get(vehicleNumber) >= amount) {

				Payment.setFsatagPayment(Payment.getFsatagPayment() + amount);
				fastag.put(vehicleNumber, fastag.get(vehicleNumber) - amount);
				Fastag.setFastag(fastag);

			} else {

				Payment.setFsatagPayment(Payment.getFsatagPayment() + fastag.get(vehicleNumber));
				Payment.setCashpayment(Payment.getCashpayment() + (amount - fastag.get(vehicleNumber) + 40));
				fastag.put(vehicleNumber, 0);
				Fastag.setFastag(fastag);

				cashPay = true;
			}

		} else {

			Payment.setCashpayment(Payment.getCashpayment() + amount + 40);
			cashPay = true;

		}

		return cashPay; //return true if cash payment is made 

	}

	public static Set<Vehicle> getAllvehicle() {
		return allvehicle;
	}

	public static void setAllvehicle(Set<Vehicle> allvehicle) {
		Tollbooth.allvehicle = allvehicle;
	}

}
