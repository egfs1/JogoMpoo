package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Player;
import model.Sprite;
import view.TelaGame;
import view.TelaPause;

public class ControllerGame extends KeyAdapter {

	TelaGame game;
	Sprite personagem;
	int up, down, left, right;
	Player player;
	
	public ControllerGame(TelaGame game,Sprite personagem, Player player) {
		this.game = game;
		this.personagem = personagem;
		this.player = player;
		game.addKeyListener(new TAdapter());
	}

	public class TAdapter extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			
			
			if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
				
				TelaPause pause = new TelaPause(player);
				pause.setVisible(true);
				
//				game.pauseThread();
				new Thread(pause).start();
				
			}
			
		}
	}
		
	public void keyReleased(KeyEvent e) {		
	}

}
	
