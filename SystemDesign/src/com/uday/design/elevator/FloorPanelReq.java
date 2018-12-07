package com.uday.design.elevator;

public class FloorPanelReq extends Request  {
	
	public FloorPanelReq(int floor, Direction dir) {
		this.direction = dir;
		this.setFloor(floor);
	}

	private Direction direction;

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	} 
	
	

}
