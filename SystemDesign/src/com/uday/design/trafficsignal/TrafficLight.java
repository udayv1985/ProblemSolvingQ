package com.uday.design.trafficsignal;

public enum TrafficLight {

    RED,
    YELLOW,
    GREEN;

    private TrafficLight next;

    static {
        RED.next = GREEN;
        YELLOW.next = RED;
        GREEN.next = YELLOW;
    }

    public TrafficLight getNext(){
        return next;
    }

}
