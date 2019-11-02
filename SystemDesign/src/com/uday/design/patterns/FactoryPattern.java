package com.uday.design.patterns;

import com.uday.ds.trie.Trie;

public class FactoryPattern {


}

class VehicleFactory{

    public static Vehicle getVehicle(String type){
        if(type.equalsIgnoreCase("car")){
            return new Car();
        }
        else if(type.equalsIgnoreCase("truck")){
            return new Truck();
        }
        return null;
    }
}

abstract class Vehicle{
    String type;

    public Vehicle(String type){
        this.type = type;
    }
}

class Car extends Vehicle{
    public Car(){
        super("car");
    }
}

class Truck extends Vehicle{
    public Truck(){
        super("truck");
    }
}