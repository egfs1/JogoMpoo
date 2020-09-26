package model;

import java.awt.Rectangle;
import java.util.ArrayList;

import view.TelaGame;

public class Player{
	
	private String nome;
	private int vida;
	private int dano;
	private Sprite sprite=null;
	private ArrayList<Item>items;
	private int contadorAtaque, contadorFlecha;
	private int up, down, left, right;
	private int lado=0;
	private int ladoFlecha=2;

	public Player(String nome) {
		this.nome = nome;
		vida=200;
		dano = 10;
		contadorAtaque=0;
		contadorFlecha=0;
		items = new ArrayList<>();
	}
	
	public void atacar(Inimigo inimigo) {
		inimigo.setVida(inimigo.getVida()-dano);
		
	}
	
	public Rectangle interagir() {
		Rectangle rect = new Rectangle(sprite.posX-1, sprite.posY-1, sprite.width+2, sprite.height+2);
		return rect;
	}
	
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void moverCima(TelaGame telagame) {
		ladoFlecha=3;
		Rectangle test = new Rectangle(sprite.posX, sprite.posY-4, sprite.width, sprite.height);
		if (telagame.getGame().colisao(sprite.posX, sprite.posY-4) && telagame.getGame().colisaoRectangle(test, sprite)) {
			if (telagame.getGame().colisao(sprite.posX+31, sprite.posY-4)){
				sprite.posY -= 4;
				sprite.setRect(new Rectangle(sprite.posX, sprite.posY, sprite.width, sprite.height));
			}
		}
		switch (up) {
		case 0:
			sprite.aparencia=0+lado;
			break;
		case 1:
			sprite.aparencia=2+lado;
			break;
		case 2:
			sprite.aparencia=4+lado;
			break;
		case 3:
			sprite.aparencia=6+lado;

			break;
		}
		if (up==3) up=0;
		else up++;
		test=null;
	}
	
	public void moverBaixo(TelaGame telagame) {
		ladoFlecha=1;
		Rectangle test = new Rectangle(sprite.posX, sprite.posY+4, sprite.width, sprite.height);
		if (telagame.getGame().colisao(sprite.posX, sprite.posY+35) && telagame.getGame().colisaoRectangle(test, sprite)) {
			if (telagame.getGame().colisao(sprite.posX+31, sprite.posY+35)){
				sprite.posY += 4;
				sprite.setRect(new Rectangle(sprite.posX, sprite.posY, sprite.width, sprite.height));
			}
		}
		switch (down) {
		case 0:
			sprite.aparencia=0+lado;
			break;
		case 1:
			sprite.aparencia=2+lado;
			break;
		case 2:
			sprite.aparencia=4+lado;
			break;
		case 3:
			sprite.aparencia=6+lado;

			break;
		}
		if (down==3) down=0;
		else down++;
		test=null;
		
	}
	
	public void moverEsquerda(TelaGame telagame) {
		ladoFlecha=0;
		lado=1;
		Rectangle test = new Rectangle(sprite.posX-4, sprite.posY, sprite.width, sprite.height);
		if (telagame.getGame().colisao(sprite.posX-4, sprite.posY) && telagame.getGame().colisaoRectangle(test, sprite)) {
			if (telagame.getGame().colisao(sprite.posX-4, sprite.posY+31)){
				sprite.posX -= 4;
				sprite.setRect(new Rectangle(sprite.posX, sprite.posY, sprite.width, sprite.height));
			}
		}
		switch (left) {
		case 0:
			sprite.aparencia=0+lado;
			break;
		case 1:
			sprite.aparencia=2+lado;
			break;
		case 2:
			sprite.aparencia=4+lado;
			break;
		case 3:
			sprite.aparencia=6+lado;

			break;
		}
		if (left==3) left=0;
		else left++;
		test=null;
		
	}
	
	public void moverDireita(TelaGame telagame) {
		ladoFlecha=2;
		lado=0;
		Rectangle test = new Rectangle(sprite.posX+4, sprite.posY, sprite.width, sprite.height);
		if (telagame.getGame().colisao(sprite.posX+35, sprite.posY) && telagame.getGame().colisaoRectangle(test, sprite)) {
			if (telagame.getGame().colisao(sprite.posX+35, sprite.posY+31)){
				sprite.posX += 4;
				sprite.setRect(new Rectangle(sprite.posX, sprite.posY, sprite.width, sprite.height));
			}
		}
		switch (right) {
		case 0:
			sprite.aparencia=0+lado;
			break;
		case 1:
			sprite.aparencia=2+lado;
			break;
		case 2:
			sprite.aparencia=4+lado;
			break;
		case 3:
			sprite.aparencia=6+lado;

			break;
		}
		if (right==3) right=0;
		else right++;
		test=null;
		
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public String getNome() {
		return nome;
	}


	public int getVida() {
		return vida;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setVida(int vida) {
		if(vida <=200 && vida >= 0)
			this.vida = vida;
		if (vida > 200)
			this.vida =200;
	
		if (vida <0 )
			this.vida =0;
	}

	public int getDano() {
		return dano;
	}


	public void setDano(int dano) {
		this.dano = dano;
	}
	
	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public int getContadorAtaque() {
		return contadorAtaque;
	}

	public void setContadorAtaque(int contadorAtaque) {
		this.contadorAtaque = contadorAtaque;
	}

	public int getContadorFlecha() {
		return contadorFlecha;
	}

	public void setContadorFlecha(int contadorFlecha) {
		this.contadorFlecha = contadorFlecha;
	}

	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}

	public int getLadoFlecha() {
		return ladoFlecha;
	}

	public void setLadoFlecha(int ladoFlecha) {
		this.ladoFlecha = ladoFlecha;
	}
	
}
