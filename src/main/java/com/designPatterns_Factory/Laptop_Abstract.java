package com.designPatterns_Factory;

/**
 * Laptop_Abstract abstract Class available to be extended by the Laptop classes
 * Laptop_Abstract descendants are classes representing objects to be produced by Factory
 * 
 *
 */

public abstract class Laptop_Abstract {
	
	private String type;
	private String resolution;
	
	public String getType() { return type; }
	public void setType(String newType) { type = newType; }
	
	public String getResolution() { return resolution; }
	public void setResolution(String newRes) { resolution = newRes; }
	
	public String PrintInfo(){	
		return "'"+getType() + "' laptop has been produced with resolution "+getResolution();		
	}
	
}