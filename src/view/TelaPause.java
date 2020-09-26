package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ControllerPause;
import model.Player;

public class TelaPause extends JFrame implements Runnable {
	
	
	private static final long serialVersionUID = 1L;
	private JButton invButton, continueButton,salvarButton, sairButton;
	private JPanel panel;
	private BufferedImage imgPersonagem;
	private Player player1, player2;
	private int vida=200;
	private int FPS=5;
	private TelaGame telagame;
	
	public TelaPause(TelaGame telagame){
		this.telagame = telagame;
		this.player1 = telagame.getPlayer1();
		this.player2 = telagame.getPlayer2();
		
		setSize(512,512);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		try {
			imgPersonagem = ImageIO.read(getClass().getClassLoader().getResourceAsStream("imgPersonagem2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(512,512);
		panel.setBackground(Color.GRAY);
		
		
		invButton= new JButton("Inventário");
		sairButton= new JButton("Sair");
		salvarButton = new JButton("Salvar");
		continueButton= new JButton("Continuar");
		
		invButton.setBackground(Color.WHITE);
		sairButton.setBackground(Color.WHITE);
		salvarButton.setBackground(Color.white);
		continueButton.setBackground(Color.WHITE);

		
		invButton.setBounds(10, 70, 150, 30);
		continueButton.setBounds(10, 10, 150, 30);
		salvarButton.setBounds(10, 130, 150, 30);
		sairButton.setBounds(10, 190, 150, 30);
		
		addKeyListener(new ControllerPause(this,telagame));
		
		panel.add(invButton);
		panel.add(continueButton);
		panel.add(sairButton);
		panel.add(salvarButton);
		
		getContentPane().add(panel);
		
		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(imgPersonagem, 170, 0, null);
		g.setColor(Color.WHITE);
		g.drawRect(300, 53, 201, 10);
		g.drawRect(165, 0, 511-165, 511);
		g.drawRect(0, 0, 165, 511);
		g.setFont(new Font("", Font.TYPE1_FONT,15));
		g.drawString("Mapas completos: " + telagame.getN_mapas_passados() + "/2", 10, 250);
		
		g.setColor(Color.RED);
		g.fillRect(301, 54, player1.getVida(), 10);
		g.setColor(Color.WHITE);
		g.setFont(new Font("", Font.TYPE1_FONT,15));
		g.drawString(player1.getVida() + "/" + vida, 450, 50);
		g.drawString(player1.getNome(), 300, 20);
		g.drawString("HP", 300, 50);
		
		if(player2!=null) {
		g.drawImage(imgPersonagem, 170, 200, null);
		g.setColor(Color.RED);
		g.fillRect(301, 254, player2.getVida(), 10);
		g.setColor(Color.WHITE);
		g.setFont(new Font("", Font.TYPE1_FONT,15));
		g.drawString(player2.getVida() + "/" + vida, 450, 250);
		g.drawString(player2.getNome(), 300, 220);
		g.drawString("HP", 300, 250);
		}
		
	}

	public void run() {
		while (true) {
			try {	
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

	public JButton getSalvarButton() {
		return salvarButton;
	}

	public void setSalvarButton(JButton salvarButton) {
		this.salvarButton = salvarButton;
	}
}
