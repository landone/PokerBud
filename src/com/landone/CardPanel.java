package com.landone;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardPanel implements ActionListener {
	
	private JPanel panel = new JPanel();
	private JButton[] suits = new JButton[Suits.MAX_SUITS.value];
	private JButton[] cards = new JButton[Cards.MAX_CARDS.value];
	private int[] selected = new int[2];//[card, suit]
	private JButton[] options = new JButton[2]; //Cancel, Continue
	
	
	public CardPanel() {
		
		selected[0] = -1;
		selected[1] = -1;
		
		ClassLoader loader = PokerBud.class.getClassLoader();
		for (int i = 0; i < Suits.MAX_SUITS.value; i++) {
			
			suits[i] = new JButton();
			try {
				ImageIcon image = new ImageIcon(ImageIO.read(loader.getResourceAsStream("resources/" + Suits.toString(i) + ".png")));
				suits[i].setIcon(image);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			panel.add(suits[i]);
			suits[i].addActionListener(this);
			
		}
		
		for (int i = 0; i < Cards.MAX_CARDS.value; i++) {
			
			cards[i] = new JButton(Cards.toString(i));
			panel.add(cards[i]);
			cards[i].addActionListener(this);
			
		}
		
		options[0] = new JButton("Cancel");
		panel.add(options[0]);
		options[0].addActionListener(this);
		options[1] = new JButton("Continue");
		panel.add(options[1]);
		options[1].addActionListener(this);
		
	}
	
	public void display(JFrame frame) {
		
		selected[0] = -1;
		selected[1] = -1;
		setEnabledAll(true);
		frame.setContentPane(panel);
		frame.setVisible(true);
		
	}
	
	private void setEnabledAll(boolean set) {
		for (int i = 0; i < suits.length; i++) {
			suits[i].setEnabled(set);
		}
		for (int i = 0; i < cards.length; i++) {
			cards[i].setEnabled(set);
		}
		for (int i = 0; i < options.length; i++) {
			options[i].setEnabled(set);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		JButton ref = (JButton)e.getSource();
		
		if (ref == options[0]) {
			//Cancel
			setEnabledAll(false);
			PokerBud.cardSelected();
			return;
		}
		else if (ref == options[1]) {
			if (selected[0] == -1 || selected[1] == -1) {
				System.out.println("No card selected");
			}
			else {
				//Continue
				setEnabledAll(false);
				PokerBud.cardSelected();
			}
			return;
		}
		
		ref.setEnabled(false);
		int isSuit = 0;
		int index = -1;
		for (int i = 0; i < Suits.MAX_SUITS.value; i++) {
			if (suits[i] == ref) {
				isSuit = 1;
				index = i;
				break;
			}
		}
		for (int i = 0; i < Cards.MAX_CARDS.value; i++) {
			if (cards[i] == ref) {
				index = i;
				break;
			}
		}
		
		JButton[] arr = (isSuit == 0 ? cards : suits);
		if (selected[isSuit] != -1) {
			arr[selected[isSuit]].setEnabled(true);
		}
		selected[isSuit] = index;
		
	}

}
