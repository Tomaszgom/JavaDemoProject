package com.designPatterns_Factory;

/**
 * 
 * LaptopOffice class extends Abstract Laptop
 * Object available to be produced by Factory
 *
 */

public class LaptopOffice extends Laptop_Abstract {
	
	public LaptopOffice(){		
		setType("Office");		
		setResolution("Low");		
	}
	
}