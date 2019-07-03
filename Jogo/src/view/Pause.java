package view;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import controller.ControllerPause;
import model.Player;

public class Pause extends JFrame {
	
	BufferedImage img;
	JLabel image;
	Game game;
	Player player;
	
	DadosPlayer dados;
	
	
	public Pause(Player player, Game game, DadosPlayer dados){
		setSize(512,512);
//		setLayout();
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
		img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("resources/imgPause2.png"));
		}
		catch (IOException e) {}
		
		image = new JLabel(new ImageIcon(img));
		getContentPane().add(image);
		
		addMouseListener(new ControllerPause(game, this, dados));
		addKeyListener(new ControllerPause(game, this, dados));
		
		setVisible(true);
	}

	
	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public JLabel getImage() {
		return image;
	}

	public void setImage(JLabel image) {
		this.image = image;
	}
}
