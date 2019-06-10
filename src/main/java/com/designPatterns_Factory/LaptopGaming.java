package com.designPatterns_Factory;

/**
 * 
 * LaptopGaming class extends Abstract Laptop
 * Object available to be produced by Factory
 *
 */

public class LaptopGaming extends Laptop_Abstract {
	
	public LaptopGaming(){
		setType("Gaming");		
		setResolution("High");
	}
	
}
