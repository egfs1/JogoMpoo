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
import javax.swing.JLabel;

import controller.ControllerGame;
import controller.ControllerInimigo;
import controller.ControllerPlayer;
import model.Camada2;
import model.Game;
import model.Inimigo;
import model.ItemChave;
import model.Player;
import model.Porta;
import model.Sprite;

public class TelaGame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
	
	public Camada2 camada0, camada1, camada2;
	
	public Player player;
	public Inimigo inimigo1, inimigo2, inimigo3, inimigo4, inimigo5, inimigo6, inimigo7, inimigo8, inimigo9, inimigo10, inimigo11, inimigo12;
	public BufferedImage tela;
	public ItemChave chave1, chave2;
	public Porta porta1, porta2;
	public static Sprite personagem, inimigo1Sprite, inimigo2Sprite, inimigo3Sprite, inimigo4Sprite, inimigo5Sprite, inimigo6Sprite, inimigo7Sprite, inimigo8Sprite, inimigo9Sprite, inimigo10Sprite, inimigo11Sprite, inimigo12Sprite,
						 chave1Sprite, chave2Sprite, porta1Sprite, porta2Sprite;
	
	public static ArrayList<Sprite>sprites = new ArrayList<>();
	public static ArrayList<Inimigo>inimigos = new ArrayList<>();
	public static ArrayList<Player>players = new ArrayList<>();
	public ArrayList<Porta>portas = new ArrayList<>();
	public int FPS=60;
	public ControllerGame cg;
	public ControllerPlayer cp1;
	public JLabel component;
	
	
	public int posXMatriz, posYMatriz;
	public Game game;

	public TelaGame(Player player, ControllerGame cg){
		this.player = player;
		this.cg = cg;
		
		setSize(960,640);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		game = new Game(this);
		
		camada0 = new Camada2("resources/Camadaa0.txt");
		camada1 = new Camada2("resources/Camadaa1.txt");
		camada2 = new Camada2("resources/Camadaa2.txt");
		
		try {
			personagem = new Sprite(new File("src/resources/personagemSprite.png"), 0, 4, 2, 32*14, 32*1);
			inimigo1Sprite = new Sprite(new File("src/resources/esqueletoSprite.png"), 0, 4, 2, 32*7, 32*4);
			inimigo2Sprite = new Sprite(new File("src/resources/esqueletoSprite.png"), 0, 4, 2, 32*4, 32*4);
			inimigo3Sprite = new Sprite(new File("src/resources/esqueletoSprite.png"), 0, 4, 2, 32*4, 32*10);
			inimigo4Sprite = new Sprite(new File("src/resources/esqueletoSprite.png"), 0, 4, 2, 32*4, 32*11);
			inimigo5Sprite = new Sprite(new File("src/resources/esqueletoSprite.png"), 0, 4, 2, 32*4, 32*16);
			inimigo6Sprite = new Sprite(new File("src/resources/esqueletoSprite.png"), 0, 4, 2, 32*4, 32*17);
			inimigo7Sprite = new Sprite(new File("src/resources/esqueletoSprite.png"), 0, 4, 2, 32*22, 32*4);
			inimigo8Sprite = new Sprite(new File("src/resources/esqueletoSprite.png"), 0, 4, 2, 32*25, 32*4);
			inimigo9Sprite = new Sprite(new File("src/resources/esqueletoSprite.png"), 0, 4, 2, 32*25, 32*10);
			inimigo10Sprite = new Sprite(new File("src/resources/esqueletoSprite.png"), 0, 4, 2, 32*25, 32*11);
			inimigo11Sprite = new Sprite(new File("src/resources/esqueletoSprite.png"), 0, 4, 2, 32*25, 32*16);
			inimigo12Sprite = new Sprite(new File("src/resources/esqueletoSprite.png"), 0, 4, 2, 32*25, 32*17);
			chave1Sprite = new Sprite(new File("src/resources/chaveSprite.png"), 0, 4, 1, 32*25, 32*18);
			chave2Sprite = new Sprite(new File("src/resources/chaveSprite.png"), 0, 4, 1, 32*4, 32*18);
			porta1Sprite = new Sprite(new File("src/resources/portaSprite.png"), 0, 1, 1, 32*14, 32*11);
			porta2Sprite = new Sprite(new File("src/resources/portaSprite.png"), 1, 2, 1, 32*25, 32*6);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Não foi possível carregar a Sprite");
		}
				
		sprites.add(personagem);
		sprites.add(inimigo1Sprite);
		sprites.add(inimigo2Sprite);
		sprites.add(inimigo3Sprite);
		sprites.add(inimigo4Sprite);
		sprites.add(inimigo5Sprite);
		sprites.add(inimigo6Sprite);
		sprites.add(inimigo7Sprite);
		sprites.add(inimigo8Sprite);
		sprites.add(inimigo9Sprite);
		sprites.add(inimigo10Sprite);
		sprites.add(inimigo11Sprite);
		sprites.add(inimigo12Sprite);
		sprites.add(porta1Sprite);
		sprites.add(porta2Sprite);
		
		player.setSprite(personagem);
		
		inimigo1 = new Inimigo(50, 15, inimigo1Sprite);
		inimigo2 = new Inimigo(50, 15, inimigo2Sprite);
		inimigo3 = new Inimigo(50, 15, inimigo3Sprite);
		inimigo4 = new Inimigo(50, 15, inimigo4Sprite);
		inimigo5 = new Inimigo(50, 15, inimigo5Sprite);
		inimigo6 = new Inimigo(50, 15, inimigo6Sprite);
		inimigo7 = new Inimigo(50, 15, inimigo7Sprite);
		inimigo8 = new Inimigo(50, 15, inimigo8Sprite);
		inimigo9 = new Inimigo(50, 15, inimigo9Sprite);
		inimigo10 = new Inimigo(50, 15, inimigo10Sprite);
		inimigo11 = new Inimigo(50, 15, inimigo11Sprite);
		inimigo12 = new Inimigo(50, 15, inimigo12Sprite);
		
		chave1 = new ItemChave("Chave Porta Meio", chave1Sprite, this);
		chave2 = new ItemChave("Chave Porta Direita", chave2Sprite, this);
		
		porta1 = new Porta(porta1Sprite, chave1, this);
		porta2 = new Porta(porta2Sprite, chave2, this);
		
		
		players.add(player);
		
		inimigos.add(inimigo1);
		inimigos.add(inimigo2);
		inimigos.add(inimigo3);
		inimigos.add(inimigo4);
		inimigos.add(inimigo5);
		inimigos.add(inimigo6);
		inimigos.add(inimigo7);
		inimigos.add(inimigo8);
		inimigos.add(inimigo9);
		inimigos.add(inimigo10);
		inimigos.add(inimigo11);
		inimigos.add(inimigo12);
		
		portas.add(porta1);
		portas.add(porta2);
		
		camada0.montarMapa();
		camada1.montarMapa();
		camada2.montarMapa();
		
		cp1 = new ControllerPlayer(this, personagem, player);
		
		ControllerInimigo controllerInimigo1 = new ControllerInimigo(this, inimigo1);
		ControllerInimigo controllerInimigo2 = new ControllerInimigo(this, inimigo2);
		ControllerInimigo controllerInimigo3 = new ControllerInimigo(this, inimigo3);
		ControllerInimigo controllerInimigo4 = new ControllerInimigo(this, inimigo4);
		ControllerInimigo controllerInimigo5 = new ControllerInimigo(this, inimigo5);
		ControllerInimigo controllerInimigo6 = new ControllerInimigo(this, inimigo6);
		ControllerInimigo controllerInimigo7 = new ControllerInimigo(this, inimigo7);
		ControllerInimigo controllerInimigo8 = new ControllerInimigo(this, inimigo8);
		ControllerInimigo controllerInimigo9 = new ControllerInimigo(this, inimigo9);
		ControllerInimigo controllerInimigo10 = new ControllerInimigo(this, inimigo10);
		ControllerInimigo controllerInimigo11 = new ControllerInimigo(this, inimigo11);
		ControllerInimigo controllerInimigo12 = new ControllerInimigo(this, inimigo12);
		
		new Thread(controllerInimigo1).start();
		new Thread(controllerInimigo2).start();
		new Thread(controllerInimigo3).start();
		new Thread(controllerInimigo4).start();
		new Thread(controllerInimigo5).start();
		new Thread(controllerInimigo6).start();
		new Thread(controllerInimigo7).start();
		new Thread(controllerInimigo8).start();
		new Thread(controllerInimigo9).start();
		new Thread(controllerInimigo10).start();
		new Thread(controllerInimigo11).start();
		new Thread(controllerInimigo12).start();
		
		setVisible(true);
	
	}
	
	public void paint(Graphics g){
		if(tela!=null) {
			
			tela.getGraphics().drawImage(camada0.getMapa(), 0, 0, this);

			tela.getGraphics().drawImage(camada1.getMapa(), 0, 0, this);
		
		if (player.getSprite()!=null) {
			tela.getGraphics().drawImage(player.getSprite().sprites[player.getSprite().aparencia], player.getSprite().posX, player.getSprite().posY, null);
			tela.getGraphics().fillRect(player.getSprite().posX+4, player.getSprite().posY-5,player.getVida()/8 , 3);
		}	
		
		if(chave1.getSprite()!=null) {
			tela.getGraphics().drawImage(chave1.getSprite().sprites[chave1.getSprite().aparencia], chave1.getSprite().posX, chave1.getSprite().posY, null);
		}
		
		if(chave2.getSprite()!=null) {
			tela.getGraphics().drawImage(chave2.getSprite().sprites[chave2.getSprite().aparencia], chave2.getSprite().posX, chave2.getSprite().posY, null);
		}
		
		if(porta1.getSprite()!=null) {
			tela.getGraphics().drawImage(porta1.getSprite().sprites[porta1.getSprite().aparencia], porta1.getSprite().posX, porta1.getSprite().posY, null);
		}
		
		if(porta2.getSprite()!=null) {
			tela.getGraphics().drawImage(porta2.getSprite().sprites[porta2.getSprite().aparencia], porta2.getSprite().posX, porta2.getSprite().posY, null);
		}
		
		for (Inimigo i: inimigos) {
		if (i.getSprite()!=null) {
			tela.getGraphics().drawImage(i.getSprite().sprites[i.getSprite().aparencia], i.getSprite().posX, i.getSprite().posY, null);
			tela.getGraphics().fillRect(i.getSprite().posX+4, i.getSprite().posY-5, i.getVida()/2, 3);
			}
		}
		
		
		
		tela.getGraphics().drawImage(camada2.getMapa(), 0, 0, this);
		
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		g2d.drawImage(tela, 0, 0, null);
		
		}
	}	
	
	
	public BufferedImage getTela() {
		return tela;
	}

	public void setTela(BufferedImage tela) {
		this.tela = tela;
	}
	
}


