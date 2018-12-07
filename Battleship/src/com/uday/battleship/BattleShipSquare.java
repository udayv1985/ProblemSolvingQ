package com.uday.battleship;

public class BattleShipSquare extends BattleBoardSquare {
	
	public BattleShipSquare(int widthId, char heightId) {
		super(widthId, heightId);
		hitCount = 0;
		destroyed = false;
	}

	private int hitCount = 0;
	
	private boolean destroyed = false;

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public void incrementHitCount() {
		this.hitCount++;
		
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}	
	
	

}
