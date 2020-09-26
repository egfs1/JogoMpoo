package model;

import java.awt.Rectangle;
import java.io.IOException;

import controller.ControllerChave;
import controller.ControllerEspinho;
import controller.ControllerInimigo;
import controller.ControllerRetornarSala;
import view.TelaGame;

public class Mapa1 extends Mapa {
	
	private Player player, player2;
	private Inimigo inimigo1, inimigo2, inimigo3, inimigo4, inimigo5, inimigo6, inimigo7, inimigo8, inimigo9, inimigo10, inimigo11, inimigo12;
	private ItemChave chave1, chave2;
	private Porta porta1, porta2;
	private Sprite inimigo1Sprite, inimigo2Sprite, inimigo3Sprite, inimigo4Sprite, inimigo5Sprite, inimigo6Sprite, inimigo7Sprite, inimigo8Sprite, inimigo9Sprite, inimigo10Sprite, inimigo11Sprite, inimigo12Sprite,
	 chave1Sprite, chave2Sprite, porta1Sprite, porta2Sprite;
	
	public Mapa1(TelaGame telagame) {
		setNome("mapa1");
		
		this.player = telagame.getPlayer1();
		this.player2 = telagame.getPlayer2();
		
		
		player.getSprite().posX = 32*14;
		player.getSprite().posY = 32*1;
		player.getSprite().setRect(new Rectangle(player.getSprite().posX, player.getSprite().posY, player.getSprite().width, player.getSprite().height));
		
		if (player2!=null) {
			player2.getSprite().posX = 32*15;
			player2.getSprite().posY = 32*1;
			player2.getSprite().setRect(new Rectangle(player2.getSprite().posX, player2.getSprite().posY, player2.getSprite().width, player2.getSprite().height));
		}
		
		setCamada0(new Camada2("Mapa1Camada0.txt"));
		setCamada1(new Camada2("Mapa1Camada1.txt"));
		setCamada2(new Camada2("Mapa1Camada2.txt"));
		
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
		
		try {
			inimigo1Sprite = new Sprite("esqueletoSprite.png", 0, 4, 2, 32*7, 32*4);
			inimigo2Sprite = new Sprite("esqueletoSprite.png", 0, 4, 2, 32*4, 32*4);
			inimigo3Sprite = new Sprite("esqueletoSprite.png", 0, 4, 2, 32*4, 32*10);
			inimigo4Sprite = new Sprite("esqueletoSprite.png", 0, 4, 2, 32*4, 32*11);
			inimigo5Sprite = new Sprite("esqueletoSprite.png", 0, 4, 2, 32*4, 32*16);
			inimigo6Sprite = new Sprite("esqueletoSprite.png", 0, 4, 2, 32*4, 32*17);
			inimigo7Sprite = new Sprite("esqueletoSprite.png", 0, 4, 2, 32*22, 32*4);
			inimigo8Sprite = new Sprite("esqueletoSprite.png", 0, 4, 2, 32*25, 32*4);
			inimigo9Sprite = new Sprite("esqueletoSprite.png", 0, 4, 2, 32*25, 32*10);
			inimigo10Sprite = new Sprite("esqueletoSprite.png", 0, 4, 2, 32*25, 32*11);
			inimigo11Sprite = new Sprite("esqueletoSprite.png", 0, 4, 2, 32*25, 32*16);
			inimigo12Sprite = new Sprite("esqueletoSprite.png", 0, 4, 2, 32*25, 32*17);
			
			chave1Sprite = new Sprite("chaveSprite.png", 0, 4, 1, 32*25, 32*18);
			chave2Sprite = new Sprite("chaveSprite.png", 0, 4, 1, 32*4, 32*18);
			
			porta1Sprite = new Sprite("portaSprite.png", 0, 1, 1, 32*14, 32*11);
			porta2Sprite = new Sprite("portaSprite.png", 1, 2, 1, 32*25, 32*6);
		
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Não foi possível carregar a Sprite");
		}
		
		getSprites().add(player.getSprite());
		if (player2!=null)getSprites().add(player2.getSprite());
		getSprites().add(inimigo1Sprite);
		getSprites().add(inimigo2Sprite);
		getSprites().add(inimigo3Sprite);
		getSprites().add(inimigo4Sprite);
		getSprites().add(inimigo5Sprite);
		getSprites().add(inimigo6Sprite);
		getSprites().add(inimigo7Sprite);
		getSprites().add(inimigo8Sprite);
		getSprites().add(inimigo9Sprite);
		getSprites().add(inimigo10Sprite);
		getSprites().add(inimigo11Sprite);
		getSprites().add(inimigo12Sprite);
		getSprites().add(porta1Sprite);
		getSprites().add(porta2Sprite);
		
		inimigo1 = new Inimigo(50, 15, inimigo1Sprite);
		inimigo2 = new Inimigo(50, 15, inimigo2Sprite);
		inimigo3 = new Inimigo(50, 15, inimigo3Sprite);
		inimigo4 = new Inimigo(50, 15, inimigo4Sprite);
		inimigo5 = new Inimigo(50, 15, inimigo5Sprite);
		inimigo6 = new Inimigo(50, 15, inimigo6Sprite);
		inimigo7 = new Inimigo(50, 15, inimigo7Sprite);
		inimigo8 = new Inimigo(50, 15, inimigo8Sprite);
		inimigo9 = new Inimigo(50, 15, inimigo9Sprite);
		inimigo10 = new Inimigo(50, 15, inimigo10Sprite);
		inimigo11 = new Inimigo(50, 15, inimigo11Sprite);
		inimigo12 = new Inimigo(50, 15, inimigo12Sprite);
		
		chave1 = new ItemChave("Chave Porta Meio", chave1Sprite);
		chave2 = new ItemChave("Chave Porta Direita", chave2Sprite);
		
		porta1 = new Porta(porta1Sprite, chave1);
		porta2 = new Porta(porta2Sprite, chave2);
		
		
		getPlayers().add(player);
		if (player2!=null)getPlayers().add(player2);
		
		getInimigos().add(inimigo1);
		getInimigos().add(inimigo2);
		getInimigos().add(inimigo3);
		getInimigos().add(inimigo4);
		getInimigos().add(inimigo5);
		getInimigos().add(inimigo6);
		getInimigos().add(inimigo7);
		getInimigos().add(inimigo8);
		getInimigos().add(inimigo9);
		getInimigos().add(inimigo10);
		getInimigos().add(inimigo11);
		getInimigos().add(inimigo12);
		
		getChaves().add(chave1);
		getChaves().add(chave2);
		
		getPortas().add(porta1);
		getPortas().add(porta2);
		
		ControllerInimigo ci = new ControllerInimigo(telagame, getInimigos());
		new Thread(ci).start();
		
		ControllerEspinho ce = new ControllerEspinho(telagame, this);
		new Thread(ce).start();
		
		ControllerChave cc = new ControllerChave(getChaves(), telagame);
		new Thread(cc).start();
		
		
		telagame.setCamada0(getCamada0());
		telagame.setCamada1(getCamada1());
		telagame.setCamada2(getCamada2());
		
		telagame.setSprites(getSprites());
		telagame.setChaves(getChaves());
		telagame.setPortas(getPortas());
		telagame.setPlayers(getPlayers());
		telagame.setInimigos(getInimigos());
		telagame.setEspinhos(getEspinhos());
		
		telagame.setCi(null);
		telagame.setCc(null);
		telagame.setCe(null);
		
		telagame.setCi(ci);
		telagame.setCc(cc);
		telagame.setCe(ce);
		
		telagame.getCamada0().montarMapa();
		telagame.getCamada1().montarMapa();
		telagame.getCamada2().montarMapa();
		
		ControllerRetornarSala crs = new ControllerRetornarSala(this, telagame, 32*14, 32*19, 32*2, 32*1);
		new Thread(crs).start();
		
		setSair(new Rectangle(32*14, 32*0, 32*2, 32*1));
		
	}
}
