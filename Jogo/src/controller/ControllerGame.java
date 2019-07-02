package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import javax.swing.JOptionPane;

import model.Sprite;
import view.Game;

public class ControllerGame extends KeyAdapter {

	Game game;
	Sprite personagem;
	int up, down, left, right;
	
	public ControllerGame(Game game,  Sprite personagem) {
		this.game = game;
		this.personagem = personagem;
		game.addKeyListener(new TAdapter());
	}
	
	public class TAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode()==KeyEvent.VK_UP){
				if (game.colisao(personagem.posX, personagem.posY-4)) {
					if (game.colisao(personagem.posX+15, personagem.posY-4)){
						personagem.posY -= 4;
					}
				}
				switch (up) {
				case 0:
					personagem.aparencia=0;
					break;
				case 1:
					personagem.aparencia=1;
					break;
				case 2:
					personagem.aparencia=2;
					break;
				case 3:
					personagem.aparencia=3;
	
					break;
				}
				if (up==3) up=0;
				else up++;
				
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN){
				if (game.colisao(personagem.posX, personagem.posY+16)) {
					if (game.colisao(personagem.posX+15, personagem.posY+16)){
						personagem.posY += 4;
					}
				}
				switch (down) {
				case 0:
					personagem.aparencia=0;
					break;
				case 1:
					personagem.aparencia=1;
					break;
				case 2:
					personagem.aparencia=2;
					break;
				case 3:
					personagem.aparencia=3;
	
					break;
				}
				if (down==3) down=0;
				else down++;
				
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT){
				if (game.colisao(personagem.posX-4, personagem.posY)) {
					if (game.colisao(personagem.posX-4, personagem.posY+15)){
						personagem.posX -= 4;
					}
				}
				switch (left) {
				case 0:
					personagem.aparencia=0;
					break;
				case 1:
					personagem.aparencia=1;
					break;
				case 2:
					personagem.aparencia=2;
					break;
				case 3:
					personagem.aparencia=3;
	
					break;
				}
				if (left==3) left=0;
				else left++;
				
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT){
				if (game.colisao(personagem.posX+16, personagem.posY)) {
					if (game.colisao(personagem.posX+16, personagem.posY+15)){
						personagem.posX += 4;
					}
				}
				switch (right) {
				case 0:
					personagem.aparencia=0;
					break;
				case 1:
					personagem.aparencia=1;
					break;
				case 2:
					personagem.aparencia=2;
					break;
				case 3:
					personagem.aparencia=3;
	
					break;
				}
				if (right==3) right=0;
				else right++;
			}
			
			if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
				if(JOptionPane.showConfirmDialog(null, "Quer fechar o jogo?")==0) {
					System.exit(0);
				}
				
			}
		}
	}
}
	
