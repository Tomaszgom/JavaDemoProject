package com.composition;

public class Car_test {
    private Engine_test cEngine;
    private Wheel_test Wheel1;
    private Wheel_test Wheel2;
    private Wheel_test Wheel3;
    private Wheel_test Wheel4;
    
    public Car_test(Engine_test cEngine, Wheel_test wheel1, Wheel_test wheel2, Wheel_test wheel3, Wheel_test wheel4) {
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
    	Wheel_test[] wheels = {Wheel1, Wheel2, Wheel3, Wheel4};
        for(Wheel_test W: wheels) {
        	System.out.println("Wheel number " + W.getNumber() + " pressure is " + W.getPressure());
        }
    }
}
