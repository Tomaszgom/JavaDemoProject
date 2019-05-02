package com.scomposition;

public class Engine {
    private String manufacturer;
    private String power;
    private int oilLevel;
    private OilFilter oilFilter;
    
    public Engine(String manufacturer, String power, int oilLevel, OilFilter oilFilter) {
        this.manufacturer = manufacturer;
        this.power = power;
        this.oilLevel = oilLevel;
        this.oilFilter = oilFilter;
    }

    public String CheckTheOil() { 	
    	String str;   	
        //System.out.println("The Oil level is " + oilLevel);
        //System.out.println("The Oil filter wear is '" + oilFilter.getWear()+"'");
        str = "The Oil level is " + oilLevel+"\n";
        str = str + "The Oil filter wear is '" + oilFilter.getWear()+"'"+"\n";
        return str;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getPower() {
        return power;
    }
 
}
