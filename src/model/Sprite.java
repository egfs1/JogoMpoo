package model;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Sprite{
	
	private Rectangle rect;
	public BufferedImage spriteSheet;   
	public int width, height;
	public int rows, columns;
	public int posX, posY;
	public BufferedImage[] sprites;
	public int aparencia;
	
	public Sprite(String file, int aparencia, int columns, int rows, int posX, int posY) throws IOException {
		spriteSheet = ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));
		this.aparencia=aparencia;

		
		this.width = spriteSheet.getWidth()/columns;
		this.height = spriteSheet.getHeight()/rows;

		this.rows = columns;
		this.columns = rows;
		this.posX=posX;
		this.posY=posY;
		
		rect = new Rectangle(posX, posY, width, height);

		sprites = new BufferedImage[columns * rows];
			for(int i = 0; i < columns; i++) {
			for(int j = 0; j < rows; j++) {
				sprites[(i * rows) + j] = spriteSheet.getSubimage(i * width, j * height, width, height);
			}
		}
		
	}
	
	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
}