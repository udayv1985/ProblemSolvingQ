package com.uday.cards;

import java.util.ArrayList;
import java.util.List;

public class PlayerHand {
	
	Player player; 
	
	Double amt;
	
	List<Card> cards;

	public PlayerHand(Player player, Double amt) {
		super();
		this.player = player;
		this.amt = amt;
		this.cards = new ArrayList<>();
	}
	
	

}
