package com.landone;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PokerBud {
	
	private static JFrame frame = null;
	private static CardPanel cards = null;
	
	public static void main(String[] args) {
		
		/* Needs initialization */ 
		if (frame == null) {
			frame = new JFrame("PokerBud");
			cards = new CardPanel();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800, 450);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setResizable(false);
		}
		
		cards.display(frame);
		
		
	}
	
	public static void cardSelected() {
		
		frame.setContentPane(new JPanel());
		frame.setVisible(true);
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		main(null);
		
	}
	
}
