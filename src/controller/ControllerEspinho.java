package controller;

import java.awt.Rectangle;

import model.Espinho;
import model.Mapa;
import model.Player;
import view.TelaGame;

public class ControllerEspinho implements Runnable {
	
	private TelaGame telagame;
	private Mapa mapa;
	private int FPS=2;
	private int k;
	
	public ControllerEspinho(TelaGame telagame, Mapa mapa) {
		this.telagame = telagame;
		this.mapa = mapa;
	}
	
	public void verificarColisao() {
		for (Espinho espinho: mapa.getEspinhos()) {
			try {
				Rectangle test = new Rectangle(espinho.getPosX(), espinho.getPosY(), espinho.getSprite().width, espinho.getSprite().height);
				for (Player p: telagame.getPlayers()) {
					if (test.intersects(p.getSprite().getRect())) {
						p.setVida(p.getVida()-espinho.getDano());
						telagame.getGame().verificarVidaPlayer(p);
						break;
					}
					
				}
			}catch (NullPointerException e) {}
		}
	}
	
	public void run() {
		while (true) {
			if (telagame.getEspinhos() == null || telagame.getEspinhos().size()==0 || telagame.isMapaTrocou())break;
			for (Espinho espinho: mapa.getEspinhos()) {
				if (espinho == null) {
					break;
				}
			
				switch (k) {
				case 0:
					espinho.getSprite().aparencia=0;
					break;
					
				case 1:
					espinho.getSprite().aparencia=1;
					break;
					
				case 2:
					espinho.getSprite().aparencia=2;
					break;
				
				case 3:
					espinho.getSprite().aparencia=3;
					break;
				}
		}
			
			
			try {
				Thread.sleep(1000/FPS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			k++;
			if (k==4) {
				verificarColisao();
				k=0;
			}
			
		}
		Thread.currentThread().stop();
	}
	
}
