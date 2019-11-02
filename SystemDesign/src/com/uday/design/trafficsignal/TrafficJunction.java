package com.uday.design.trafficsignal;

import com.uday.design.chess.Game;

import java.util.ArrayList;
import java.util.List;

public class TrafficJunction implements Runnable {

    List<TrafficSignal> trafficSignals;

    private static final long RED = 0l;

    private static final long YELLOW = 2l;

    private static final long GREEN = 5l;

    public TrafficJunction(int signals){
        trafficSignals = new ArrayList<>();
        for(int i=0; i<signals; i++){
            trafficSignals.add(new TrafficSignal(i,RED,YELLOW, GREEN));
        }
    }

    public void execute(){

    }

    @Override
    public void run() {
        while(true){
            trafficSignals.forEach(t -> {
                try {
                    t.execute();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void main(String[] args){
        TrafficJunction tj = new TrafficJunction(4);
        tj.run();
    }
}
