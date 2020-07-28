package com.landone;

public enum Suits {
	SPADE(0),
	CLUB(1),
	DIAMOND(2),
	HEART(3),
	MAX_SUITS(4);
	
	public int value;
	
	Suits(int val) {
		value = val;
	}
	
	public static Suits toSuit(int val) {
		
		if (val < 0 || val > MAX_SUITS.value) {
			return SPADE;
		}
		
		return Suits.values()[val];
		
	}
	
	public String toString() {
		
		return toString(value);
		
	}
	
	public static String toString(int val) {
		
		switch(val) {
		case 0:
			return "spade";
		case 1:
			return "club";
		case 2:
			return "diamond";
		case 3:
			return "heart";
		}
		
		return "";
	}
	
}
