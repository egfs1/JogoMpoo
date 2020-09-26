package controller;

import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Flecha;
import model.Player;
import view.TelaGame;

public class ControllerPlayer extends Thread{
	
	private Player player1, player2=null;
	private TelaGame telagame;
	private static int velocidade=1;
	
	public ControllerPlayer(TelaGame telagame, Player player1) {
		this.telagame = telagame;
		this.player1 = player1;
		telagame.addKeyListener(new TAdapter());
		start();
	}
	
	public ControllerPlayer(TelaGame telagame, Player player1, Player player2) {
		this.telagame = telagame;
		this.player1 = player1;
		this.player2 = player2;
		telagame.addKeyListener(new TAdapter());
		start();
	}
	
	public class TAdapter extends KeyAdapter{
		
		public void keyPressed(KeyEvent e) {
			
				if (e.getKeyCode()==KeyEvent.VK_W){
					player1.moverCima(telagame);
				}
				if (e.getKeyCode()==KeyEvent.VK_S){
					player1.moverBaixo(telagame);
				}
				if (e.getKeyCode()==KeyEvent.VK_A){
					player1.moverEsquerda(telagame);
				}
				if (e.getKeyCode()==KeyEvent.VK_D){
					player1.moverDireita(telagame);
				}
			
				if (e.getKeyCode()==KeyEvent.VK_UP){
					player2.moverCima(telagame);
				}
				if (e.getKeyCode()==KeyEvent.VK_DOWN){
					player2.moverBaixo(telagame);
				}
				if (e.getKeyCode()==KeyEvent.VK_LEFT){
					player2.moverEsquerda(telagame);
				}
				if (e.getKeyCode()==KeyEvent.VK_RIGHT){
					player2.moverDireita(telagame);
				}
		
		}
			
			
		public void keyReleased(KeyEvent e) {
			 
			if (e.getKeyCode()== KeyEvent.VK_SPACE) {
				if (player1.getContadorFlecha() == 0) {
					Flecha f = new Flecha(player1.getLadoFlecha(), player1.getSprite().posX, player1.getSprite().posY);
					ControllerFlecha cf = new ControllerFlecha(f, telagame);
					telagame.getFlechas().add(f);
					new Thread(cf).start();
					player1.setContadorFlecha(40);
				}
			}
			
			if (e.getKeyCode()== KeyEvent.VK_E) {
				telagame.getGame().verificarSairMapa(player1, telagame.getMapaatual().getSair());
				telagame.getGame().verificarAbrirPorta(player1);
				if (telagame.isEhMapaSala())telagame.getGame().verificarEntrarMapa(player1);
				
			}
			
			if (e.getKeyCode()== KeyEvent.VK_ENTER) {
				if (player1.getLado()==0) {
					Rectangle test = new Rectangle(player1.getSprite().posX+15, player1.getSprite().posY-4, (player1.getSprite().width/2)+4, player1.getSprite().height+8);
					if (telagame.getGame().colisaoInimigo(test)==false && player1.getContadorAtaque()==0) {
						telagame.getGame().atacarInimigo(player1, test);
						player1.setContadorAtaque(20);
					}
				}
				
				if (player1.getLado()==1) {
					Rectangle test = new Rectangle(player1.getSprite().posX-4, player1.getSprite().posY-4, (player1.getSprite().width/2)+4, player1.getSprite().height+8);
					if (telagame.getGame().colisaoInimigo(test)==false && player1.getContadorAtaque()==0) {
						telagame.getGame().atacarInimigo(player1, test);
						player1.setContadorAtaque(20);
					}
				}
			}
		}
	}
	
	public void run() {
		while (true) {
			
		}
	}
	
	public static int getVelocidade() {
		return velocidade;
	}

	public static void setVelocidade(int velocidade) {
		ControllerPlayer.velocidade = velocidade;
	}
}
