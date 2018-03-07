package com.composition;

public class Car {
    private Engine cEngine;
    private Wheel Wheel1;
    private Wheel Wheel2;
    private Wheel Wheel3;
    private Wheel Wheel4;
    
    public Car(Engine cEngine, Wheel wheel1, Wheel wheel2, Wheel wheel3, Wheel wheel4) {
		super();
		this.cEngine = cEngine;
		Wheel1 = wheel1;
		Wheel2 = wheel2;
		Wheel3 = wheel3;
		Wheel4 = wheel4;
	}
    
    public String CheckCar() {    	
    	String str;
    	//System.out.println("The engine " + cEngine.getManufacturer() + " powered by " + cEngine.getPower());
    	str = "The engine " + cEngine.getManufacturer() + " powered by " + cEngine.getPower()+"\n";
    	str = str + cEngine.CheckTheOil();
    	str = str + CheckTires()+"\n";
        return str;
    }

    private String CheckTires() {
    	String str = "";
    	Wheel[] wheels = {Wheel1, Wheel2, Wheel3, Wheel4};
        for(Wheel W: wheels) {
        	//System.out.println("Wheel number " + W.getNumber() + " pressure is " + W.getPressure());
        	str = str + "Wheel number " + W.getNumber() + " pressure is " + W.getPressure()+"\n";
        }
        return str;
    }
}
