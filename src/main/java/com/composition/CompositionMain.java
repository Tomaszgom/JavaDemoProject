package com.composition;
/*Composition Notes
 * 
 * Composition defines relation between classes as 'HAS A'. Super Class HAS A Sub-Class
otherwise than in Inheritance where more typical relation is 'IS A'. SubClass IS A SuperClass
Let's use simple Demo example - a Car.
Car is super class and is composed of subclasses, one engine and 4 wheels.
Car has an engine.
Car has wheels.
Car class is created from engine and 4 wheels.
Whenever we need to check oil level or any other part of the car, we will first call car in which we have the engine. Engine has method that allows to check the oil level.
*/
public class CompositionMain {

    public static String main(String[] args) {
        OilFilter oilFilter = new OilFilter("new");
	    Engine engine = new Engine("Maserati", "605 HP", 14, oilFilter);
        Wheel Wheel1 = new Wheel("summer", 1, 3.2);
        Wheel Wheel2 = new Wheel("summer", 2, 3.0);
        Wheel Wheel3 = new Wheel("summer", 3, 3.1);
        Wheel Wheel4 = new Wheel("summer", 4, 3.2);

        Car car = new Car(engine, Wheel1, Wheel2, Wheel3, Wheel4);
        System.out.println(car.CheckCar());
        return car.CheckCar();
    }

    
}
