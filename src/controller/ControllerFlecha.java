package controller;

import java.awt.Rectangle;

import model.Flecha;
import model.Inimigo;
import view.TelaGame;

public class ControllerFlecha implements Runnable {
	
	private TelaGame telagame;
	private Flecha flecha;
	private int FPS=120;
	private int contador;
	
	public ControllerFlecha(Flecha flecha, TelaGame telagame) {
		this.flecha = flecha;
		this.telagame = telagame;
	}
	
	public boolean acertou() {
		for (Inimigo i: telagame.getInimigos()) {
			if (flecha.getFlechaSprite().getRect().intersects(i.getSprite().getRect())) {
				i.setVida(i.getVida()-flecha.getDano());
				telagame.getGame().verificarVidaInimigo(i);
				return true;
			}
		}
		return false;
	}
	
	public void mover() {
		
		if (flecha.getAparencia() ==0) {
			flecha.getFlechaSprite().posX-= 10;
		}
		if (flecha.getAparencia()==1) {
			flecha.getFlechaSprite().posY+= 10;
		}
		if (flecha.getAparencia() ==2) {
			flecha.getFlechaSprite().posX+= 10;
		}
		if (flecha.getAparencia() ==3) {
			flecha.getFlechaSprite().posY-= 10;
		}
		flecha.getFlechaSprite().setRect(new Rectangle(flecha.getFlechaSprite().posX, flecha.getFlechaSprite().posY, flecha.getFlechaSprite().width, flecha.getFlechaSprite().height));
	}
	
	public void run() {
		contador = 12;
		while (true) {
			if (contador==0)break;
			
			mover();
			if (acertou())break;
			
			try {
				Thread.sleep(1000/FPS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			contador--;
		}
		telagame.getFlechas().remove(flecha);
		Thread.currentThread().stop(); 
	}

	
}
