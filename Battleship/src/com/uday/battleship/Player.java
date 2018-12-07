package com.uday.battleship;

import java.util.Set;

public class Player {
	
	private String name; 
	
	private Set<BattleShip> battleShips;
	
	private boolean winner = false;
	
	public boolean allBattleShipDestroyed(){
		return this.battleShips.parallelStream().allMatch(b -> b.isDestroyed());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<BattleShip> getBattleShips() {
		return battleShips;
	}

	public void setBattleShips(Set<BattleShip> battleShips) {
		this.battleShips = battleShips;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	
	

}
