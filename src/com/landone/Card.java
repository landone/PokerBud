package com.landone;

public class Card {
	
	public CardType type;
	public Suits suit;
	
	public Card(int type, int suit) {
		
		this.type = CardType.toCard(type);
		this.suit = Suits.toSuit(suit);
		
	}
	
}
