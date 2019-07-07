package controller;

import java.awt.Rectangle;
import java.util.Random;

import model.Inimigo;
import model.Player;
import view.TelaGame;


public class ControllerInimigo implements Runnable {
	
	Random random = new Random();
	TelaGame telagame;
	Inimigo inimigo;
	int up, down, left, right;
	static int lado=0;
	Rectangle test=null;
	int FPS = 10;
	int contadorAndar, contadorAtacar;
	
	
	public ControllerInimigo(TelaGame telagame,Inimigo inimigo) {
		this.inimigo = inimigo;
		this.telagame = telagame;
	}
	
	public boolean moverPlayer(Inimigo inimigo) throws InterruptedException {
		test = new Rectangle(inimigo.getSprite().posX-30, inimigo.getSprite().posY-30, inimigo.getSprite().width+60, inimigo.getSprite().height+60);
		if (telagame.game.colisaoPlayer(test)==false) {
			
			Player p = telagame.game.retornarPlayer(test);
			Rectangle pRect = p.getSprite().getRect();
			
			Rectangle testUp = new Rectangle(inimigo.getSprite().posX-31, inimigo.getSprite().posY-32, inimigo.getSprite().width+64, 32);
			Rectangle testDown = new Rectangle(inimigo.getSprite().posX-31, inimigo.getSprite().posY+32, inimigo.getSprite().width+64, 32);
			Rectangle testLeft = new Rectangle(inimigo.getSprite().posX-31, inimigo.getSprite().posY-31, 32, inimigo.getSprite().height+64);
			Rectangle testRight = new Rectangle(inimigo.getSprite().posX+31, inimigo.getSprite().posY-31, 32, inimigo.getSprite().height+64);

			Rectangle attackUp = new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY-4, inimigo.getSprite().width, 4);
			Rectangle attackDown = new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY+32, inimigo.getSprite().width, 4);
			Rectangle attackLeft = new Rectangle(inimigo.getSprite().posX-4, inimigo.getSprite().posY, 4, inimigo.getSprite().height);
			Rectangle attackRight = new Rectangle(inimigo.getSprite().posX+31, inimigo.getSprite().posY, 4, inimigo.getSprite().height);
			
			
			if (pRect.intersects(testUp)) {
				if (moverCima(inimigo)==false ) {
						if (pRect.intersects(attackUp) && contadorAtacar==0) {
						inimigo.atacar(p);
						telagame.game.verificarVidaPlayer(p);
						contadorAtacar=5;
						}
					}
				}
			if (pRect.intersects(testDown))
				if (moverBaixo(inimigo)==false) {
					if (pRect.intersects(attackDown) && contadorAtacar==0) {
						inimigo.atacar(p);
						telagame.game.verificarVidaPlayer(p);
						contadorAtacar=5;
						}
				}
			if (pRect.intersects(testLeft))
				if (moverEsquerda(inimigo)==false) {
					if (pRect.intersects(attackLeft) && contadorAtacar==0) {
						inimigo.atacar(p);
						telagame.game.verificarVidaPlayer(p);
						contadorAtacar=5;
						}
				}
			if (pRect.intersects(testRight))
				if (moverDireita(inimigo)==false) {
					if (pRect.intersects(attackRight) && contadorAtacar==0) {
						inimigo.atacar(p);
						telagame.game.verificarVidaPlayer(p);
						contadorAtacar=5;
						}
				}
					
			
			return true;
		}
		return false;
		
	}
	
	
	public boolean moverCima(Inimigo inimigo) {
		test = new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY-4, inimigo.getSprite().width, inimigo.getSprite().height);
		if (telagame.game.colisao(inimigo.getSprite().posX, inimigo.getSprite().posY-4) && telagame.game.colisaoRectangle(test, inimigo.getSprite())) {
			if (telagame.game.colisao(inimigo.getSprite().posX+31, inimigo.getSprite().posY-4) && telagame.game.colisaoRectangle(test, inimigo.getSprite())){
				inimigo.getSprite().posY -= 4;
				inimigo.getSprite().setRect(new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY, inimigo.getSprite().width, inimigo.getSprite().height));
			
				switch (up) {
				case 0:
					inimigo.getSprite().aparencia=0+lado;
					break;
				case 1:
					inimigo.getSprite().aparencia=2+lado;
					break;
				case 2:
					inimigo.getSprite().aparencia=4+lado;
					break;
				case 3:
					inimigo.getSprite().aparencia=6+lado;
					break;
					
				}
				if (up==3) up=0;
				else up++;
				test=null;
				return true;
			}
		}
		return false;
		
	}
	public boolean moverBaixo(Inimigo inimigo) {
		test = new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY+4, inimigo.getSprite().width, inimigo.getSprite().height);
		if (telagame.game.colisao(inimigo.getSprite().posX, inimigo.getSprite().posY+35)&& telagame.game.colisaoRectangle(test, inimigo.getSprite())) {
			if (telagame.game.colisao(inimigo.getSprite().posX+31, inimigo.getSprite().posY+35)&& telagame.game.colisaoRectangle(test, inimigo.getSprite())){
				inimigo.getSprite().posY += 4;
				inimigo.getSprite().setRect(new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY, inimigo.getSprite().width, inimigo.getSprite().height));
				
				switch (down) {
				case 0:
					inimigo.getSprite().aparencia=0+lado;
					break;
				case 1:
					inimigo.getSprite().aparencia=2+lado;
					break;
				case 2:
					inimigo.getSprite().aparencia=4+lado;
					break;
				case 3:
					inimigo.getSprite().aparencia=6+lado;

					break;
				}
				
				if (down==3) down=0;
				else down++;
				test=null;
				return true;
			}
		}
		return false;
		
	}
	
	public boolean moverEsquerda(Inimigo inimigo) {
		lado=1;
		test = new Rectangle(inimigo.getSprite().posX-4, inimigo.getSprite().posY, inimigo.getSprite().width, inimigo.getSprite().height);
		if (telagame.game.colisao(inimigo.getSprite().posX-4, inimigo.getSprite().posY)&& telagame.game.colisaoRectangle(test, inimigo.getSprite())) {
			if (telagame.game.colisao(inimigo.getSprite().posX-4, inimigo.getSprite().posY+31)&& telagame.game.colisaoRectangle(test, inimigo.getSprite())){
				inimigo.getSprite().posX -= 4;
				inimigo.getSprite().setRect(new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY, inimigo.getSprite().width, inimigo.getSprite().height));
				
				switch (left) {
				case 0:
					inimigo.getSprite().aparencia=0+lado;
					break;
				case 1:
					inimigo.getSprite().aparencia=2+lado;
					break;
				case 2:
					inimigo.getSprite().aparencia=4+lado;
					break;
				case 3:
					inimigo.getSprite().aparencia=6+lado;

					break;
				}
				
				if (left==3) left=0;
				else left++;
				test=null;
				return true;
			}
		}
		return false;
	}
	public boolean moverDireita(Inimigo inimigo) {
		lado=0;
		test = new Rectangle(inimigo.getSprite().posX+4, inimigo.getSprite().posY, inimigo.getSprite().width, inimigo.getSprite().height);
		if (telagame.game.colisao(inimigo.getSprite().posX+35, inimigo.getSprite().posY)&& telagame.game.colisaoRectangle(test, inimigo.getSprite())) {
			if (telagame.game.colisao(inimigo.getSprite().posX+35, inimigo.getSprite().posY+31)&& telagame.game.colisaoRectangle(test, inimigo.getSprite())){
				inimigo.getSprite().posX += 4;
				inimigo.getSprite().setRect(new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY, inimigo.getSprite().width, inimigo.getSprite().height));
			
				switch (right) {
				case 0:
					inimigo.getSprite().aparencia=0+lado;
					break;
				case 1:
					inimigo.getSprite().aparencia=2+lado;
					break;
				case 2:
					inimigo.getSprite().aparencia=4+lado;
					break;
				case 3:
					inimigo.getSprite().aparencia=6+lado;
					break;
				}
				if (right==3) right=0;
				else right++;
				test=null;
				return true;
			}
		}
		return false;
	
	}

	@Override
	public void run(){
		contadorAtacar = 0;
		while (true) {
			try {
				try {
						if (moverPlayer(inimigo)==false) {
						
							int x = random.nextInt(4);
							
							if (x==0)
								moverBaixo(inimigo);
							
							if (x==1)
								moverCima(inimigo);
							
							if (x==2)
								moverDireita(inimigo);
							
							if (x==3)
								moverEsquerda(inimigo);
						
					}
				}
				catch (NullPointerException e) {}
				
				if (contadorAtacar> 0) contadorAtacar--;
				
				Thread.sleep(1000/FPS);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}		
}

