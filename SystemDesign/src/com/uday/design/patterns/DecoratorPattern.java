package com.uday.design.patterns;

public class DecoratorPattern {

    public static void main(String[] args){
        CheeseDecorator cd = new CheeseDecorator(new ChickenBurger());
    }
}

abstract class Burger{
    int price;

    public Burger(int p){
        price = p;
    }
    public void consume(){

    }
}

class ChickenBurger extends Burger{

    public ChickenBurger(){
        super(100);
    }

}

abstract class Decorator{
    Burger burger;

    int extraPrice;

    public Decorator(int e){
        extraPrice = e;
    }

    public int getPrice(){
        return this.burger.price+ this.extraPrice;
    }
}

class CheeseDecorator extends Decorator{

    public CheeseDecorator(Burger b){
        super(20);
        this.burger = b;
    }
}


