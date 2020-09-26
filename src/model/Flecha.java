package model;

import java.awt.Rectangle;
import java.io.IOException;

public class Flecha {
	
	private Sprite flechaSprite;
	private int dano=5;
	private int aparencia;
	private int posX, posY;
	
	public Flecha(int aparencia, int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.aparencia = aparencia;
		
		try {
			flechaSprite = new Sprite("flecha.png", aparencia, 4, 1, posX, posY);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		flechaSprite.setRect(new Rectangle(posX, posY, 17, 6));
		
	}

	public Sprite getFlechaSprite() {
		return flechaSprite;
	}

	public void setFlechaSprite(Sprite flechaSprite) {
		this.flechaSprite = flechaSprite;
	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getAparencia() {
		return aparencia;
	}

	public void setAparencia(int aparencia) {
		this.aparencia = aparencia;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
}
