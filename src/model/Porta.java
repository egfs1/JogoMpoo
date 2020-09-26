package model;


public class Porta {
	
	private Player player;
	private Sprite sprite;
	private ItemChave chave;
	
	public Porta(Sprite sprite,ItemChave chave) {
		this.chave = chave;
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
