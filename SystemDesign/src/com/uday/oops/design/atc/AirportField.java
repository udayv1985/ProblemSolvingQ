package com.uday.oops.design.atc;

import java.util.Optional;
import java.util.Set;

public class AirportField {
	
	private int id; 
	
	private int airportName; 
	
	private Set<LandingStrip> strips; 
	
	private Set<ParkingSpots> parkingSpots;
	
	public AirportField(int id, int airportName, 
			Set<LandingStrip> strips, Set<ParkingSpots> parkingSpots) {
		super();
		this.id = id;
		this.airportName = airportName;
		this.strips = strips;
		this.parkingSpots = parkingSpots;
	}

	public Optional<LandingStrip> getEmptyLandingStrip(){
		return this.strips.stream().filter(s -> s.getOccupied()==OccupancyStatus.FREE)
				.findFirst();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAirportName() {
		return airportName;
	}

	public void setAirportName(int airportName) {
		this.airportName = airportName;
	}

	public Set<LandingStrip> getStrips() {
		return strips;
	}

	public void setStrips(Set<LandingStrip> strips) {
		this.strips = strips;
	}

	public Set<ParkingSpots> getParkingSpots() {
		return parkingSpots;
	}

	public void setParkingSpots(Set<ParkingSpots> parkingSpots) {
		this.parkingSpots = parkingSpots;
	} 
	
	

}
