package com.uday.oops.design.atc;

public class LandingStrip {
	
	private String name; 
	
	private OccupancyStatus occupied;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OccupancyStatus getOccupied() {
		return occupied;
	}

	public void setOccupied(OccupancyStatus occupied) {
		this.occupied = occupied;
	}

}
