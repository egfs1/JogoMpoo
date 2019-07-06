package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Player;
import view.TelaGame;
import view.TelaMenu;

public class ControllerMenu implements ActionListener {

	TelaMenu tm;
	
	public ControllerMenu(TelaMenu tm) {
		this.tm = tm;
		
		this.tm.getComecarButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				tm.setVisible(false);
				Player player = new Player(tm.getNomeField().getText());
				ControllerGame game = new ControllerGame(player);
				
				new Thread(game).start();
//				game.run();	
				tm.dispose();
			}
		});	
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
