package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ItemChave extends Item {
	
	private Player player;
	private Sprite sprite;
	private BufferedImage icon;
	
	public ItemChave(String nome, Sprite sprite) {
		super(nome);
		this.sprite = sprite;
		
		try {
			icon = ImageIO.read(getClass().getClassLoader().getResourceAsStream("keyicon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public BufferedImage getIcon() {
		return icon;
	}

	public void setIcon(BufferedImage icon) {
		this.icon = icon;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
		
}
