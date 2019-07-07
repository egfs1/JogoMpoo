package model;

import java.io.File;
import java.io.IOException;

import view.TelaGame;

public class Porta {
	
	TelaGame tg;
	Player player;
	Sprite sprite;
	ItemChave chave;
	
	public Porta(Sprite sprite,ItemChave chave, TelaGame tg) {
		this.chave = chave;
		this.tg = tg;
		this.sprite = sprite;
		
	}

	public ItemChave getChave() {
		return chave;
	}

	public void setChave(ItemChave chave) {
		this.chave = chave;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
}
