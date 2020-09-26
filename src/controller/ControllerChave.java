package controller;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import model.ItemChave;
import model.Player;
import view.TelaGame;

public class ControllerChave implements Runnable {
	
	
	private TelaGame telaGame;
	private ArrayList<ItemChave>chaves;
	private int FPS=8;
	private int k;
	
	
	public ControllerChave(ArrayList<ItemChave>chaves, TelaGame telaGame) {
		this.telaGame = telaGame;
		this.chaves = chaves;
	}
	
	public void verificarPegarChave() {
		try {
			for (ItemChave i: chaves) {
				Player p=null;
				try {
					p = telaGame.getGame().retornarPlayer(i.getSprite().getRect());
				}
				catch (NullPointerException n) {}
					
					
					if (p!=null) {	
						i.setSprite(null);
						chaves.remove(i);
						p.addItem(i);
				}
			}
		}catch (ConcurrentModificationException e) {}
	}


	public void run() {
		while (true) {
			if (chaves.size()==0 || chaves==null || telaGame.isMapaTrocou())break;
			for (ItemChave chave: chaves) {
				if (chave==null)break;
				verificarPegarChave();
				try {
							switch (k) {
							case 0:
								chave.getSprite().aparencia = 0;
								break;
							case 1:
								chave.getSprite().aparencia = 1;
								break;
							case 2:
								chave.getSprite().aparencia = 2;
								break;
							case 3:
								chave.getSprite().aparencia = 3;
								break;
					
//							}
						}
					}
				catch (NullPointerException n) {
					break;
				}
				
			}
			try {				
				Thread.sleep(1000/FPS);	
			}
			catch (InterruptedException e) {}
			
			if (k==3)k=0;
			k++;
			
		}
		Thread.currentThread().stop();
	}
	
}
