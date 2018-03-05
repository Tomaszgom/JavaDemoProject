package com.encapsulation;


public class Chandelier {
	/*Chandelier has max power and up to 3 light bulbs. Each bulb is separate class. Chandelier
	 * m
	 * Sum of all light bulb's power cannot exceed max chandelier power
	 * all variables by default are private, so we need to use getters
	 * fields witin cas are not accessible to external classes
	 * 
	 * */
	//
	//changes around fields within class does not affect what is heppening outside of class
    private String color;
    private int chanMaxPower = 200; //we produce only chandelier with max power 200
    private LightBulb lightBulb1, lightBulb2, lightBulb3;


    		//3 constructors each allowing to create Chandelier with min 1, max 3 light bulbs
        	//constructor demands the variables to be set in a certain way
    		//if the sum po light bulbs power exceeds max power, chandelier will e burned
    public Chandelier(String color, LightBulb lightBulb1, LightBulb lightBulb2,
			LightBulb lightBulb3) {
		this.color = color;
		this.lightBulb1 = lightBulb1;
		this.lightBulb2 = lightBulb2;
		this.lightBulb3 = lightBulb3;
		if(getSumLightBulbsPower() > chanMaxPower) {
			System.out.println("Chandelier has burned out, too much power. Aborted. Max power is "+getChandelierMaxPower()); System.exit(0);}}
    
    public Chandelier(String color, LightBulb lightBulb1, LightBulb lightBulb2) {
		this.color = color;
		this.lightBulb1 = lightBulb1;
		this.lightBulb2 = lightBulb2;
		this.lightBulb3 = null;
		if(getSumLightBulbsPower() > chanMaxPower) {
			System.out.println("Chandelier has burned out, too much power. Aborted. Max power is "+getChandelierMaxPower()); System.exit(0);}}
	
    public Chandelier(String color, LightBulb lightBulb1) {
		this.lightBulb1 = lightBulb1;
		this.lightBulb2 = null;
		this.lightBulb3 = null;
		if(getSumLightBulbsPower() > chanMaxPower) {
			System.out.println("Chandelier has burned out, too much power. Aborted. Max power is "+getChandelierMaxPower()); System.exit(0);}}

    	//sum of light bulbs power
    private int getSumLightBulbsPower() {
    	int l1, l2, l3;
    	if(lightBulb1 != null) {l1 = lightBulb1.getPower();}else {l1=0;}
    	if(lightBulb2 != null) {l2 = lightBulb2.getPower();}else {l2=0;}
    	if(lightBulb3 != null) {l3 = lightBulb3.getPower();}else {l3=0;}
    	
    	return l1 + l2 + l3;
    }


    public int getChandelierMaxPower() {
        return chanMaxPower;
    }
	public String getColor() {
		return color;
	}
	public String getLightBulb1Info() {
		if(lightBulb1 != null) {
			return "Color: " + lightBulb1.getColor() + " Power: " + lightBulb1.getPower();
		}else {
			return "Light Bulb 1 slot is empty";
		}
	}
	
	public String getLightBulb2Info() {
		if(lightBulb2 != null) {
		return "Color: " + lightBulb2.getColor() + " Power: " + lightBulb2.getPower();
		}else {
			return "Light Bulb 2 slot is empty";
		}
	}

	public String getLightBulb3Info() {
		if(lightBulb3 != null) {
		return "Color: " + lightBulb3.getColor() + " Power: " + lightBulb3.getPower();
		}else {
			return "Light Bulb 3 slot is empty";
		}
	}
	
}
