package com.uday.battleship;

public class BattleBoardSquare {
	
	private int widthId;
	
	private char heightId;

	public BattleBoardSquare(int widthId, char heightId) {
		super();
		this.widthId = widthId;
		this.heightId = heightId;
	}

	public int getHeightId() {
		return heightId;
	}

	public void setHeightId(char heightId) {
		this.heightId = heightId;
	}

	public int getWidthId() {
		return widthId;
	}

	public void setWidthId(char widthId) {
		this.widthId = widthId;
	} 
	
	public String uid(){
		StringBuilder sb = new StringBuilder(widthId);
		sb.append(heightId);
		return sb.toString();
	}

}
