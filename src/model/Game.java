package model;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import controller.ControllerGameOver;
import controller.ControllerTelaMensagem;
import view.TelaGame;
import view.TelaGameOver;
import view.TelaMensagem;

public class Game {
	
	private TelaGame telaGame;
	private int posXMatriz, posYMatriz;
	
	public Game(TelaGame telaGame) {
		this.telaGame = telaGame;
	}
	
	public boolean colisao(int posX,int posY) {
			
			posXMatriz = ((posX)/ 32);
			posYMatriz = ((posY)/ 32);
			
			int[][] mtz = telaGame.getCamada1().carregarMatriz(telaGame.getCamada1().getNomeMapaMatriz());
			
			ArrayList<String> numeros = new ArrayList<>();
			InputStream input = getClass().getClassLoader().getResourceAsStream("Objetos_col.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			String linha="";
			int pos= mtz[posYMatriz][posXMatriz];
			
			try {
				linha= br.readLine();
				StringTokenizer token = new StringTokenizer(linha, ",");
				
				while (token.hasMoreElements()) {
					numeros.add(token.nextToken());
				}
				
				for (String n: numeros) {
					if (Integer.parseInt(n) == pos)
						return false;
					
				}
				
			}catch (IOException e) {}	
			
			return true;	
		}
		
	public boolean colisaoRectangle(Rectangle rect, Sprite excecao) {
		try {
			for (Sprite s: telaGame.getSprites()) {
				if (rect.intersects(s.getRect()) && s!=excecao) {
					return false;
				}
			}
			return true;
		}
		catch (NullPointerException e) {
			return true;
		}
	} 
		
		public boolean colisaoInimigo(Rectangle rect) {
			try {
				for (Inimigo i: telaGame.getInimigos()) {
					if (rect.intersects(i.getSprite().getRect())) {
						return false;
					}
				}
				return true;
			}
			catch (NullPointerException e) {
				return true;
			}
		} 
		
		public boolean colisaoPlayer(Rectangle rect) {
			try {
					for (Player p: telaGame.getPlayers()) {
						if (rect.intersects(p.getSprite().getRect())) {
							return false;
						}
				}
				return true;
			}
			catch (NullPointerException e) {
				return true;
			}
		} 
		
		public Player retornarPlayer(Rectangle rect) {
			try {
					for (Player p: telaGame.getPlayers()) {
						if (rect.intersects(p.getSprite().getRect())) {
							return p;
						}
				}
				return null;
			}
			catch (NullPointerException e) {
			}
			return null;
		}
			
		public void verificarVidaPlayer(Player player) {
			try {
				if (player.getVida() <= 0) {
						
						TelaGameOver tgo = new TelaGameOver();
						ControllerGameOver cgo = new ControllerGameOver(tgo);
						
						telaGame.getSprites().remove(player.getSprite());
						telaGame.getPlayers().remove(player);
						player.setSprite(null);
						
						telaGame.dispose();
						telaGame=null;
						tgo.setVisible(true);
				}
					
			}
			
				
			catch (NullPointerException e){}
			}
		
		
		public void verificarVidaInimigo(Inimigo inimigo) {
			try {
				if (inimigo.getVida() <= 0) {
						
						telaGame.getSprites().remove(inimigo.getSprite());
						telaGame.getInimigos().remove(inimigo);
						inimigo.setSprite(null);
				}
					
			}
			
				
			catch (NullPointerException e){}
		}
		
		public void atacarInimigo(Player player, Rectangle rect) {
			
			try {
				for (Inimigo i: telaGame.getInimigos()) {
					if (rect.intersects(i.getSprite().getRect())) {
						player.atacar(i);
						verificarVidaInimigo(i);			
						
						return;
					}
				}
			}
			catch (NullPointerException e) {
			}
		}
		
		public void verificarAbrirPorta(Player player) {
			
			for (Porta porta: telaGame.getPortas()) {
				if (player.interagir().intersects(porta.getSprite().getRect())) {
					for (Item i: player.getItems()) {
						if (i.equals(porta.getChave())) {
							telaGame.getSprites().remove(porta.getSprite());
							telaGame.getPortas().remove(porta);
							player.getItems().remove(i);
							porta.setSprite(null);
							porta=null;
							break;
						}
					}
					if (porta==null)break;
				}
			}
			
		}
		
		public void verificarSairMapa(Player player, Rectangle rect) {
			try {
				if (player.interagir().intersects(rect)) {
						player.getItems().clear();
						
						telaGame.setMapaTrocou(true);;
						telaGame.setMapaatual(new MapaSala(telaGame));;
				}
			}catch (NullPointerException e) {}
		}
		
		public void verificarEntrarMapa(Player player) {
			Rectangle rmp1 = new Rectangle(32*4, 32*5, 32*1, 32*2);
			Rectangle rmp2 = new Rectangle(32*4, 32*9, 32*1, 32*2);
			
				if (rmp1.intersects(player.interagir())) {
						telaGame.setMapaTrocou(false);
						telaGame.setMapaatual(new Mapa1(telaGame));
				}
				
				if (rmp2.intersects(player.interagir())) {
					if(telaGame.isMapa1passou()) {
						telaGame.setMapaTrocou(false);
						telaGame.setMapaatual(new Mapa2(telaGame));;
					}
					else {
						String s = "Passe pelo Mapa 1 e complete o desafio";
						TelaMensagem tm = new TelaMensagem(s);
						ControllerTelaMensagem ctm = new ControllerTelaMensagem(tm);
					}
				}
		}
		
}
