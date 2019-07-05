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

import controller.ControllerGameOver;
import model.Player;

public class TelaGameOver extends JFrame {
	

	private static final long serialVersionUID = 1L;
	TelaGame telagame;
	Player player;
	JButton sairButton;
	BufferedImage gameOverImage;
	
	int FPS=10;
	
	
	public TelaGameOver(TelaGame telagame, Player player){
		this.telagame = telagame;
		this.player = player;
	
		setSize(512,512);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			gameOverImage = ImageIO.read(new File("src/resources/gameOverImage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sairButton = new JButton("Fechar");
		sairButton.setBackground(Color.BLACK);
		sairButton.setFont(new Font("", Font.TYPE1_FONT,20));
		sairButton.setBounds(156, this.getHeight()/2+50, 200, 50);
		
		getContentPane().add(sairButton);
		
		ControllerGameOver cgo = new ControllerGameOver(telagame, this);
		setVisible(false);
	}

	public void paint(Graphics g) {
		g.drawImage(gameOverImage, 0, 0, null);
	}
		
	public JButton getSairButton() {
		return sairButton;
	}


	public void setSairButton(JButton sairButton) {
		this.sairButton = sairButton;
	}
}	
