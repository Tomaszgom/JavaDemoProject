package com.composition;

public class Wheel_test {
    private String type;
    private int number;
    private double pressure;

    public Wheel_test(String type, int number, double pressure) {
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
