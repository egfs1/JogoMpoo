package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TelaGameOver extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private JButton sairButton;
	private BufferedImage gameOverImage;
	
	int FPS=10;
	
	
	public TelaGameOver(){	
		setSize(512,512);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			gameOverImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("gameOverImage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sairButton = new JButton("Fechar");
		sairButton.setBackground(Color.BLACK);
		sairButton.setFont(new Font("", Font.TYPE1_FONT,20));
		sairButton.setBounds(156, this.getHeight()/2+50, 200, 50);
		
		getContentPane().add(sairButton);
		setVisible(true);
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
