package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaGameOver;

public class ControllerGameOver implements ActionListener {

	private TelaGameOver tgo;
	
	public ControllerGameOver(TelaGameOver tgo) {
		this.tgo = tgo;
		
		this.tgo.getSairButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});		
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
