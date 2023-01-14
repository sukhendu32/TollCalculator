package Model;

import java.util.Comparator;

//sorting based on amount then by name
public class SortingLogic implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle o1, Vehicle o2) {
         
		
		if(o1.getAmount().equals(o2.getAmount())) {
			
			return o1.getV().toString().compareTo(o2.getV().toString());
//			return o2.getAmount()-o1.getAmount();
			
		}else {
			
			return o2.getAmount().compareTo(o1.getAmount());

			
		}	 
		
		
		 		
	}

}
