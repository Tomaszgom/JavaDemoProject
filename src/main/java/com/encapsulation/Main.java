package com.encapsulation;
/*Encapsulation Notes
 * 
 * Encapsulation allows to restrict access to certain components in the object that you creating
 * allows to protect members of the class from external access in order to guard against unauthorized access
 * changes within class will not affect external code
 * 
 * Example
 * Chadelier that uses the Encapsulation
 * Encapsulation restrict changes/ manipulation of class variables from outside of the class, on case there is a need
 * ofr  variables from outside of class appropriate methids getters and setters are used
 * constructor guaranties that all necessary variables are set once object is created
*/
public class Main {

    public static void main(String[] args) {
    	String output;
    	LightBulb bulb1 = new LightBulb(50, "blue");
    	LightBulb bulb2 = new LightBulb(90, "yelow");
    	LightBulb bulb3 = new LightBulb(30, "green");
    	
    	Chandelier chandelier = new Chandelier("blue", bulb1, bulb2, bulb3);
    	output = "Chandelier max power is " + Integer.toString(chandelier.getChandelierMaxPower())+"\n";
    	
        System.out.println(output);
        System.out.println("Bulb1 "+chandelier.getLightBulb1Info());
        System.out.println("Bulb2 "+chandelier.getLightBulb2Info());
        System.out.println("Bulb3 "+chandelier.getLightBulb2Info());
        
    }
}
