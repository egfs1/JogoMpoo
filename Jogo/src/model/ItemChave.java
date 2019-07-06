package model;

import java.util.ArrayList;

import controller.ControllerChave;
import view.TelaGame;

public class ItemChave extends Item {
	
	TelaGame tg;
	Player player;
	Sprite sprite;
	ArrayList<ItemChave>chaves = new ArrayList<>();
	
	public ItemChave(String nome, Sprite sprite, TelaGame tg) {
		super(nome);
		this.tg = tg;
		this.sprite = sprite;
		chaves.add(this);
		
		ControllerChave cc = new ControllerChave(this, tg);
		new Thread(cc).start();
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
	
	public ArrayList<ItemChave> getChaves() {
		return chaves;
	}

	public void setChaves(ArrayList<ItemChave> chaves) {
		this.chaves = chaves;
	}

		
}
