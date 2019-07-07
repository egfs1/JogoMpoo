package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import model.Player;
import view.TelaGame;
import view.TelaPause;

public class ControllerGame extends KeyAdapter implements Runnable {

	TelaGame telagame;
	int up, down, left, right;
	Player player;
	public int contadorAtaque=0;
	public int contadorRepaint;
	
	public ControllerGame(Player player) {
		this.player = player;
		telagame = new TelaGame(player, this);
		telagame.addKeyListener(new TAdapter());
	}

	public class TAdapter extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
				
				TelaPause pause = new TelaPause(player);
				pause.setVisible(true);
				
//				game.pauseThread();
				new Thread(pause).start();
				
			}
			
		}
	}
	public void run() {
		telagame.tela = new BufferedImage(1024, 1024, BufferedImage.TYPE_4BYTE_ABGR);
		int i=telagame.FPS*2;
		while (true) {
			
			try {
				contadorRepaint=0;
				telagame.repaint();
				contadorRepaint=1;
				if (i==1)
					player.setVida(player.getVida()+18);
				
				i--;
				if (i==0)
					i=telagame.FPS*2;
				
				if (contadorAtaque > 0) contadorAtaque--;
				
				Thread.sleep(1000/telagame.FPS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {		
	}

}
	
