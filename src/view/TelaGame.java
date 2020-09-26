package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ControllerChave;
import controller.ControllerEspinho;
import controller.ControllerGame;
import controller.ControllerInimigo;
import controller.ControllerPlayer;
import controller.ControllerPlayer2;
import model.Camada2;
import model.Espinho;
import model.Flecha;
import model.Game;
import model.Inimigo;
import model.ItemChave;
import model.Mapa;
import model.MapaSala;
import model.Player;
import model.Porta;
import model.Sprite;

public class TelaGame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	private Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
	
	private Mapa mapaatual;
	
	private Camada2 camada0, camada1, camada2;
	
	private BufferedImage tela;
	
	private Player player1, player2;
	private ArrayList<Sprite>sprites;
	private ArrayList<Inimigo>inimigos;
	private ArrayList<Player>players;
	private ArrayList<Porta>portas;
	private ArrayList<ItemChave>chaves;
	private ArrayList<Espinho>espinhos;
	private int FPS=60;
	private ControllerGame cg;
	private ControllerPlayer cp1;
	private ControllerPlayer cp2;
	private ControllerInimigo ci;
	private ControllerChave cc;
	private ControllerEspinho ce;
	private JLabel component;
	private ArrayList<Flecha>flechas = new ArrayList<>();
	private boolean mapaTrocou;
	private boolean ehMapaSala=true;
	private boolean mapa1passou=false;
	private boolean mapa2passou=false;
	private int n_mapas_passados=0;
	private int posXMatriz, posYMatriz;
	private Game game;

	public TelaGame(Player player1){
		this.player1 = player1;
		
		setSize(960,640);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		game = new Game(this);
	
		mapaatual = new MapaSala(this);
		
		
		setVisible(true);
	
	}
	
	public TelaGame(Player player1, Player player2){
		this.player1 = player1;
		this.player2 = player2;
		
		setSize(960,640);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		game = new Game(this);
	
		mapaatual = new MapaSala(this);
		
		
		setVisible(true);
	
	}
	
	public void paint(Graphics g){
		if(tela!=null) {
			
			tela.getGraphics().drawImage(camada0.getMapa(), 0, 0, this);

			tela.getGraphics().drawImage(camada1.getMapa(), 0, 0, this);
		
		for (Espinho e: espinhos) {
			if(e.getSprite()!=null && e!=null) {
				tela.getGraphics().drawImage(e.getSprite().sprites[e.getSprite().aparencia], e.getSprite().posX, e.getSprite().posY, null);
			}
		}	
		
			
		for (Player p: players) {
			if (p.getSprite()!=null && p!=null) {
				tela.getGraphics().drawImage(p.getSprite().sprites[p.getSprite().aparencia], p.getSprite().posX, p.getSprite().posY, null);
				tela.getGraphics().fillRect(p.getSprite().posX+4, p.getSprite().posY-5,p.getVida()/8 , 3);
			}	
		}
		
		for (ItemChave i: chaves) {
			if(i.getSprite()!=null && i!=null) {
				tela.getGraphics().drawImage(i.getSprite().sprites[i.getSprite().aparencia], i.getSprite().posX, i.getSprite().posY, null);
			}
		}
		
		for(Porta p: portas) {
			if(p.getSprite()!=null && p!=null) {
				tela.getGraphics().drawImage(p.getSprite().sprites[p.getSprite().aparencia], p.getSprite().posX, p.getSprite().posY, null);
			}
		}
		
		for (Inimigo i: inimigos) {
		if (i.getSprite()!=null && i!=null) {
			tela.getGraphics().drawImage(i.getSprite().sprites[i.getSprite().aparencia], i.getSprite().posX, i.getSprite().posY, null);
			tela.getGraphics().fillRect(i.getSprite().posX+4, i.getSprite().posY-5, i.getVida()/2, 3);
			}
		}
		
		if (flechas!=null && flechas.size()!=0) {
			for (Flecha flecha: flechas)
			tela.getGraphics().drawImage(flecha.getFlechaSprite().sprites[flecha.getFlechaSprite().aparencia], flecha.getFlechaSprite().posX, flecha.getFlechaSprite().posY, null);
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

	public Dimension getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(Dimension screenSize) {
		this.screenSize = screenSize;
	}

	public Mapa getMapaatual() {
		return mapaatual;
	}

	public void setMapaatual(Mapa mapaatual) {
		this.mapaatual = mapaatual;
	}

	public Camada2 getCamada0() {
		return camada0;
	}

	public void setCamada0(Camada2 camada0) {
		this.camada0 = camada0;
	}

	public Camada2 getCamada1() {
		return camada1;
	}

	public void setCamada1(Camada2 camada1) {
		this.camada1 = camada1;
	}

	public Camada2 getCamada2() {
		return camada2;
	}

	public void setCamada2(Camada2 camada2) {
		this.camada2 = camada2;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public ArrayList<Sprite> getSprites() {
		return sprites;
	}

	public void setSprites(ArrayList<Sprite> sprites) {
		this.sprites = sprites;
	}

	public ArrayList<Inimigo> getInimigos() {
		return inimigos;
	}

	public void setInimigos(ArrayList<Inimigo> inimigos) {
		this.inimigos = inimigos;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public ArrayList<Porta> getPortas() {
		return portas;
	}

	public void setPortas(ArrayList<Porta> portas) {
		this.portas = portas;
	}

	public ArrayList<ItemChave> getChaves() {
		return chaves;
	}

	public void setChaves(ArrayList<ItemChave> chaves) {
		this.chaves = chaves;
	}

	public ArrayList<Espinho> getEspinhos() {
		return espinhos;
	}

	public void setEspinhos(ArrayList<Espinho> espinhos) {
		this.espinhos = espinhos;
	}

	public int getFPS() {
		return FPS;
	}

	public void setFPS(int fPS) {
		FPS = fPS;
	}

	public ControllerGame getCg() {
		return cg;
	}

	public void setCg(ControllerGame cg) {
		this.cg = cg;
	}

	public ControllerPlayer getCp1() {
		return cp1;
	}

	public void setCp1(ControllerPlayer cp1) {
		this.cp1 = cp1;
	}

	public ControllerInimigo getCi() {
		return ci;
	}

	public void setCi(ControllerInimigo ci) {
		this.ci = ci;
	}

	public ControllerChave getCc() {
		return cc;
	}

	public void setCc(ControllerChave cc) {
		this.cc = cc;
	}

	public ControllerEspinho getCe() {
		return ce;
	}

	public void setCe(ControllerEspinho ce) {
		this.ce = ce;
	}

	public JLabel getComponent() {
		return component;
	}

	public void setComponent(JLabel component) {
		this.component = component;
	}

	public ArrayList<Flecha> getFlechas() {
		return flechas;
	}

	public void setFlechas(ArrayList<Flecha> flechas) {
		this.flechas = flechas;
	}

	public boolean isMapaTrocou() {
		return mapaTrocou;
	}

	public void setMapaTrocou(boolean mapaTrocou) {
		this.mapaTrocou = mapaTrocou;
	}

	public boolean isEhMapaSala() {
		return ehMapaSala;
	}

	public void setEhMapaSala(boolean ehMapaSala) {
		this.ehMapaSala = ehMapaSala;
	}

	public boolean isMapa1passou() {
		return mapa1passou;
	}

	public void setMapa1passou(boolean mapa1passou) {
		this.mapa1passou = mapa1passou;
	}

	public boolean isMapa2passou() {
		return mapa2passou;
	}

	public void setMapa2passou(boolean mapa2passou) {
		this.mapa2passou = mapa2passou;
	}

	public int getPosXMatriz() {
		return posXMatriz;
	}

	public void setPosXMatriz(int posXMatriz) {
		this.posXMatriz = posXMatriz;
	}

	public int getPosYMatriz() {
		return posYMatriz;
	}

	public void setPosYMatriz(int posYMatriz) {
		this.posYMatriz = posYMatriz;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getN_mapas_passados() {
		return n_mapas_passados;
	}

	public void setN_mapas_passados(int n_mapas_passados) {
		this.n_mapas_passados = n_mapas_passados;
	}

	public ControllerPlayer getCp2() {
		return cp2;
	}

	public void setCp2(ControllerPlayer cp2) {
		this.cp2 = cp2;
	}
	
	
	
}


