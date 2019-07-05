package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Player;
import view.TelaInventario;
import view.TelaPause;

public class ControllerPause implements KeyListener, ActionListener{
		
		Player player;
		TelaPause pause;
	
		
		public ControllerPause(TelaPause pause, Player player) {
			this.pause = pause;
			this.player = player;				
			
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
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					TelaInventario ti = new TelaInventario(player);
					
					
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
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void actionPerformed(ActionEvent e) {
			
		}

	}
