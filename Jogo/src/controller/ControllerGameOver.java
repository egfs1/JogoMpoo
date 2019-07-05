package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import App.App;
import view.TelaGame;
import view.TelaGameOver;
import view.TelaMenu;

public class ControllerGameOver implements ActionListener {

	TelaGameOver tgo;
	TelaGame tg;
	
	
	public ControllerGameOver(TelaGame tg,TelaGameOver tgo) {
		this.tgo = tgo;
		
		this.tgo.getSairButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
