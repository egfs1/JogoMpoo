package model;

import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class Mapa {
	
	private String nome;
	private boolean aberto=false;
	private Rectangle sair;
	private Camada2 camada0,camada1,camada2;
	private ArrayList<Sprite>sprites = new ArrayList<>();
	private ArrayList<Inimigo>inimigos = new ArrayList<>();
	private ArrayList<Player>players = new ArrayList<>();
	private ArrayList<Porta>portas = new ArrayList<>();
	private ArrayList<ItemChave>chaves = new ArrayList<>();
	private ArrayList<Espinho>espinhos = new ArrayList<>();
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isAberto() {
		return aberto;
	}
	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
	public Rectangle getSair() {
		return sair;
	}
	public void setSair(Rectangle sair) {
		this.sair = sair;
	}
	public Camada2 getCamada0() {
		return camada0;
	}
	public void setCamada0(Camada2 camada0) {
		this.camada0 = camada0;
	}
	public Camada2 getCamada1() {
		return camada1;
	}
	public void setCamada1(Camada2 camada1) {
		this.camada1 = camada1;
	}
	public Camada2 getCamada2() {
		return camada2;
	}
	public void setCamada2(Camada2 camada2) {
		this.camada2 = camada2;
	}
	public ArrayList<Sprite> getSprites() {
		return sprites;
	}
	public void setSprites(ArrayList<Sprite> sprites) {
		this.sprites = sprites;
	}
	public ArrayList<Inimigo> getInimigos() {
		return inimigos;
	}
	public void setInimigos(ArrayList<Inimigo> inimigos) {
		this.inimigos = inimigos;
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	public ArrayList<Porta> getPortas() {
		return portas;
	}
	public void setPortas(ArrayList<Porta> portas) {
		this.portas = portas;
	}
	public ArrayList<ItemChave> getChaves() {
		return chaves;
	}
	public void setChaves(ArrayList<ItemChave> chaves) {
		this.chaves = chaves;
	}
	public ArrayList<Espinho> getEspinhos() {
		return espinhos;
	}
	public void setEspinhos(ArrayList<Espinho> espinhos) {
		this.espinhos = espinhos;
	}
	

}
