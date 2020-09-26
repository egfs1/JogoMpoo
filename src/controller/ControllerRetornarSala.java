package controller;

import java.awt.Rectangle;

import model.Mapa;
import model.MapaSala;
import model.Player;
import view.TelaDesafio;
import view.TelaGame;

public class ControllerRetornarSala implements Runnable {
	
	private TelaGame telagame;
	private Rectangle rect;
	private int FPS=10;
	private Mapa mapa;

	public ControllerRetornarSala(Mapa mapa,TelaGame telagame, int posX, int posY, int weight, int height) {
		this.mapa = mapa;
		this.telagame = telagame;
		rect = new Rectangle(posX, posY, weight, height);
	}
	
	public boolean TrocarMapa() {
		for (Player p: telagame.getPlayers()) {
			if (rect.intersects(p.getSprite().getRect())) {
				
				if (mapa.getNome()=="mapa1" && telagame.isMapa1passou()==false) {
					TelaDesafio td1 = new TelaDesafio();
					ControllerDesafio cd1 = new ControllerDesafio(td1,telagame,"mapa1");
					new Thread(cd1).start();
					
				}
				
				if (mapa.getNome()=="mapa2" && telagame.isMapa2passou()==false) {
					TelaDesafio td2 = new TelaDesafio();
					ControllerDesafio cd2 = new ControllerDesafio(td2,telagame,"mapa2");
					new Thread(cd2).start();
					
				}
				
				telagame.setMapaTrocou(true);;
				telagame.setMapaatual(new MapaSala(telagame));
				
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public void run() {
		while (true) {
			if(telagame.getMapaatual()!=mapa)break;
			
			if (TrocarMapa()) {
				break;
			}
			
			try {
				Thread.sleep(1000/FPS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
}
