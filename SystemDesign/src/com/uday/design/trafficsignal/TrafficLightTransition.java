package com.uday.design.trafficsignal;

import java.util.concurrent.TimeUnit;

public interface TrafficLightTransition {

    static public void execute(TrafficSignal trafficSignal) throws InterruptedException {
        TrafficLight first = trafficSignal.current;
        do{
            System.out.println("Traffic signal: "+ trafficSignal.id+" current light: "+trafficSignal.current.name());
            TimeUnit.SECONDS.sleep(trafficSignal.durationMap.get(trafficSignal.current));
            trafficSignal.change();
        }
        while(!(trafficSignal.current == first));
        System.out.println("Traffic signal: "+ trafficSignal.id+" last light: "+trafficSignal.current.name());
    }
}
