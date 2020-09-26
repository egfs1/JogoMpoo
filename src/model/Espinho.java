package model;

import java.io.IOException;

import view.TelaGame;

public class Espinho {

	private TelaGame telagame;
	private Sprite sprite;
	private int dano;
	private int posX, posY;

	public Espinho(TelaGame telagame,int dano, int posX, int posY) {
		this.dano = dano;
		this.posX = posX;
		this.posY = posY;
		this.telagame = telagame;
		
		try {
			sprite = new Sprite("espinhoSprite.png", 0, 4, 1, posX, posY);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public TelaGame getTelagame() {
		return telagame;
	}

	public void setTelagame(TelaGame telagame) {
		this.telagame = telagame;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
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
