package model;

import java.util.ArrayList;

public class Dados {
	
	private boolean mapa1passou;
	private boolean mapa2passou;
	private ArrayList<Player> players;
	private int n_mapaspassados;
	
	public Dados(ArrayList<Player>players, boolean mapa1passou, boolean mapa2passou, int n_mapaspassados) {
		this.n_mapaspassados = n_mapaspassados;
		this.players = players;
		this.mapa1passou = mapa1passou;
		this.mapa2passou = mapa2passou;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public boolean isMapa1passou() {
		return mapa1passou;
	}

	public void setMapa1passou(boolean mapa1passou) {
		this.mapa1passou = mapa1passou;
	}

	public boolean isMapa2passou() {
		return mapa2passou;
	}

	public void setMapa2passou(boolean mapa2passou) {
		this.mapa2passou = mapa2passou;
	}

	public int getN_mapaspassados() {
		return n_mapaspassados;
	}

	public void setN_mapaspassados(int n_mapaspassados) {
		this.n_mapaspassados = n_mapaspassados;
	}
	
	
}
