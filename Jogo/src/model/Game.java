package model;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import view.TelaGame;
import view.TelaGameOver;

public class Game {
	
	TelaGame telaGame;
	int posXMatriz, posYMatriz;
	
	public Game(TelaGame telaGame) {
		this.telaGame = telaGame;
	}
	
	public boolean colisao(int posX,int posY) {
			
			posXMatriz = ((posX)/ 32);
			posYMatriz = ((posY)/ 32);
			
			int[][] mtz = telaGame.camada1.carregarMatriz("resources/Camada1.txt");
			
			ArrayList<String> numeros = new ArrayList<>();
			InputStream input = getClass().getClassLoader().getResourceAsStream("resources/Objetos_col.txt");
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
		
		public boolean colisaoInimigo(Rectangle rect) {
			try {
				for (Inimigo i: TelaGame.inimigos) {
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
					for (Player p: TelaGame.players) {
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
					for (Player p: TelaGame.players) {
						if (rect.intersects(p.getSprite().getRect())) {
							return p;
						}
				}
				return null;
			}
			catch (NullPointerException e) {
				return null;
			}
		}
			
		public void verificarVidaPlayer(Player player) {
			try {
				if (player.getVida() <= 0) {
						TelaGameOver tgo = new TelaGameOver(telaGame, player);
						
						player.setSprite(null);
						TelaGame.players.remove(player);
						
						tgo.setVisible(true);
						telaGame.dispose();
				}
					
			}
			
				
			catch (NullPointerException e){}
			}
		
		
		public void atacarInimigo(Player player, Rectangle rect) {
			
			try {
				for (Inimigo i: TelaGame.inimigos) {
					if (rect.intersects(i.getSprite().getRect())) {
						player.atacar(i);
						
//						int x =12;
//						while(x>0) {
//							if (telaGame.game.colisao(i.getSprite().posX-1, i.getSprite().posY))
//								i.getSprite().posX-=1;
//								i.getSprite().setRect(new Rectangle(i.getSprite().posX-1, i.getSprite().posY, i.getSprite().width, i.getSprite().height));
//								x--;
//						}
						
						if (i.getVida() <= 0) {
							i.setSprite(null);
							TelaGame.inimigos.remove(i);
							i=null;
							
						}
						return;
					}
				}
			}
			catch (NullPointerException e) {
			}
		}
}
