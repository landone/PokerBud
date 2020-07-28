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
	private JButton[] suits = new JButton[4];
	
	
	public CardPanel() {
		
		for (int i = 0; i < 4; i++) {
			suits[i] = new JButton();
		}
		
		try {
			ClassLoader loader = PokerBud.class.getClassLoader();
			ImageIcon image = new ImageIcon(ImageIO.read(loader.getResourceAsStream("resources/spade.png")));
			suits[0].setIcon(image);
			image = new ImageIcon(ImageIO.read(loader.getResourceAsStream("resources/club.png")));
			suits[1].setIcon(image);
			image = new ImageIcon(ImageIO.read(loader.getResourceAsStream("resources/diamond.png")));
			suits[2].setIcon(image);
			image = new ImageIcon(ImageIO.read(loader.getResourceAsStream("resources/heart.png")));
			suits[3].setIcon(image);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < suits.length; i++) {
			panel.add(suits[i]);
			suits[i].addActionListener(this);
		}
		
	}
	
	public void display(JFrame frame) {
		
		frame.setContentPane(panel);
		frame.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		JButton ref = (JButton)e.getSource();
		ref.setEnabled(false);
		
	}

}
