package controller;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;

import model.Inimigo;
import model.Player;
import view.TelaGame;


public class ControllerInimigo implements Runnable {
	
	private Random random = new Random();
	private TelaGame telagame;
	private ArrayList<Inimigo>inimigos;
	private int up, down, left, right;
	private Rectangle test=null;
	private int FPS = 10;
	
	
	public ControllerInimigo(TelaGame telagame,ArrayList<Inimigo>inimigos) {
		this.inimigos = inimigos;
		this.telagame = telagame;
	}
	
	public boolean moverPlayer(Inimigo inimigo) throws InterruptedException {
		if (inimigo!=null) {
			test = new Rectangle(inimigo.getSprite().posX-30, inimigo.getSprite().posY-30, inimigo.getSprite().width+60  , inimigo.getSprite().height+60);
			if (telagame.getGame().colisaoPlayer(test)==false) {
				
				Player p = telagame.getGame().retornarPlayer(test);
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
							if (pRect.intersects(attackUp) && inimigo.contadorAtacar==0) {
							inimigo.atacar(p);
							telagame.getGame().verificarVidaPlayer(p);
							inimigo.contadorAtacar=5;
							}
						}
					}
				if (pRect.intersects(testDown))
					if (moverBaixo(inimigo)==false) {
						if (pRect.intersects(attackDown) && inimigo.contadorAtacar==0) {
							inimigo.atacar(p);
							telagame.getGame().verificarVidaPlayer(p);
							inimigo.contadorAtacar=5;
							}
					}
				if (pRect.intersects(testLeft))
					if (moverEsquerda(inimigo)==false) {
						if (pRect.intersects(attackLeft) && inimigo.contadorAtacar==0) {
							inimigo.atacar(p);
							telagame.getGame().verificarVidaPlayer(p);
							inimigo.contadorAtacar=5;
							}
					}
				if (pRect.intersects(testRight))
					if (moverDireita(inimigo)==false) {
						if (pRect.intersects(attackRight) && inimigo.contadorAtacar==0) {
							inimigo.atacar(p);
							telagame.getGame().verificarVidaPlayer(p);
							inimigo.contadorAtacar=5;
							}
					}
					
			
			return true;
			}
		}
		return false;
		
	}
	
	
	public boolean moverCima(Inimigo inimigo) {
		test = new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY-4, inimigo.getSprite().width, inimigo.getSprite().height);
		if (telagame.getGame().colisao(inimigo.getSprite().posX, inimigo.getSprite().posY-4) && telagame.getGame().colisaoRectangle(test, inimigo.getSprite())) {
			if (telagame.getGame().colisao(inimigo.getSprite().posX+31, inimigo.getSprite().posY-4) && telagame.getGame().colisaoRectangle(test, inimigo.getSprite())){
				inimigo.getSprite().posY -= 4;
				inimigo.getSprite().setRect(new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY, inimigo.getSprite().width, inimigo.getSprite().height));
			
				switch (up) {
				case 0:
					inimigo.getSprite().aparencia=0+inimigo.lado;
					break;
				case 1:
					inimigo.getSprite().aparencia=2+inimigo.lado;
					break;
				case 2:
					inimigo.getSprite().aparencia=4+inimigo.lado;
					break;
				case 3:
					inimigo.getSprite().aparencia=6+inimigo.lado;
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
		if (telagame.getGame().colisao(inimigo.getSprite().posX, inimigo.getSprite().posY+35)&& telagame.getGame().colisaoRectangle(test, inimigo.getSprite())) {
			if (telagame.getGame().colisao(inimigo.getSprite().posX+31, inimigo.getSprite().posY+35)&& telagame.getGame().colisaoRectangle(test, inimigo.getSprite())){
				inimigo.getSprite().posY += 4;
				inimigo.getSprite().setRect(new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY, inimigo.getSprite().width, inimigo.getSprite().height));
				
				switch (down) {
				case 0:
					inimigo.getSprite().aparencia=0+inimigo.lado;
					break;
				case 1:
					inimigo.getSprite().aparencia=2+inimigo.lado;
					break;
				case 2:
					inimigo.getSprite().aparencia=4+inimigo.lado;
					break;
				case 3:
					inimigo.getSprite().aparencia=6+inimigo.lado;

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
		inimigo.lado=1;
		test = new Rectangle(inimigo.getSprite().posX-4, inimigo.getSprite().posY, inimigo.getSprite().width, inimigo.getSprite().height);
		if (telagame.getGame().colisao(inimigo.getSprite().posX-4, inimigo.getSprite().posY)&& telagame.getGame().colisaoRectangle(test, inimigo.getSprite())) {
			if (telagame.getGame().colisao(inimigo.getSprite().posX-4, inimigo.getSprite().posY+31)&& telagame.getGame().colisaoRectangle(test, inimigo.getSprite())){
				inimigo.getSprite().posX -= 4;
				inimigo.getSprite().setRect(new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY, inimigo.getSprite().width, inimigo.getSprite().height));
				
				switch (left) {
				case 0:
					inimigo.getSprite().aparencia=0+inimigo.lado;
					break;
				case 1:
					inimigo.getSprite().aparencia=2+inimigo.lado;
					break;
				case 2:
					inimigo.getSprite().aparencia=4+inimigo.lado;
					break;
				case 3:
					inimigo.getSprite().aparencia=6+inimigo.lado;

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
		inimigo.lado=0;
		test = new Rectangle(inimigo.getSprite().posX+4, inimigo.getSprite().posY, inimigo.getSprite().width, inimigo.getSprite().height);
		if (telagame.getGame().colisao(inimigo.getSprite().posX+35, inimigo.getSprite().posY)&& telagame.getGame().colisaoRectangle(test, inimigo.getSprite())) {
			if (telagame.getGame().colisao(inimigo.getSprite().posX+35, inimigo.getSprite().posY+31)&& telagame.getGame().colisaoRectangle(test, inimigo.getSprite())){
				inimigo.getSprite().posX += 4;
				inimigo.getSprite().setRect(new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY, inimigo.getSprite().width, inimigo.getSprite().height));
			
				switch (right) {
				case 0:
					inimigo.getSprite().aparencia=0+inimigo.lado;
					break;
				case 1:
					inimigo.getSprite().aparencia=2+inimigo.lado;
					break;
				case 2:
					inimigo.getSprite().aparencia=4+inimigo.lado;
					break;
				case 3:
					inimigo.getSprite().aparencia=6+inimigo.lado;
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
	public void run() {
		while (true) {

			
			if (inimigos.size()==0 || inimigos==null || telagame==null || telagame.isMapaTrocou())break;
			try {
				for (Inimigo inimigo: inimigos) {
						if (inimigo == null || telagame==null) {
							break;
						}
					
					try {
						try {
						if (moverPlayer(inimigo)==false && inimigo!=null) {
							
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
							}catch (NullPointerException n) {}
							} catch (InterruptedException e) {};
										
					if (inimigo.contadorAtacar> 0) inimigo.contadorAtacar--;
				}
			}catch (ConcurrentModificationException e) {}
			
			
				try {	
					Thread.sleep(1000/FPS);
				
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
			}	
		}
		Thread.currentThread().stop();
	}
}

