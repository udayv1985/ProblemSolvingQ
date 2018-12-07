package com.uday.oops.design.atc;

public class ParkingSpots {
	
	private String bayId;
	
	private String number; 
	
	private OccupancyStatus status;

	public String getBayId() {
		return bayId;
	}

	public void setBayId(String bayId) {
		this.bayId = bayId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public OccupancyStatus getStatus() {
		return status;
	}

	public void setStatus(OccupancyStatus status) {
		this.status = status;
	}

	
	
	

}
