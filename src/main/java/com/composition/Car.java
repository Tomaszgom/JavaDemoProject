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
    
    public void CheckCar() {    	
    	System.out.println("The engine " + cEngine.getManufacturer() + " powered by " + cEngine.getPower());
    	cEngine.CheckTheOil();
        CheckTires();
    }

    private void CheckTires() {
    	Wheel[] wheels = {Wheel1, Wheel2, Wheel3, Wheel4};
        for(Wheel W: wheels) {
        	System.out.println("Wheel number " + W.getNumber() + " pressure is " + W.getPressure());
        }
    }
}
