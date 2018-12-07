package com.uday.design.elevator;

public abstract class Request implements Comparable<Request> {
	
	private Integer floor;

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	} 
	
	@Override
	public int compareTo(Request o) {
		return (this.floor-o.getFloor());
	}

}
