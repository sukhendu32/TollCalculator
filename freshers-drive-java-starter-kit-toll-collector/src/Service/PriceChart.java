package Service;

import java.util.HashMap;
import java.util.Map;

import emums.vehicle;

public class PriceChart {
	
	
	
	public static Map<vehicle, Integer> price() {
		
		 Map<vehicle, Integer> vp=new HashMap<>();
		 vp.put(vehicle.CAR,100);
		 vp.put(vehicle.BUS,200);
		 vp.put(vehicle.MOTORBIKE,50);
		 vp.put(vehicle.RICKSHAW,100);
		 vp.put(vehicle.SCOOTER,50);
		 vp.put(vehicle.TRUCK,200);
		 vp.put(vehicle.VAN,100);
		 
		 
		 return vp;
		
	}
	

	
	
	
	
	

}
