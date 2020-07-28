package com.landone;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PokerBud {
	
	private static JFrame frame = null;
	private static CardPanel cards = null;
	private static int numPlayers = -1;
	
	public static void main(String[] args) {
		
		/* Needs initialization */ 
		if (frame == null) {
			
			while (numPlayers < 1 || numPlayers > 30) {
				try {
					numPlayers = Integer.parseInt(JOptionPane.showInputDialog("Amount of players (1-30):"));
				} catch(Exception e) {
					
				}
			}
			
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
	
	public static void cardSelected(Card c) {
		
		if (c != null) {
			System.out.println(c.type.toString() + " of " + c.suit.toString() + "s");
		}
		
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
