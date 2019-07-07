package controller;

import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Player;
import model.Som;
import model.Sprite;
import view.TelaGame;

public class ControllerPlayer extends KeyAdapter{
	
	Som som = new Som();
	Player player;
	TelaGame telagame;
	Sprite personagem;
	static int velocidade=1;
	int up, down, left, right;
	private int lado=0;
	Rectangle test=null;
	
	public ControllerPlayer(TelaGame telagame,Sprite personagem, Player player) {
		this.telagame = telagame;
		this.personagem = personagem;
		this.player = player;
		telagame.addKeyListener(new TAdapter());
	}
	
	public class TAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			
			if (e.getKeyCode()==KeyEvent.VK_W){
				test = new Rectangle(personagem.posX, personagem.posY-4, personagem.width, personagem.height);
				if (telagame.game.colisao(personagem.posX, personagem.posY-4) && telagame.game.colisaoRectangle(test, player.getSprite())) {
					if (telagame.game.colisao(personagem.posX+31, personagem.posY-4) && telagame.game.colisaoRectangle(test, player.getSprite())){
						personagem.posY -= 4;
						personagem.setRect(new Rectangle(personagem.posX, personagem.posY, personagem.width, personagem.height));
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
					test = new Rectangle(personagem.posX, personagem.posY-4, personagem.width, personagem.height);
					if (telagame.game.colisao(personagem.posX, personagem.posY-4) && telagame.game.colisaoRectangle(test, player.getSprite())) {
						if (telagame.game.colisao(personagem.posX+31, personagem.posY-4) && telagame.game.colisaoRectangle(test, player.getSprite())){
							personagem.posY -= 4;
							personagem.setRect(new Rectangle(personagem.posX, personagem.posY, personagem.width, personagem.height));
						}
					}
				}
				
				if (up==3) up=0;
				else up++;
				test=null;
				
			}
			if (e.getKeyCode()==KeyEvent.VK_S){
				test = new Rectangle(personagem.posX, personagem.posY+4, personagem.width, personagem.height);
				if (telagame.game.colisao(personagem.posX, personagem.posY+35) && telagame.game.colisaoRectangle(test, player.getSprite())) {
					if (telagame.game.colisao(personagem.posX+31, personagem.posY+35) && telagame.game.colisaoRectangle(test, player.getSprite())){
						personagem.posY += 4;
						personagem.setRect(new Rectangle(personagem.posX, personagem.posY, personagem.width, personagem.height));
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
					test = new Rectangle(personagem.posX, personagem.posY+4, personagem.width, personagem.height);
					if (telagame.game.colisao(personagem.posX, personagem.posY+35) && telagame.game.colisaoRectangle(test, player.getSprite())) {
						if (telagame.game.colisao(personagem.posX+31, personagem.posY+35) && telagame.game.colisaoRectangle(test, player.getSprite())){
							personagem.posY += 4;
							personagem.setRect(new Rectangle(personagem.posX, personagem.posY, personagem.width, personagem.height));
						}
					}
				}
				if (down==3) down=0;
				else down++;
				test=null;
				
			}
			if (e.getKeyCode()==KeyEvent.VK_A){
				lado=1;
				test = new Rectangle(personagem.posX-4, personagem.posY, personagem.width, personagem.height);
				if (telagame.game.colisao(personagem.posX-4, personagem.posY) && telagame.game.colisaoRectangle(test,player.getSprite())) {
					if (telagame.game.colisao(personagem.posX-4, personagem.posY+31) && telagame.game.colisaoRectangle(test, player.getSprite())){
						personagem.posX -= 4;
						personagem.setRect(new Rectangle(personagem.posX, personagem.posY, personagem.width, personagem.height));
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
					test = new Rectangle(personagem.posX-4, personagem.posY, personagem.width, personagem.height);
					if (telagame.game.colisao(personagem.posX-4, personagem.posY) && telagame.game.colisaoRectangle(test, player.getSprite())) {
						if (telagame.game.colisao(personagem.posX-4, personagem.posY+31) && telagame.game.colisaoRectangle(test, player.getSprite())){
							personagem.posX -= 4;
							personagem.setRect(new Rectangle(personagem.posX, personagem.posY, personagem.width, personagem.height));
						}
					}
				}
				if (left==3) left=0;
				else left++;
				test=null;
				
			}
			if (e.getKeyCode()==KeyEvent.VK_D){
				lado=0;
				test = new Rectangle(personagem.posX+4, personagem.posY, personagem.width, personagem.height);
				if (telagame.game.colisao(personagem.posX+35, personagem.posY) && telagame.game.colisaoRectangle(test,player.getSprite())) {
					if (telagame.game.colisao(personagem.posX+35, personagem.posY+31) && telagame.game.colisaoRectangle(test, player.getSprite())){
						personagem.posX += 4;
						personagem.setRect(new Rectangle(personagem.posX, personagem.posY, personagem.width, personagem.height));
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
					test = new Rectangle(personagem.posX+4, personagem.posY, personagem.width, personagem.height);
					if (telagame.game.colisao(personagem.posX+35, personagem.posY) && telagame.game.colisaoRectangle(test, player.getSprite())) {
						if (telagame.game.colisao(personagem.posX+35, personagem.posY+31) && telagame.game.colisaoRectangle(test, player.getSprite())){
							personagem.posX += 4;
							personagem.setRect(new Rectangle(personagem.posX, personagem.posY, personagem.width, personagem.height));

						}
					}
				}
				if (right==3) right=0;
				else right++;
				test=null;
			}
			
			if (e.getKeyCode()== KeyEvent.VK_SHIFT) {
				setVelocidade(2);
			}
		}
			
			
		public void keyReleased(KeyEvent e) {
			
			if (e.getKeyCode()== KeyEvent.VK_SHIFT) {
				setVelocidade(1);
			}
			
			if (e.getKeyCode()== KeyEvent.VK_E) {
				telagame.game.verificarAbrirPorta(player);
			}
			
			if (e.getKeyCode()== KeyEvent.VK_ENTER) {
//				System.out.println(telagame.cg.contadorAtaque);
				if (lado==0) {
					test = new Rectangle(personagem.posX+15, personagem.posY-4, (personagem.width/2)+4, personagem.height+8);
					if (telagame.game.colisaoInimigo(test)==false && telagame.cg.contadorAtaque==0) {
						telagame.game.atacarInimigo(player, test);
						som.atacarSom();
						telagame.cg.contadorAtaque = 20;
					}
				}
				
				if (lado==1) {
					test = new Rectangle(personagem.posX-4, personagem.posY-4, (personagem.width/2)+4, personagem.height+8);
					if (telagame.game.colisaoInimigo(test)==false && telagame.cg.contadorAtaque==0) {
						telagame.game.atacarInimigo(player, test);
						som.atacarSom();
						telagame.cg.contadorAtaque = 20;
					}
				}
			}
			
			
		}
		
	}
	
	
	public static int getVelocidade() {
		return velocidade;
	}


	public int getLado() {
		return lado;
	}


	public void setLado(int lado) {
		this.lado = lado;
	}


	public static void setVelocidade(int velocidade) {
		ControllerPlayer.velocidade = velocidade;
	}
	
}
