package model;

import java.util.ArrayList;

public class Player{
	
	private String nome;
	private int vida;
	private int dano;
	private Sprite sprite=null;
	public ArrayList<Item>items;

	public Player(String nome) {
		this.nome = nome;
		vida=200;
		dano = 10;
		items = new ArrayList<>();
	}
	
	public void atacar(Inimigo inimigo) {
		inimigo.setVida(inimigo.getVida()-dano);
		
	}
	
	public void addItem(Item item) {
		items.add(item);
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
}
