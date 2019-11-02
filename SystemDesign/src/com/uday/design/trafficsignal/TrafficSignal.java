package com.uday.design.trafficsignal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TrafficSignal {

    TrafficLight current;

    Map<TrafficLight, Long> durationMap;

    Integer id;

    long currentStateStartTime;


    public TrafficLight change() {
        current = current.getNext();
        currentStateStartTime = System.currentTimeMillis();
        return current;
    }

    public TrafficSignal(int id, long red, long yellow, long green) {
        this.id = id;
        durationMap = new HashMap<>();
        durationMap.put(TrafficLight.RED, red);
        durationMap.put(TrafficLight.YELLOW, yellow);
        durationMap.put(TrafficLight.GREEN, green);
        current = TrafficLight.RED;
        currentStateStartTime = System.currentTimeMillis();
    }

    public void reset() {
        current = TrafficLight.RED;
        currentStateStartTime = System.currentTimeMillis();
    }

    public void execute() throws InterruptedException {
        TrafficLight first = this.current;
        do {
            System.out.print("Traffic signal: " + this.id + " current light: " + this.current.name());
            TimeUnit.SECONDS.sleep(this.durationMap.get(this.current));
            System.out.println(", Changing after: " + (System.currentTimeMillis() - currentStateStartTime) / 1000);
            this.change();
        }
        while (!(this.current == first));
        System.out.println("Traffic signal: " + this.id + " last light: " + this.current.name());
    }
}
