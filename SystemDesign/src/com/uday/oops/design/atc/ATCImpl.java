package com.uday.oops.design.atc;

import java.util.*;

public class ATCImpl implements AirTrafficController {
	
	Queue<Airplane> reqQ = new PriorityQueue<>(new AirplaneComparator());
	
	private AirportField airportField;
	
	@Override
	public void process(AirplaneAction request) {
		
		while(!reqQ.isEmpty()){
			AirplaneAction req = reqQ.poll().getRequest();
			switch (req) {
			case EMERGENCY :{
				Optional<LandingStrip> strip = airportField.getEmptyLandingStrip();
				if(strip.isPresent()){
					// assign to plane
				}
				break;
			}
			default:
				break;
			
			}
				
		}
		
	}

	@Override
	public void call(Airplane airplane) {
		reqQ.add(airplane);
		
	}
	
	class AirplaneComparator implements Comparator<Airplane>{

		@Override
		public int compare(Airplane o1, Airplane o2) {
			
			return (o1.getRequest().getPriority()-o2.getRequest().getPriority());
		}
		
	}
	
	public static void main(String [] args){
		ATCImpl a = new ATCImpl();
		Airplane a1 = new Airplane();
		a1.setRequest(AirplaneAction.EMERGENCY);
		Airplane a2 = new Airplane();
		a2.setRequest(AirplaneAction.LAND);
		a.reqQ.add(a1);
		a.reqQ.add(a2);
		System.out.println(a.reqQ.poll().getRequest());
	}

}
