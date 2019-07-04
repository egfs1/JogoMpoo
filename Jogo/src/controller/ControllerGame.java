package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Player;
import model.Sprite;
import view.TelaDadosPlayer;
import view.TelaGame;
import view.TelaPause;

public class ControllerGame extends KeyAdapter {

	TelaGame game;
	Sprite personagem;
	int up, down, left, right;
	Player player;
	TelaDadosPlayer dados;
	
	public ControllerGame(TelaGame game,Sprite personagem, Player player) {
		this.game = game;
		this.personagem = personagem;
		this.player = player;
		game.addKeyListener(new TAdapter());
	}

	public class TAdapter extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			
			
			if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
				dados = new TelaDadosPlayer(game, player);
				TelaPause pause = new TelaPause(player, game, dados);
				
				dados.setLocation(dados.getX()-65, dados.getY()-195);
				
				pause.setVisible(true);
				dados.setVisible(true);
			
			}
			
		}
	}
		
	public void keyReleased(KeyEvent e) {		
	}

}
	
