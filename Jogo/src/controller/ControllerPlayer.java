package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Sprite;
import view.Game;

public class ControllerPlayer extends KeyAdapter{
	Game game;
	Sprite personagem;
	int up, down, left, right;
	
	public ControllerPlayer(Game game,  Sprite personagem) {
		this.game = game;
		this.personagem = personagem;
		game.addKeyListener(new TAdapter());
	}
	
	public class TAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode()== KeyEvent.VK_SHIFT) {
				ControllerGame.setVelocidade(2);
			}
		}
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode()== KeyEvent.VK_SHIFT) {
				ControllerGame.setVelocidade(1);
			}
		}
	}
}
