package com.encapsulation;

public class LightBulb {
private int power;
private String color;

public LightBulb(int power, String color) {
	this.power = power;
	this.color = color;
}

public int getPower() {
	return power;
}

public String getColor() {
	return color;
}
}
