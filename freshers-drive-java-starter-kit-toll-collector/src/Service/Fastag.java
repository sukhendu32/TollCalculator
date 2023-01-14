package Service;

import java.util.HashMap;
import java.util.Map;


public class Fastag {
	
	
   private static Map<String, Integer> fastag=new HashMap<>();
   
   

   public static Map<String, Integer> getFastag() {
	return fastag;
   }

   public static void setFastag(Map<String, Integer> fastag) {
	Fastag.fastag = fastag;
   }

   

}
