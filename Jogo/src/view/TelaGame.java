package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import controller.ControllerGame;
import controller.ControllerInimigo;
import controller.ControllerPlayer;
import model.Camada2;
import model.Game;
import model.Inimigo;
import model.Player;
import model.Sprite;

public class TelaGame extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;

	Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
	
	public Camada2 camada0, camada1, camada2;
	
	public Player player;
	public Inimigo inimigo1, inimigo2, inimigo3;
	public BufferedImage tela;
	public static Sprite personagem, inimigo1Sprite, inimigo2Sprite, inimigo3Sprite;
	public static ArrayList<Inimigo>inimigos = new ArrayList<>();
	public static ArrayList<Player>players = new ArrayList<>();
	public int FPS=60;
	
	public int posXMatriz, posYMatriz;
	public Game game;

	public TelaGame(Player player){
		
		setSize(512,512);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		game = new Game(this);
		
		camada0 = new Camada2("resources/Camada0.txt");
		camada1 = new Camada2("resources/Camada1.txt");
		camada2 = new Camada2("resources/Camada2.txt");
		
		try {
			personagem = new Sprite(new File("src/resources/personagemSprite.png"), 0, 4, 2, this.getWidth()/2, this.getHeight()/2);
			inimigo1Sprite = new Sprite(new File("src/resources/esqueletoSprite.png"), 0, 4, 2, (this.getWidth()/2), (this.getHeight()/2)-120);
			inimigo2Sprite = new Sprite(new File("src/resources/esqueletoSprite.png"), 0, 4, 2, (this.getWidth()/2+120), (this.getHeight()/2));
			inimigo3Sprite = new Sprite(new File("src/resources/esqueletoSprite.png"), 0, 4, 2, (this.getWidth()/2)-120, (this.getHeight()/2));
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Não foi possível carregar a Sprite");
		}
		
		player.setSprite(personagem);
		
		inimigo1 = new Inimigo(50, 5, inimigo1Sprite);
		inimigo2 = new Inimigo(100, 15, inimigo2Sprite);
		inimigo3 = new Inimigo(150, 25, inimigo3Sprite);
		
		players.add(player);
		inimigos.add(inimigo1);
		inimigos.add(inimigo2);
		inimigos.add(inimigo3);
		
		
		camada0.montarMapa();
		camada1.montarMapa();
		camada2.montarMapa();
		
		addKeyListener(new ControllerGame(this,personagem, player));
		addKeyListener(new ControllerPlayer(this, personagem, player));
		
		ControllerInimigo controllerInimigo1 = new ControllerInimigo(this, inimigo1);
		ControllerInimigo controllerInimigo2 = new ControllerInimigo(this, inimigo2);
		ControllerInimigo controllerInimigo3 = new ControllerInimigo(this, inimigo3);
		
		new Thread(controllerInimigo1).start();
		new Thread(controllerInimigo2).start();
		new Thread(controllerInimigo3).start();
		
		setVisible(true);
	
	}
		
	public void paint(Graphics g){
		tela.getGraphics().drawImage(camada0.getMapa(), 0, 0, this);

		tela.getGraphics().drawImage(camada1.getMapa(), 0, 0, this);
		
		if (personagem!=null)
		tela.getGraphics().drawImage(personagem.sprites[personagem.aparencia], personagem.posX, personagem.posY, null);
		
		if (inimigo1.getSprite()!=null) {
		tela.getGraphics().drawImage(inimigo1.getSprite().sprites[inimigo1Sprite.aparencia], inimigo1Sprite.posX, inimigo1Sprite.posY, null);
		tela.getGraphics().fillRect(inimigo1.getSprite().posX+8, inimigo1.getSprite().posY-5, inimigo1.getVida(), 3);
	
		}
		if (inimigo2.getSprite() != null) {
			tela.getGraphics().drawImage(inimigo2.getSprite().sprites[inimigo2Sprite.aparencia], inimigo2Sprite.posX, inimigo2Sprite.posY, null);
			tela.getGraphics().fillRect(inimigo2.getSprite().posX+8, inimigo2.getSprite().posY-5, inimigo2.getVida()/2, 3);
		}
		
		if (inimigo3.getSprite() != null) {
			tela.getGraphics().drawImage(inimigo3.getSprite().sprites[inimigo3Sprite.aparencia], inimigo3Sprite.posX, inimigo3Sprite.posY, null);
			tela.getGraphics().fillRect(inimigo3.getSprite().posX+8, inimigo3.getSprite().posY-5, inimigo3.getVida()/3, 3);
		}
		
		tela.getGraphics().drawImage(camada2.getMapa(), 0, 0, this);
		
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		g2d.drawImage(tela, 0, 0, null);
	}

	public void run() {
		tela = new BufferedImage(1024, 1024, BufferedImage.TYPE_4BYTE_ABGR);
		while (true) {
			try {
				repaint();
				
				Thread.sleep(1000/FPS);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

	public BufferedImage getTela() {
		return tela;
	}

	public void setTela(BufferedImage tela) {
		this.tela = tela;
	}
	
}


