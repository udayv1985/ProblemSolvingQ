package com.uday.design.patterns;

import com.sun.tools.corba.se.idl.constExpr.Or;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    public static void main(String[] args){
        Order o = new Order();
        SMSSender smsSender = new SMSSender();
        EmailSender emailSender = new EmailSender();
        o.registerObserver(smsSender);
        o.registerObserver(emailSender);
        o.setState(2);
    }
}

class Order {
    private int state;

    List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    public void deregisterObserver(Observer o) {
        this.observers.remove(o);
    }

    public void notifyObservers() {
        observers.forEach(o -> o.execute());
    }

    public void setState(int s){
        this.state = s;
        this.notifyObservers();
    }


}

interface Observer {
    public void execute();
}

class SMSSender implements Observer {

    @Override
    public void execute() {
        System.out.println("Send sms.");
    }
}

class EmailSender implements Observer {

    @Override
    public void execute() {
        System.out.println("Send email.");
    }
}
