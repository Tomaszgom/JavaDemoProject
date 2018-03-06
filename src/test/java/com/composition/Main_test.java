package com.composition;
/*Composition Notes
 * 
 * Composition defines relation between classes as 'HAS A'. Super Class HAS A Sub-Class
otherwise than in Inheritance where more typical relation is 'IS A'. SubClass IS A SuperClass
Let's use simple Demo example - a Car.
Car is super class and is composed of subclasses, one engine and 4 weels.
Car has an engine.
Car has wheels.

First of all Car class is created from engine and 4 weels.

Whenever we need to check oil level, we will first call car in which we have engine. Engine has method that allows to check the oil level.
*/
public class Main_test {

    public static void main(String[] args) {
        OilFilter_test oilFilter = new OilFilter_test("new");
	    Engine_test engine = new Engine_test("Ferrari", "605 PS", 14, oilFilter);
        Wheel_test Wheel1 = new Wheel_test("summer", 1, 3.2);
        Wheel_test Wheel2 = new Wheel_test("summer", 2, 3.0);
        Wheel_test Wheel3 = new Wheel_test("summer", 3, 3.1);
        Wheel_test Wheel4 = new Wheel_test("summer", 4, 3.2);

        Car_test car = new Car_test(engine, Wheel1, Wheel2, Wheel3, Wheel4);
        car.CheckCar();

    }
}
