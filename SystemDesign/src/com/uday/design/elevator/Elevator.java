package com.uday.design.elevator;

public class Elevator {
	
	private Integer location = new Integer(0);
	
	private Direction direction = Direction.UP;
	
	private ElevatorState state = ElevatorState.STATIONARY;
	
	private Door door = Door.CLOSED;
	
	private final Integer floorCount = 10;

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public ElevatorState getState() {
		return state;
	}

	public void setState(ElevatorState state) {
		this.state = state;
	}

	public Door getDoor() {
		return door;
	}

	public void setDoor(Door door) {
		this.door = door;
	}

	public Integer getFloorCount() {
		return floorCount;
	}

	public void incrementFloor() {
		this.setLocation(Math.min(this.floorCount,location+1));		
	}
	
	public void decrementFloor() {
		this.setLocation(Math.max(0,location-1));
	}
	
	
	
	

}
