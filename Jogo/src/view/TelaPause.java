package view;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ControllerPause;
import model.Player;

public class TelaPause extends JFrame {
	
	private static final long serialVersionUID = 1L;
	BufferedImage img;
	JLabel image;
	TelaGame game;
	Player player;
	
	TelaDadosPlayer dados;
	
	public TelaPause(Player player, TelaGame game, TelaDadosPlayer dados){
		setSize(512,512);
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
