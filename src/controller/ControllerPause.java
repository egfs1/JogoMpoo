package controller;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import model.Salvar;
import model.Player;
import view.TelaGame;
import view.TelaInventario;
import view.TelaMensagem;
import view.TelaPause;

public class ControllerPause implements KeyListener, ActionListener{
		
		private Player player1, player2;
		private TelaPause pause;
	
		
		public ControllerPause(TelaPause pause, TelaGame telagame) {
			this.pause = pause;
			this.player1 = telagame.getPlayer1();
			this.player2 = telagame.getPlayer2();
			
			this.pause.getContinueButton().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					pause.dispose();
				}
			});
			
			this.pause.getSairButton().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			
			this.pause.getInvButton().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					TelaInventario ti = new TelaInventario(player1, player2);
					ControllerInventario ci = new ControllerInventario(ti);
					
				}
			});
			
			this.pause.getSalvarButton().addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try {
						Salvar.salvarDados(telagame);
						
						TelaMensagem tm = new TelaMensagem("Salvo com sucesso!");
						tm.setBackground(Color.WHITE);
						ControllerTelaMensagem ctm = new ControllerTelaMensagem(tm);
						
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			
		}
		
		
		public void keyPressed(KeyEvent arg0) {
			if (arg0.getKeyCode()==KeyEvent.VK_ESCAPE) {
					pause.setVisible(false);
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}

		public void actionPerformed(ActionEvent e) {
			
		}

	}
