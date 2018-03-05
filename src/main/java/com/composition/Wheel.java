package com.composition;

public class Wheel {
    private String type;
    private int number;
    private double pressure;

    public Wheel(String type, int number, double pressure) {
        this.type = type;
        this.number = number;
        this.pressure = pressure;
    }

    public String getType() {
        return type;
    }
    
    public int getNumber() {
        return number;
    }
    public double getPressure() {
        return pressure;
    }


}
