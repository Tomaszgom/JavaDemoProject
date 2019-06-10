package com.designPatterns_Factory;

/**
 * 
 * Factory Class handles creation of Laptop objects, encapsulating creation
 *
 */

public class Laptop_Factory{
	
	public Laptop_Abstract makeLaptop(String newLaptopType){
		
			//Laptop_Abstract newLap = null;		
		if (newLaptopType.equals("LaptopGaming")){			
			return new LaptopGaming();					
		} else if (newLaptopType.equals("LaptopOffice")){			
			return new LaptopOffice();					
		} else if (newLaptopType.equals("LaptopAllPurpose")){			
			return new LaptopAllPurpose();			
		} else return null;		
	}	
}