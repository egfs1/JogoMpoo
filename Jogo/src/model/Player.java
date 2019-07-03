
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


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setVida(int vida) {
		this.vida = vida;
	}


	public void setXp(int xp) {
		this.xp = xp;
	}


	public void setLevel(int level) {
		this.level = level;
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
