package model;

public class Player{
	
	private String nome;
	private int vida;
	private int dano;
	private Sprite sprite=null;

	public Player(String nome) {
		this.nome = nome;
		vida=200;
		dano = 10;

	}
	
	public void atacar(Inimigo inimigo) {
		inimigo.setVida(inimigo.getVida()-dano);
		
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
		if(vida <=200)
			this.vida = vida;
		else this.vida=200;
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
