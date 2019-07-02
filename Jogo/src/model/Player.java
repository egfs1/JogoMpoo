package model;

public class Player {
	private String nome;
	private int vida;
	private int xp;
	private int level;
	
	
	public String getNome() {
		return nome;
	}


	public int getVida() {
		return vida;
	}


	public int getXp() {
		return xp;
	}


	public int getLevel() {
		return level;
	}


	public Player(String nome) {
		this.nome = nome;
		vida=200;
		xp=0;
		level=1;
	
	}
	
}
