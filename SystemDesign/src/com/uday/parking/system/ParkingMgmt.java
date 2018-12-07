package com.uday.parking.system;

public interface ParkingMgmt {
	
	// return true if successful 
	public boolean processEntry(Vehicle vehicle);
	
	boolean processExit(DailyParkingTicket ticket, String paymentType);

}
