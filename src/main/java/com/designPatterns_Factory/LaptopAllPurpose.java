package com.designPatterns_Factory;

/**
 * 
 * LaptopAllPurpose class extends Abstract Laptop
 * Object available to be produced by Factory
 *
 */

public class LaptopAllPurpose extends Laptop_Abstract {
	
	public LaptopAllPurpose(){		
		setType("All purpose");		
		setResolution("Medium");
	}
	
}