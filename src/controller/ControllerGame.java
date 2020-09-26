package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import view.TelaGame;
import view.TelaPause;

public class ControllerGame extends KeyAdapter implements Runnable {

	private TelaGame telagame;
	
	public ControllerGame(TelaGame telagame) {
		this.telagame = telagame;
		telagame.setCg(this);
		telagame.addKeyListener(new TAdapter());
	}

	public class TAdapter extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
				
				TelaPause pause = new TelaPause(telagame);
				pause.setVisible(true);
				new Thread(pause).start();
				
			}
			
		}
	}
	public void run() {
		telagame.setTela(new BufferedImage(1024, 1024, BufferedImage.TYPE_4BYTE_ABGR));
		int i=telagame.getFPS()*2;
		while (true) {
			if (telagame==null)break;
			try {
				
				telagame.repaint();
				if (i==1) {
					telagame.getPlayer1().setVida(telagame.getPlayer1().getVida()+18);
					if (telagame.getPlayer2()!=null)
						telagame.getPlayer2().setVida(telagame.getPlayer2().getVida()+18);
				}
				
				i--;
				if (i==0)
					i=telagame.getFPS()*2;
				
				if (telagame.getPlayer1().getContadorAtaque() > 0) telagame.getPlayer1().setContadorAtaque(telagame.getPlayer1().getContadorAtaque()-1);
				if (telagame.getPlayer1().getContadorFlecha() > 0) telagame.getPlayer1().setContadorFlecha(telagame.getPlayer1().getContadorFlecha()-1);
				
				if (telagame.getPlayer2()!=null) {
					if (telagame.getPlayer2().getContadorAtaque() > 0) telagame.getPlayer2().setContadorAtaque(telagame.getPlayer2().getContadorAtaque()-1);
					if (telagame.getPlayer2().getContadorFlecha() > 0) telagame.getPlayer2().setContadorFlecha(telagame.getPlayer2().getContadorFlecha()-1);
				}
				Thread.sleep(1000/telagame.getFPS());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Thread.currentThread().stop();
	}
	
	public void keyReleased(KeyEvent e) {		
	}

}
	
