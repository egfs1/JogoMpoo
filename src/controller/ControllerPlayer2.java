package controller;

import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Flecha;
import model.Player;
import view.TelaGame;

public class ControllerPlayer2 extends Thread  {
	
	private Player player2;
	private TelaGame telagame;
	private int up, down, left, right;
	
	public ControllerPlayer2(TelaGame telagame) {
		this.telagame = telagame;
		this.player2 = telagame.getPlayer2();
		telagame.addKeyListener(new TAdapter2());
		start();
	}
	
public class TAdapter2 extends KeyAdapter{
		
		public void keyPressed(KeyEvent e) {
			
			if (e.getKeyCode()==KeyEvent.VK_UP){
				player2.setLadoFlecha(3);
				Rectangle test = new Rectangle(player2.getSprite().posX, player2.getSprite().posY-4, player2.getSprite().width, player2.getSprite().height);
				if (telagame.getGame().colisao(player2.getSprite().posX, player2.getSprite().posY-4) && telagame.getGame().colisaoRectangle(test, player2.getSprite())) {
					if (telagame.getGame().colisao(player2.getSprite().posX+31, player2.getSprite().posY-4)){
						player2.getSprite().posY -= 4;
						player2.getSprite().setRect(new Rectangle(player2.getSprite().posX, player2.getSprite().posY, player2.getSprite().width, player2.getSprite().height));
					}
				}
				switch (up) {
				case 0:
					player2.getSprite().aparencia=0+player2.getLado();
					break;
				case 1:
					player2.getSprite().aparencia=2+player2.getLado();
					break;
				case 2:
					player2.getSprite().aparencia=4+player2.getLado();
					break;
				case 3:
					player2.getSprite().aparencia=6+player2.getLado();
	
					break;
				}
				if (up==3) up=0;
				else up++;
				test=null;
				
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN){
				player2.setLadoFlecha(1);
				Rectangle test = new Rectangle(player2.getSprite().posX, player2.getSprite().posY+4, player2.getSprite().width, player2.getSprite().height);
				if (telagame.getGame().colisao(player2.getSprite().posX, player2.getSprite().posY+35) && telagame.getGame().colisaoRectangle(test, player2.getSprite())) {
					if (telagame.getGame().colisao(player2.getSprite().posX+31, player2.getSprite().posY+35) ){
						player2.getSprite().posY += 4;
						player2.getSprite().setRect(new Rectangle(player2.getSprite().posX, player2.getSprite().posY, player2.getSprite().width, player2.getSprite().height));
					}
				}
				switch (down) {
				case 0:
					player2.getSprite().aparencia=0+player2.getLado();
					break;
				case 1:
					player2.getSprite().aparencia=2+player2.getLado();
					break;
				case 2:
					player2.getSprite().aparencia=4+player2.getLado();
					break;
				case 3:
					player2.getSprite().aparencia=6+player2.getLado();
	
					break;
				}
				if (down==3) down=0;
				else down++;
				test=null;
				
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT){
				player2.setLadoFlecha(0);
				player2.setLado(1);
				Rectangle test = new Rectangle(player2.getSprite().posX-4, player2.getSprite().posY, player2.getSprite().width, player2.getSprite().height);
				if (telagame.getGame().colisao(player2.getSprite().posX-4, player2.getSprite().posY) && telagame.getGame().colisaoRectangle(test,player2.getSprite())) {
					if (telagame.getGame().colisao(player2.getSprite().posX-4, player2.getSprite().posY+31) ){
						player2.getSprite().posX -= 4;
						player2.getSprite().setRect(new Rectangle(player2.getSprite().posX, player2.getSprite().posY, player2.getSprite().width, player2.getSprite().height));
					}
				}
				switch (left) {
				case 0:
					player2.getSprite().aparencia=0+player2.getLado();
					break;
				case 1:
					player2.getSprite().aparencia=2+player2.getLado();
					break;
				case 2:
					player2.getSprite().aparencia=4+player2.getLado();
					break;
				case 3:
					player2.getSprite().aparencia=6+player2.getLado();
	
					break;
				}
				if (left==3) left=0;
				else left++;
				test=null;
				
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT){
				player2.setLadoFlecha(2);
				player2.setLado(0);
				Rectangle test = new Rectangle(player2.getSprite().posX+4, player2.getSprite().posY, player2.getSprite().width, player2.getSprite().height);
				if (telagame.getGame().colisao(player2.getSprite().posX+35, player2.getSprite().posY) && telagame.getGame().colisaoRectangle(test,player2.getSprite())) {
					if (telagame.getGame().colisao(player2.getSprite().posX+35, player2.getSprite().posY+31) ){
						player2.getSprite().posX += 4;
						player2.getSprite().setRect(new Rectangle(player2.getSprite().posX, player2.getSprite().posY, player2.getSprite().width, player2.getSprite().height));
					}
				}
				switch (right) {
				case 0:
					player2.getSprite().aparencia=0+player2.getLado();
					break;
				case 1:
					player2.getSprite().aparencia=2+player2.getLado();
					break;
				case 2:
					player2.getSprite().aparencia=4+player2.getLado();
					break;
				case 3:
					player2.getSprite().aparencia=6+player2.getLado();
	
					break;
				}
				if (right==3) right=0;
				else right++;
				test=null;
			}
		
		}
			
			
		public void keyReleased(KeyEvent e) {
			
			if (e.getKeyCode()== KeyEvent.VK_NUMPAD2) {
				if (player2.getContadorFlecha() ==0) {
					Flecha f = new Flecha(player2.getLadoFlecha(), player2.getSprite().posX, player2.getSprite().posY);
					ControllerFlecha cf = new ControllerFlecha(f, telagame);
					telagame.getFlechas().add(f);
					new Thread(cf).start();
					player2.setContadorFlecha(40);
				}
			}
			
			if (e.getKeyCode()== KeyEvent.VK_NUMPAD3) {
				telagame.getGame().verificarSairMapa(player2, telagame.getMapaatual().getSair());
				telagame.getGame().verificarAbrirPorta(player2);
				if (telagame.isEhMapaSala())telagame.getGame().verificarEntrarMapa(player2);
				
			}
			
			if (e.getKeyCode()== KeyEvent.VK_NUMPAD1) {
				if (player2.getLado()==0) {
					Rectangle test = new Rectangle(player2.getSprite().posX+15, player2.getSprite().posY-4, (player2.getSprite().width/2)+4, player2.getSprite().height+8);
					if (telagame.getGame().colisaoInimigo(test)==false && player2.getContadorAtaque()==0) {
						telagame.getGame().atacarInimigo(player2, test);
						player2.setContadorAtaque(20);
					}
				}
				
				if (player2.getLado()==1) {
					Rectangle test = new Rectangle(player2.getSprite().posX-4, player2.getSprite().posY-4, (player2.getSprite().width/2)+4, player2.getSprite().height+8);
					if (telagame.getGame().colisaoInimigo(test)==false && player2.getContadorAtaque()==0) {
						telagame.getGame().atacarInimigo(player2, test);
						player2.setContadorAtaque(20);
					}
				}
			}
		}
	}
	public void run() {
		while (true) {
			
			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
