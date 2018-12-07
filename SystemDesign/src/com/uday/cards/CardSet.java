package com.uday.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CardSet {
	
	LinkedList<Card> cards;
	
	public CardSet(){
		cards = new LinkedList<>();
		for(int i =1; i<=13; i++){
			cards.add(new Card(Suit.CLUBS,Color.RED,i));
			cards.add(new Card(Suit.DIAMOND,Color.RED,i));
			cards.add(new Card(Suit.HEARTS,Color.RED,i));
			cards.add(new Card(Suit.SPADES,Color.RED,i));
			cards.add(new Card(Suit.CLUBS,Color.BLACK,i));
			cards.add(new Card(Suit.DIAMOND,Color.BLACK,i));
			cards.add(new Card(Suit.HEARTS,Color.BLACK,i));
			cards.add(new Card(Suit.SPADES,Color.BLACK,i));
		}
	}
	
	public LinkedList<Card> shuffleCards(){
		Collections.shuffle(cards);
		return cards;
	}

}
