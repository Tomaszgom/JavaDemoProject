package com.designPatterns_Factory;
import java.util.Scanner;

/**
 * 
 * Factory Pattern class handling the production of Laptop object utilizing Factory Class
 * 
 * Factory conveyor belt, that represent application in progress, is launched, program returns classes that are
 * represented by laptop type: Gaming, Office and All purpose. While conveyor belt 'is moving', so at run time,
 * user decides what new laptop to produce. Based on that program creates corresponding objects that share laptop
 *  abstract super class.
 * 
 * Factory Pattern is used in cases there is a need for the method to return one of the classes, defined beforehand,
 * that extent the same super class. Typically this is situation when we do not want to decide before run time
 * about the exact classes to be returned and to be used, also to control the selection of classes creation and
 * to encapsulate creation of objects.
 * 
 * 
 * */

public class ProductionControl {

	static Laptop_Factory Factory;
	static Laptop_Abstract laptop;
		
	public static void LaunchProduction() {
			// New Factory
		Factory = new Laptop_Factory();		
			// Set abstract laptop
		laptop = null;		
	}
	public static String ProduceLaptop(String produceLaptopType) {
		//Produce type of laptop: LaptopGaming ; LaptopOffice ; LaptopAllPurpose		
		if (produceLaptopType!=""){		
			String laptopType = produceLaptopType;
			
			laptop = Factory.makeLaptop(laptopType);
			
			if(laptop != null){				
				return PrintProductInfo(laptop);				
			}		
		}	
		return "Errot, laptop has not been produced";
	}
	
		// Super abstract class call
	public static String PrintProductInfo (Laptop_Abstract laptop){
		return laptop.PrintInfo();		
	}
	
}