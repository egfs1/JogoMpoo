package model;

// nem sei se isso eh um esqueleto
public class Inimigo{
	
	private int vida;
	private int dano;
	private Sprite sprite;

	public Inimigo(int vida, int dano, Sprite sprite) {
		this.vida = vida;
		this.dano = dano;
		this.sprite = sprite;
		
	}

	public void atacar(Player player) {
		player.setVida(player.getVida()-dano);
	}
	
	
	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public int getVida() {
		return vida;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public int getDano() {
		return dano;
	}
	
	public void setDano(int dano) {
		this.dano = dano;
	}
	
	

	
	
	
}
