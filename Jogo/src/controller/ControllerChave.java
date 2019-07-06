package controller;


import model.ItemChave;
import model.Player;
import view.TelaGame;

public class ControllerChave implements Runnable {

	TelaGame telaGame;
	ItemChave chave;
	int FPS=60;
	int k;
	
	
	public ControllerChave(ItemChave chave, TelaGame telaGame) {
		this.telaGame = telaGame;
		this.chave = chave;
	}
	
	public void verificarPegarChave() {
		for (ItemChave i: chave.getChaves()) {
//			System.out.println(i.getNome());
			Player p=null;
			try {
				p = telaGame.game.retornarPlayer(i.getSprite().getRect());
//				System.out.println(p.getNome());
			}
			catch (NullPointerException n) {}
				
				
				if (p!=null) {	
					i.setSprite(null);
					p.addItem(i);
					i=null;
			}
		}
	}


	public void run() {
		int contador = FPS;
		while (true) {
			verificarPegarChave();
			try {
				try {
					if (contador%12==0) {
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
						}
					if (k==3)k=0;
					k++;
					}
				}
				catch (NullPointerException n) {
					break;
				}
								
				Thread.sleep(1000/FPS);
				if(contador==0)contador=FPS;
				contador--;
			}
			catch (InterruptedException e) {}
		}
	}
	
}
