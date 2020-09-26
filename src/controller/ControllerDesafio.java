package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaDesafio;
import view.TelaGame;
import view.TelaMensagem;

public class ControllerDesafio implements ActionListener, Runnable {
	
	private boolean resposta1,resposta2,resposta3;
	private TelaGame telagame;
	private String mapa;
	private TelaDesafio td;
	private int FPS=10;
	private int segundos=15;
	private int contador = FPS*segundos;
	
	public ControllerDesafio(TelaDesafio td, TelaGame telagame, String mapa) {
		this.telagame = telagame;
		this.mapa = mapa;
		this.td = td;
		
		td.getAlternativa1().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (td.getN_pergunta()==0) {
					if (td.getResultado1().equalsIgnoreCase("true")) {
						resposta1 = true;
					}
					else {
						resposta1 = false;
					}
					td.setN_pergunta(td.getN_pergunta()+1);
					td.getPanel1().setVisible(false);
					td.getPanel2().setVisible(true);
				}
				
				else if (td.getN_pergunta()==1) {
					if (td.getResultado2().equalsIgnoreCase("true")) {
						resposta2 = true;
					}
					else {
						resposta2 = false;
					}
					td.setN_pergunta(td.getN_pergunta()+1);
					td.getPanel2().setVisible(false);
					td.getPanel3().setVisible(true);
				}
				
				else if (td.getN_pergunta()==2) {
					if (td.getResultado3().equalsIgnoreCase("true")) {
						resposta3 = true;
					}
					else {
						resposta3 = false;
					}
					td.dispose();
				}
				
				td.repaint();
			}
		});
		
		td.getAlternativa2().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (td.getN_pergunta()==0) {
					if (td.getResultado1().equalsIgnoreCase("false")) {
						resposta1 = true;
					}
					else {
						resposta1 = false;
					}
					td.setN_pergunta(td.getN_pergunta()+1);
					td.getPanel1().setVisible(false);
					td.getPanel2().setVisible(true);
				}
				
				else if (td.getN_pergunta()==1) {
					if (td.getResultado2().equalsIgnoreCase("false")) {
						resposta2 = true;
					}
					else {
						resposta2 = false;
					}
					td.setN_pergunta(td.getN_pergunta()+1);
					td.getPanel2().setVisible(false);
					td.getPanel3().setVisible(true);
				}
				
				else if (td.getN_pergunta()==2) {
					if (td.getResultado3().equalsIgnoreCase("false")) {
						resposta3 = true;
					}
					else {
						resposta3 = false;
					}
					td.dispose();
				}
				
				td.repaint();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {}

	@Override
	public void run() {
		while (td.isVisible()) {
			String segundos_str= ""+segundos;
			
			try {
				if(contador==0)break;
				
//				td.getGraphics().setFont(new Font("", Font.TYPE1_FONT,20));
				td.getGraphics().drawString(segundos_str, td.getWidth()/2, 20);
				
				if (contador%10==0) {
					td.repaint();
					segundos-=1;
				}
				
				Thread.sleep(1000/FPS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			contador--;
		}
		boolean acertou=false;
		
		if (mapa=="mapa1") {
			if (resposta1 && resposta2 && resposta3) {
				telagame.setMapa1passou(true);
				telagame.setN_mapas_passados(telagame.getN_mapas_passados()+1);
				acertou = true;
			}
		}
		if (mapa=="mapa2") {
			if (resposta1 && resposta2 && resposta3) {
				telagame.setMapa2passou(true);
				telagame.setN_mapas_passados(telagame.getN_mapas_passados()+1);
				acertou = true;
			}
		}
		TelaMensagem m;
		if (acertou)
			m = new TelaMensagem("Desafio completo, próximo mapa desbloqueado!");
		else m = new TelaMensagem("Desafio incompleto, tente novamente!");
		
		ControllerTelaMensagem ctm = new ControllerTelaMensagem(m);
		
		td.dispose();
		
	}
}
