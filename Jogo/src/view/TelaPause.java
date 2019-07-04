package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ControllerPause;
import model.Player;

public class TelaPause extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;
	BufferedImage img, tela;
	Image imageFundo, dadosImg;
	TelaGame game;
	Player player;
	int vida=200;
	int FPS=10;
	
	
	JLabel dadosLabel;
	
	public TelaPause(Player player, TelaGame game){
		this.player = player;
		this.game = game;
		
		setSize(512,512);
//		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			img = ImageIO.read(new File("src/resources/imgPause2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		dadosLabel = new JLabel();
//		dadosLabel.setFont(new Font(player.getVida() + "/" + vida, Font.BOLD, 10));
//		dadosLabel.setBackground(Color.green);
//		dadosImg = dadosLabel.createImage(70, 70);
		
		addMouseListener(new ControllerPause(game, this));
		setVisible(true);
	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, null);
		g.drawRect(156, 23, 201, 16);
		g.fillRect(157, 24, player.getVida(), 16);
		g.drawString(player.getVida() + "/" + vida, 365, 35);
		g.drawString(player.getNome(), 40, 110);
	
		
	}

	@Override
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

	public Image getImageFundo() {
		return imageFundo;
	}

	public void setImageFundo(Image image) {
		this.imageFundo = image;
	}
}
