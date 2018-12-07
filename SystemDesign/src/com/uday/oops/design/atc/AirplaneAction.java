package com.uday.oops.design.atc;

public enum AirplaneAction {
	LAND(2), TAKE_OFF(4), EMERGENCY(1), PARK(3), FLY(5); 
	
	private AirplaneAction(int priority){
		this.priority = priority; 
	}
	
	private int priority;

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	} 
	
	
}
