package view;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


import controller.ControllerGame;
import controller.ControllerPlayer;
import model.Camada2;
import model.Player;
import model.Sprite;

public class Game extends JFrame implements Runnable {
//	private static final long serialVersionUID = 1L;
	
	Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
	
	Camada2 camada0,camada1,camada2;
	
	Player player;
	public BufferedImage tela;
	static Sprite personagem;
	int FPS=60;
	ImageIcon background;
	int up, down, right, left, k;
	
	int posXMatriz, posYMatriz;

	public Game(Player player){
		
		setSize(512,512);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		camada0 = new Camada2("resources/Camada0.txt");
		camada1 = new Camada2("resources/Camada1.txt");
		camada2 = new Camada2("resources/Camada2.txt");
		
		try {
			personagem = new Sprite(new File("src/resources/personagem.png"), 0, 4, 1, this.getWidth()/2, this.getHeight()/2);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Não foi possível carregar a Sprite");
		}
		
		camada0.montarMapa();
		camada1.montarMapa();
		camada2.montarMapa();
		
		addKeyListener(new ControllerGame(this,personagem, player));
		addKeyListener(new ControllerPlayer(this, personagem));
		
		setVisible(true);
	
	}
	
	public void exit() {
		System.exit(0);
	}
	
	public void paint(Graphics g){
		tela.getGraphics().drawImage(camada0.getMapa(), 0, 0, this);

		tela.getGraphics().drawImage(camada1.getMapa(), 0, 0, this);
		
		tela.getGraphics().drawImage(personagem.sprites[personagem.aparencia], personagem.posX, personagem.posY, null);
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
	
	public boolean colisao(int posX,int posY) {
		
		posXMatriz = ((posX)/ 32);
		posYMatriz = ((posY)/ 32);
		
		int[][] mtz = camada1.carregarMatriz("resources/Camada1.txt");
		
		ArrayList<String> numeros = new ArrayList<>();
		InputStream input = getClass().getClassLoader().getResourceAsStream("resources/Objetos_col.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		String linha="";
		int pos= mtz[posYMatriz][posXMatriz];
		
		try {
			linha= br.readLine();
			StringTokenizer token = new StringTokenizer(linha, ",");
			
			while (token.hasMoreElements()) {
				numeros.add(token.nextToken());
			}
			
			for (String n: numeros) {
				if (Integer.parseInt(n) == pos)
					return false;
				
			}
			
		}catch (IOException e) {}	
		
		return true;	
	}
	
	public BufferedImage getTela() {
		return tela;
	}

	public void setTela(BufferedImage tela) {
		this.tela = tela;
	}
	
}


