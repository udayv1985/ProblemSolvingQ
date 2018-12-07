package com.uday.cards;

import java.util.Random;

public class BlackJack {
	
	CardSet cardSet; 
	
	public void playHand(Player p, double bet){
		p.balance = p.balance - bet;
		PlayerHand ph = new PlayerHand(p,bet);
		int a = new Random().nextInt(5);
		for(int r =1; r<= a;r++){
			cardSet.shuffleCards();
		}
		ph.cards.add(cardSet.cards.removeFirst());
		ph.cards.add(cardSet.cards.removeFirst());
		
	}

}
