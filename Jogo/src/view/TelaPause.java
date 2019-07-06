package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ControllerPause;
import model.Player;

public class TelaPause extends JFrame implements Runnable {
	
	
	private static final long serialVersionUID = 1L;
	JButton invButton, continueButton, sairButton;
	JPanel panel;
	
	BufferedImage img, tela,imgPersonagem;
	Player player;
	int vida=200;
	int FPS=5;
	
	public TelaPause(Player player){
		this.player = player;
		
		setSize(512,512);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		try {
			imgPersonagem = ImageIO.read(new File("src/resources/imgPersonagem2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(512,512);
		panel.setBackground(Color.GRAY);
		
		
		invButton= new JButton("Inventário");
		sairButton= new JButton("Sair");
		continueButton= new JButton("Continuar");
		
		invButton.setBackground(Color.WHITE);
		sairButton.setBackground(Color.WHITE);
		continueButton.setBackground(Color.WHITE);

		
		invButton.setBounds(10, 70, 150, 30);
		continueButton.setBounds(10, 10, 150, 30);
		sairButton.setBounds(10, 130, 150, 30);
		
		addKeyListener(new ControllerPause(this, player));
		
		panel.add(invButton);
		panel.add(continueButton);
		panel.add(sairButton);
		
		getContentPane().add(panel);
		
		setVisible(false);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(imgPersonagem, 170, 0, null);
		g.setColor(Color.WHITE);
		g.drawRect(300, 53, 201, 10);
		g.drawRect(165, 0, 511-165, 511);
		g.drawRect(0, 0, 165, 511);
		g.setColor(Color.RED);
		g.fillRect(301, 54, player.getVida(), 10);
		g.setColor(Color.WHITE);
		g.setFont(new Font("", Font.TYPE1_FONT,15));
		g.drawString(player.getVida() + "/" + vida, 450, 50);
		g.drawString(player.getNome(), 300, 20);
		g.drawString("HP", 300, 50);
		
		
	}

	public void run() {
		while (true) {
			try {	
//				super.repaint();
				repaint();
				Thread.sleep(1000/FPS);
				
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public JButton getInvButton() {
		return invButton;
	}

	public void setInvButton(JButton invButton) {
		this.invButton = invButton;
	}

	public JButton getContinueButton() {
		return continueButton;
	}

	public void setContinueButton(JButton continueButton) {
		this.continueButton = continueButton;
	}

	public JButton getSairButton() {
		return sairButton;
	}

	public void setSairButton(JButton sairButton) {
		this.sairButton = sairButton;
	}
}
