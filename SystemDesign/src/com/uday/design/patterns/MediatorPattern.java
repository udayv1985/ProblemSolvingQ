package com.uday.design.patterns;

import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MediatorPattern {

    public static void main(String[] args){
        Flight airplane = new Flight();
    }
}

class Flight{

    ATC atc;

    String name;

    public Runway requestRunway(){
        return atc.process(this);
    }

    public void clearRunway(){
        atc.recycleRunway(this);
    }

}

class ATC{

    Map<Flight,Runway> map;
    Queue<Runway> runways;

    public Runway process(Flight flight){
        Runway runway = runways.poll();
        return map.put(flight,runway);
    }

    public void recycleRunway(Flight flight) {
        Runway runway = map.get(flight);
        map.remove(flight);
        runways.add(runway);
    }
}

class Runway{

    String name;

    ATC atc;
}

