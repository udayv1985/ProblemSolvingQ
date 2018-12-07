package com.uday.parking.system;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class ParkingLot implements ParkingMgmt {
	
	Queue<ParkingSpot> vacantSpots; 
	
	Map<ParkingSpot,ParkingTicket> occupiedSlots;
	
	TicketIssuer<DailyParkingTicket> ticketIssuer;
	
	PaymentSrvcFactory paymentSrvcFactory;
	
	public ParkingLot(int maxSpots){
		vacantSpots = new PriorityQueue<>(maxSpots);
		occupiedSlots = new TreeMap<>();
		//ticketIssuer = new TicketIssuer();
	}

	@Override
	public boolean processEntry(Vehicle vehicle) {
		if(!vacantSpots.isEmpty()){
			ParkingSpot spot = vacantSpots.poll();
			DailyParkingTicket t = ticketIssuer.generateTicket(spot, vehicle);
			occupiedSlots.put(spot, t);
			return true;
		}
		return false;
	}

	@Override
	public boolean processExit(DailyParkingTicket ticket, String paymentType) {
		ParkingSpot spot = ticket.getParkingSpot();
		double paymentReq = ticketIssuer.paymentReq(ticket);
		PaymentProcessor payP = PaymentSrvcFactory.getPaymentService(paymentType);
		if(payP.payAmt(paymentReq)){
			occupiedSlots.remove(spot);
			vacantSpots.add(spot);
			ticketIssuer.closeTicket(ticket);
		}
		return false;
	}

}
