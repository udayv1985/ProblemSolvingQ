package com.uday.battleship;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BattleShip {
	
	private int height; 
	
	private int width; 
	
	private int hitsReq = 1;
	
	private Set<BattleShipSquare> squares;
	
	public boolean processHit(BattleBoardSquare sq){
		Optional<BattleShipSquare> obs = squares.stream().filter(
				square -> square.uid().equals(sq.uid())).findAny();
		if(obs.isPresent()){
			obs.get().incrementHitCount();
			checkForEviction(obs.get());
			return true;
		}
		return false;
	}

	private void checkForEviction(BattleShipSquare battleShipSquare) {
		if(battleShipSquare.getHitCount() == this.hitsReq){
			this.getSquares().remove(battleShipSquare);
		}
	}
	
	public Set<BattleShipSquare> initSquares(String startingSq){
		int w = startingSq.charAt(0);
		char h = startingSq.charAt(1);
		if(null==squares){
			squares = new HashSet<>();
		}
		for(int i = w; i < w+width; i++){
			for(char j = h; j < h+height ; j++){
				squares.add(new BattleShipSquare(i,j));
			}
		}
		return squares;
	}
	
	public boolean isDestroyed(){
		return this.getNonDestroyedSquares().isEmpty();
	}
	
	public Set<BattleShipSquare> getNonDestroyedSquares(){
		return this.squares.parallelStream().filter(
				sq -> !sq.isDestroyed()).collect(Collectors.toSet());
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Set<BattleShipSquare> getSquares() {
		return squares;
	}

	public void setSquares(Set<BattleShipSquare> squares) {
		this.squares = squares;
	}
	
}
