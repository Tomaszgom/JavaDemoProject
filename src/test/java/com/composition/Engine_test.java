package com.composition;

public class Engine_test {
    private String manufacturer;
    private String power;
    private int oilLevel;
    private OilFilter_test oilFilter;
    
    public Engine_test(String manufacturer, String power, int oilLevel, OilFilter_test oilFilter) {
        this.manufacturer = manufacturer;
        this.power = power;
        this.oilLevel = oilLevel;
        this.oilFilter = oilFilter;
    }

    public void CheckTheOil() { 	
        System.out.println("The Oil level is " + oilLevel);
        System.out.println("The Oil filter wear is '" + oilFilter.getWear()+"'");
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getPower() {
        return power;
    }
 
}
