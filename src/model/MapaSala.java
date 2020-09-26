package model;

import java.io.IOException;

import view.TelaGame;

public class MapaSala extends Mapa {
	
	private Player player1, player2;
	private Sprite personagem1, personagem2;
	
	public MapaSala(TelaGame telagame) {
		setNome("mapaSala");
		
		this.player1 = telagame.getPlayer1();
		this.player2 = telagame.getPlayer2();
		
		setCamada0(new Camada2("MapaSalaCamada0.txt"));
		setCamada1(new Camada2("MapaSalaCamada1.txt"));
		setCamada2(new Camada2("MapaSalaCamada2.txt"));
		
		if (telagame.getPlayers()!=null) {
			
		for (Inimigo i: telagame.getInimigos()) {
			i.setSprite(null);
			i=null;
			continue;
		}
		
		for (Sprite s: telagame.getSprites()) {
			s=null;
			continue;
		}
		for (ItemChave i: telagame.getChaves()) {
			i.setSprite(null);
			i=null;
			continue;
		}
		for (Porta i: telagame.getPortas()) {
			i.setSprite(null);
			i=null;
			continue;
		}
		for (Espinho i: telagame.getEspinhos()) {
			i.setSprite(null);
			i=null;
			continue;
		}
		}
		
		
		try {
			personagem1 = new Sprite("personagemSprite.png", 0, 4, 2, 32*13, 32*4);
			if (player2!=null)personagem2 = new Sprite("personagemSprite.png", 0, 4, 2, 32*15, 32*4);
		
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Não foi possível carregar a Sprite");
		}
		
		getSprites().add(personagem1);
		if (personagem2!=null)getSprites().add(personagem2);
		
		
		player1.setSprite(personagem1);
		if (player2!=null)player2.setSprite(personagem2);
		
		getPlayers().add(player1);
		if (player2!=null)getPlayers().add(player2);
		
		telagame.setCamada0(getCamada0());
		telagame.setCamada1(getCamada1());
		telagame.setCamada2(getCamada2());
		
		telagame.setSprites(getSprites());
		telagame.setChaves(getChaves());
		telagame.setPortas(getPortas());
		telagame.setPlayers(getPlayers());
		telagame.setInimigos(getInimigos());
		telagame.setEspinhos(getEspinhos());
		
		telagame.getCamada0().montarMapa();
		telagame.getCamada1().montarMapa();
		telagame.getCamada2().montarMapa();
		
	}
}