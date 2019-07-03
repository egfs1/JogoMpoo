package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Player;
import model.Sprite;
import view.DadosPlayer;
import view.Game;
import view.Pause;

public class ControllerGame extends KeyAdapter {

	Game game;
	Sprite personagem;
	int up, down, left, right;
	static int velocidade=1;
	Player player;
	DadosPlayer dados;
	
	public ControllerGame(Game game,  Sprite personagem, Player player) {
		this.game = game;
		this.personagem = personagem;
		this.player = player;
		game.addKeyListener(new TAdapter());
	}

	public class TAdapter extends KeyAdapter {
		
		int lado=0;
		public void keyPressed(KeyEvent e) {
			
			
			
			if (e.getKeyCode()==KeyEvent.VK_UP){
				if (game.colisao(personagem.posX, personagem.posY-4)) {
					if (game.colisao(personagem.posX+31, personagem.posY-4)){
						personagem.posY -= 4;
					}
				}
				switch (up) {
				case 0:
					personagem.aparencia=0+lado;
					break;
				case 1:
					personagem.aparencia=2+lado;
					break;
				case 2:
					personagem.aparencia=4+lado;
					break;
				case 3:
					personagem.aparencia=6+lado;
	
					break;
				}
				
				if (velocidade == 2) {
					if (game.colisao(personagem.posX, personagem.posY-4)) {
						if (game.colisao(personagem.posX+31, personagem.posY-4)){
							personagem.posY -= 4;
						}
					}
				}
				
				if (up==3) up=0;
				else up++;
				
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN){
				if (game.colisao(personagem.posX, personagem.posY+32)) {
					if (game.colisao(personagem.posX+31, personagem.posY+32)){
						personagem.posY += 4;
					}
				}
				switch (down) {
				case 0:
					personagem.aparencia=0+lado;
					break;
				case 1:
					personagem.aparencia=2+lado;
					break;
				case 2:
					personagem.aparencia=4+lado;
					break;
				case 3:
					personagem.aparencia=6+lado;
	
					break;
				}
				if (velocidade == 2) {
					if (game.colisao(personagem.posX, personagem.posY+32)) {
						if (game.colisao(personagem.posX+31, personagem.posY+32)){
							personagem.posY += 4;
						}
					}
				}
				if (down==3) down=0;
				else down++;
				
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT){
				lado=1;
				
				if (game.colisao(personagem.posX-4, personagem.posY)) {
					if (game.colisao(personagem.posX-4, personagem.posY+31)){
						personagem.posX -= 4;
					}
				}
				switch (left) {
				case 0:
					personagem.aparencia=0+lado;
					break;
				case 1:
					personagem.aparencia=2+lado;
					break;
				case 2:
					personagem.aparencia=4+lado;
					break;
				case 3:
					personagem.aparencia=6+lado;
	
					break;
				}
				if (velocidade == 2) {
					if (game.colisao(personagem.posX-4, personagem.posY)) {
						if (game.colisao(personagem.posX-4, personagem.posY+31)){
							personagem.posX -= 4;
						}
					}
				}
				if (left==3) left=0;
				else left++;
				
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT){
				lado=0;
				if (game.colisao(personagem.posX+32, personagem.posY)) {
					if (game.colisao(personagem.posX+32, personagem.posY+31)){
						personagem.posX += 4;
					}
				}
				switch (right) {
				case 0:
					personagem.aparencia=0+lado;
					break;
				case 1:
					personagem.aparencia=2+lado;
					break;
				case 2:
					personagem.aparencia=4+lado;
					break;
				case 3:
					personagem.aparencia=6+lado;
	
					break;
				}
				if (velocidade == 2) {
					if (game.colisao(personagem.posX+32, personagem.posY)) {
						if (game.colisao(personagem.posX+32, personagem.posY+31)){
							personagem.posX += 4;
						}
					}
				}
				if (right==3) right=0;
				else right++;
			}
			
			if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
				dados = new DadosPlayer(game, player);
				Pause pause = new Pause(player, game, dados);
				
				dados.setLocation(dados.getX()-65, dados.getY()-195);
				
				pause.setVisible(true);
				dados.setVisible(true);
			
			}
			
		}
	}
		
	public void keyReleased(KeyEvent e) {		
	}

	public static int getVelocidade() {
		return velocidade;
	}

	public static void setVelocidade(int velocidade) {
		ControllerGame.velocidade = velocidade;
	}

}
	
