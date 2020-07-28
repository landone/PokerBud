package com.landone;

public enum CardType {
	ACE(0),
	TWO(1),
	THREE(2),
	FOUR(3),
	FIVE(4),
	SIX(5),
	SEVEN(6),
	EIGHT(7),
	NINE(8),
	TEN(9),
	JACK(10),
	QUEEN(11),
	KING(12),
	MAX_CARDS(13);
	
	public int value;
	
	CardType(int val) {
		value = val;
	}
	
	public static CardType toCard(int value) {
		
		if (value < 0 || value > MAX_CARDS.value) {
			return ACE;
		}
		
		return CardType.values()[value];
		
	}
	
	public String toString() {
		
		return toString(value);
		
	}
	
	public static String toString(int val) {
		
		if (val == 0) {
			return "A";
		}
		else if (val > 0 && val < 10) {
			return "" + (val + 1);
		}
		else if (val == 10) {
			return "J";
		}
		else if (val == 11) {
			return "Q";
		}
		else if (val == 12) {
			return "K";
		}
		
		return "";
	}
	
}
