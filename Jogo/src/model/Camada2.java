package model;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;

public class Camada2 {
	private final int numeroColunas = 16;
	private final int numeroLinhas = 16;
	private final int colunasTileSet = 10;
	private final int tileSize = 16;

	private int camada[][];
	private int mapaLargura = numeroColunas * tileSize;
	private int mapaAltura = numeroLinhas * tileSize;

	private BufferedImage tileSet;
	private BufferedImage mapa = new BufferedImage(mapaLargura, mapaAltura, BufferedImage.TYPE_4BYTE_ABGR);
	
	
	private Graphics2D dbg = mapa.createGraphics();
	
	public Camada2(String nomeMapaMatriz) {
		
		try {
			tileSet=ImageIO.read(new File("src/resources/Tileset.png"));
		} catch (IOException e) {
			System.out.println("Não conseguiu ler Tileset");
			e.printStackTrace();
		}
		
		camada=carregarMatriz(nomeMapaMatriz);
	
	}
	public void montarMapa() {
		mapa.createGraphics();

		int tile;
		int tileRow;
		int tileCol;
		for (int i = 0; i < numeroLinhas; i++) {
			for (int j = 0; j < numeroColunas; j++) {
				if(camada[i][j] != 0)
				{
					tile = (camada[i][j] != 0) ? (camada[i][j] - 1) : 0;
					tileRow = (tile / colunasTileSet) | 0;
					tileCol = (tile % colunasTileSet) | 0;
					dbg.drawImage(tileSet, (j * tileSize), (i * tileSize), (j * tileSize) + tileSize,
							(i * tileSize) + tileSize, (tileCol * tileSize), (tileRow * tileSize),
							(tileCol * tileSize) + tileSize, (tileRow * tileSize) + tileSize, null);
					
				}

			}
		}
	}
		

	public int[][] carregarMatriz(String nomeMapa) {
		int[][] matz = new int[numeroLinhas][numeroColunas];
		ArrayList<String> linhas = new ArrayList<>();
		InputStream input = getClass().getClassLoader().getResourceAsStream(nomeMapa);
		BufferedReader br = new BufferedReader(new InputStreamReader(input));

		String linha = "";

		try {
			while ((linha = br.readLine()) != null)
				linhas.add(linha);

			int coluna = 0;
			for (int i = 0; i < linhas.size(); i++) {
				StringTokenizer token = new StringTokenizer(linhas.get(i), ",");

				while (token.hasMoreElements()) {
					matz[i][coluna] = Integer.parseInt(token.nextToken());
					coluna++;
				}
				coluna = 0;
			}

		} catch (IOException e) {
			System.out.println("Não carregou Matriz");
			e.printStackTrace();
		}

		return matz;
	}
	
	
	public BufferedImage getMapa() {
		return mapa;
	}
	public int getMapaLargura() {
		return mapaLargura;
	}
	public int getMapaAltura() {
		return mapaAltura;
	}

}
