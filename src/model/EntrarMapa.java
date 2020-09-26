package model;

import java.awt.Rectangle;

import view.TelaGame;

public class EntrarMapa {
	private TelaGame telagame;
	private Player player;
	
	public EntrarMapa(TelaGame telagame, Player player) {
		this.telagame = telagame;
		this.player = player;
		
		verificarEntrarMapa();
	}
	
	public void verificarEntrarMapa() {
		Rectangle rmp1 = new Rectangle(32*4, 32*5, 32*1, 32*2);
		Rectangle rmp2 = new Rectangle(32*4, 32*9, 32*1, 32*2);
		
			if (rmp1.intersects(player.interagir())) {
				telagame.setMapaTrocou(false);;
				telagame.setMapaatual(new Mapa1(telagame));
			}
			
			if (rmp2.intersects(player.interagir())) {
				telagame.setMapaTrocou(false);;
				telagame.setMapaatual(new Mapa2(telagame));;
			}
	}
}
