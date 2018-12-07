package com.uday.parking.system;


public interface TicketIssuer <T extends ParkingTicket>{

	static int seq = 1;
	
	public T generateTicket(ParkingSpot parkingSpot, Vehicle vehicle);
	
	public boolean closeTicket(T t);
	
	public Double paymentReq(T t);
}
