package model;

import java.awt.Rectangle;
import java.io.IOException;

import controller.ControllerChave;
import controller.ControllerEspinho;
import controller.ControllerInimigo;
import controller.ControllerRetornarSala;
import view.TelaGame;

public class Mapa2 extends Mapa {
	
	private Espinho espinho1, espinho2, espinho3, espinho4,espinho5,espinho6,espinho7,espinho8,espinho9,espinho10,espinho11,espinho12,espinho13,espinho14,espinho15,espinho16,espinho17,espinho18,espinho19,espinho20;
	private Player player, player2;
	private Inimigo inimigo1, inimigo2, inimigo3, inimigo4;
	private ItemChave chave1, chave2;
	private Porta porta1, porta2;
	private Sprite inimigo1Sprite, inimigo2Sprite, inimigo3Sprite, inimigo4Sprite, chave1Sprite, chave2Sprite, porta1Sprite, porta2Sprite;
	
	public Mapa2(TelaGame telagame) {
		setNome("mapa2");
		
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
		
		setCamada0(new Camada2("Mapa2Camada0.txt"));
		setCamada1(new Camada2("Mapa2Camada1.txt"));
		setCamada2(new Camada2("Mapa2Camada2.txt"));
		
		
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
			inimigo1Sprite = new Sprite("esqueletoSprite.png", 0, 4, 2, 32*25, 32*9);
			inimigo2Sprite = new Sprite("esqueletoSprite.png", 0, 4, 2, 32*25, 32*11);
			inimigo3Sprite = new Sprite("esqueletoSprite.png", 0, 4, 2, 32*25, 32*14);
			inimigo4Sprite = new Sprite("esqueletoSprite.png", 0, 4, 2, 32*25, 32*16);
			
			chave1Sprite = new Sprite("chaveSprite.png", 0, 4, 1, 32*9, 32*15);
			chave2Sprite = new Sprite("chaveSprite.png", 0, 4, 1, 32*20, 32*15);
			
			porta1Sprite = new Sprite("portaSprite.png", 1, 2, 1, 32*25, 32*6);
			porta2Sprite = new Sprite("portaSprite.png", 0, 1, 1, 32*14, 32*9);
		
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Não foi possível carregar a Sprite");
		}
		
		espinho1 = new Espinho(telagame, 100, 32*2, 32*6);
		espinho2 = new Espinho(telagame, 100, 32*2, 32*7);
		espinho3 = new Espinho(telagame, 100, 32*2, 32*8);
		espinho4 = new Espinho(telagame, 100, 32*2, 32*10);
		espinho5 = new Espinho(telagame, 100, 32*2, 32*11);
		espinho6 = new Espinho(telagame, 100, 32*2, 32*12);
		espinho7 = new Espinho(telagame, 100, 32*2, 32*14);
		espinho8 = new Espinho(telagame, 100, 32*2, 32*15);
		espinho9 = new Espinho(telagame, 100, 32*2, 32*16);
		espinho10 = new Espinho(telagame, 100, 32*2, 32*17);
		espinho11 = new Espinho(telagame, 100, 32*5, 32*17);
		espinho12 = new Espinho(telagame, 100, 32*5, 32*16);
		espinho13 = new Espinho(telagame, 100, 32*5, 32*15);
		espinho14 = new Espinho(telagame, 100, 32*5, 32*14);
		espinho15 = new Espinho(telagame, 100, 32*5, 32*12);
		espinho16 = new Espinho(telagame, 100, 32*5, 32*11);
		espinho17 = new Espinho(telagame, 100, 32*5, 32*10);
		espinho18 = new Espinho(telagame, 100, 32*5, 32*8);
		espinho19 = new Espinho(telagame, 100, 32*5, 32*7);
		espinho20 = new Espinho(telagame, 100, 32*6, 32*7);
		
		getSprites().add(player.getSprite());
		if (player2!=null)getSprites().add(player2.getSprite());
		getSprites().add(inimigo1Sprite);
		getSprites().add(inimigo2Sprite);
		getSprites().add(inimigo3Sprite);
		getSprites().add(inimigo4Sprite);
		getSprites().add(porta1Sprite);
		getSprites().add(porta2Sprite);
		
		inimigo1 = new Inimigo(50, 15, inimigo1Sprite);
		inimigo2 = new Inimigo(50, 15, inimigo2Sprite);
		inimigo3 = new Inimigo(50, 15, inimigo3Sprite);
		inimigo4 = new Inimigo(50, 15, inimigo4Sprite);
		
		chave1 = new ItemChave("Chave Porta Direita", chave1Sprite);
		chave2 = new ItemChave("Chave Porta Meio", chave2Sprite);
		
		porta1 = new Porta(porta1Sprite, chave1);
		porta2 = new Porta(porta2Sprite, chave2);
		
		
		getPlayers().add(player);
		if (player2!=null)getPlayers().add(player2);
		
		getInimigos().add(inimigo1);
		getInimigos().add(inimigo2);
		getInimigos().add(inimigo3);
		getInimigos().add(inimigo4);
		
		getChaves().add(chave1);
		getChaves().add(chave2);
		
		getPortas().add(porta1);
		getPortas().add(porta2);
		
		getEspinhos().add(espinho1);
		getEspinhos().add(espinho2);
		getEspinhos().add(espinho3);
		getEspinhos().add(espinho4);
		getEspinhos().add(espinho5);
		getEspinhos().add(espinho6);
		getEspinhos().add(espinho7);
		getEspinhos().add(espinho8);
		getEspinhos().add(espinho9);
		getEspinhos().add(espinho10);
		getEspinhos().add(espinho11);
		getEspinhos().add(espinho12);
		getEspinhos().add(espinho13);
		getEspinhos().add(espinho14);
		getEspinhos().add(espinho15);
		getEspinhos().add(espinho16);
		getEspinhos().add(espinho17);
		getEspinhos().add(espinho18);
		getEspinhos().add(espinho19);
		getEspinhos().add(espinho20);
				
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
