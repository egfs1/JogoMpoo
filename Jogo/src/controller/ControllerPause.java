package controller;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import view.DadosPlayer;
import view.Game;
import view.Pause;

public class ControllerPause implements MouseListener, KeyListener{
	
		Game game;
		Pause pause;
		DadosPlayer dados;
	
		
		public ControllerPause(Game game, Pause pause, DadosPlayer dados) {
			this.game = game;
			this.pause = pause;
			this.dados = dados;

			game.addMouseListener(this);
			game.addKeyListener(this);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent arg0) {
			
			if (arg0.getClickCount()==MouseEvent.BUTTON1) {
				if (arg0.getX()>= 136 && arg0.getX() <= 378) {
					if (arg0.getY() >= 202 && arg0.getY() <= 244) {
						pause.setVisible(false);
						dados.setVisible(false);
						dados=null;
						pause=null;
						System.gc();
					}
					else {
						if (arg0.getY() >= 354 && arg0.getY() <= 396) {
							game.exit();
						}
					}
				}	
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			if (arg0.getKeyCode()==KeyEvent.VK_ESCAPE) {
					pause.setVisible(false);
					dados.setVisible(false);
					dados=null;
					pause=null;
					System.gc();
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

	}
