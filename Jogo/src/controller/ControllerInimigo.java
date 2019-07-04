package controller;

import java.awt.Rectangle;
import java.util.Random;

import model.Inimigo;
import view.TelaGame;


public class ControllerInimigo implements Runnable {
	
	Random random = new Random();
	TelaGame telagame;
	Inimigo inimigo;
	int up, down, left, right;
	static int lado=0;
	Rectangle test=null;
	int FPS = 2;
	
	
	public ControllerInimigo(TelaGame telagame,Inimigo inimigo) {
		this.inimigo = inimigo;
		this.telagame = telagame;
	}
	
	public void moverCima(Inimigo inimigo) {
		test = new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY-4, inimigo.getSprite().width, inimigo.getSprite().height);
		if (telagame.game.colisao(inimigo.getSprite().posX, inimigo.getSprite().posY-4) && telagame.game.colisaoPlayer(test)) {
			if (telagame.game.colisao(inimigo.getSprite().posX+31, inimigo.getSprite().posY-4) && telagame.game.colisaoPlayer(test)){
				inimigo.getSprite().posY -= 4;
				inimigo.getSprite().setRect(new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY, inimigo.getSprite().width, inimigo.getSprite().height));
			}
		}
		
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
	}
	public void moverBaixo(Inimigo inimigo) {
		test = new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY+4, inimigo.getSprite().width, inimigo.getSprite().height);
		if (telagame.game.colisao(inimigo.getSprite().posX, inimigo.getSprite().posY+32)&& telagame.game.colisaoPlayer(test)) {
			if (telagame.game.colisao(inimigo.getSprite().posX+31, inimigo.getSprite().posY+32)&& telagame.game.colisaoPlayer(test)){
				inimigo.getSprite().posY += 4;
				inimigo.getSprite().setRect(new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY, inimigo.getSprite().width, inimigo.getSprite().height));
			}
		}
		
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
	}
	
	public void moverEsquerda(Inimigo inimigo) {
		lado=1;
		test = new Rectangle(inimigo.getSprite().posX-4, inimigo.getSprite().posY, inimigo.getSprite().width, inimigo.getSprite().height);
		if (telagame.game.colisao(inimigo.getSprite().posX-4, inimigo.getSprite().posY)&& telagame.game.colisaoPlayer(test)) {
			if (telagame.game.colisao(inimigo.getSprite().posX-4, inimigo.getSprite().posY+31)&& telagame.game.colisaoPlayer(test)){
				inimigo.getSprite().posX -= 4;
				inimigo.getSprite().setRect(new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY, inimigo.getSprite().width, inimigo.getSprite().height));
			}
		}
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
	}
	public void moverDireita(Inimigo inimigo) {
		lado=0;
		test = new Rectangle(inimigo.getSprite().posX+4, inimigo.getSprite().posY, inimigo.getSprite().width, inimigo.getSprite().height);
		if (telagame.game.colisao(inimigo.getSprite().posX+32, inimigo.getSprite().posY)&& telagame.game.colisaoPlayer(test)) {
			if (telagame.game.colisao(inimigo.getSprite().posX+32, inimigo.getSprite().posY+31)&& telagame.game.colisaoPlayer(test)){
				inimigo.getSprite().posX += 4;
				inimigo.getSprite().setRect(new Rectangle(inimigo.getSprite().posX, inimigo.getSprite().posY, inimigo.getSprite().width, inimigo.getSprite().height));
			}
		}
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
	}

	@Override
	public void run() {
		while (true) {
			try {
				try {
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
				catch (NullPointerException e) {}
				
				Thread.sleep(1000/FPS);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}		
}

