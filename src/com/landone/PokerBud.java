package com.landone;

import javax.swing.JFrame;

public class PokerBud {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("PokerBud");
		CardPanel cards = new CardPanel();
		cards.display(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 450);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
	}
	
}
