package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Item;
import model.Player;

public class TelaInventario extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JButton voltarButton;
	private JPanel panel1, panel2;
	private Player player1, player2;
	
	public TelaInventario(Player player1, Player player2) {		
		this.player1 = player1;
		this.player2 = player2;
		
		setSize(512,512);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setBackground(Color.GRAY);
		
		panel1 = new JPanel();
		panel1.setSize(520,520);
		panel1.setLayout(null);
		panel1.setBackground(Color.GRAY);
		
		voltarButton = new JButton("Voltar");
		voltarButton.setFont(new Font("", Font.TYPE1_FONT,15));
		voltarButton.setBackground(Color.WHITE);
		
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(20, 20, getWidth()-40, getHeight()-100);
		
		voltarButton.setBounds(206, getWidth()-50, 100, 30);
		
		panel1.add(voltarButton);
		
		add(panel1);
		add(panel2);
		
		repaint();
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(panel2.getX(), panel2.getY(), panel2.getWidth(), panel2.getHeight());
		g.drawString("Player1", panel2.getX(), panel2.getY()-5);
		g.drawString("Player2", panel2.getX()+(panel2.getWidth()/2), panel2.getY()-4);
		
		
		int y=0;
		for (Item i: player1.getItems()) {
			g.drawImage(i.getIcon(), panel2.getX(), panel2.getY()+y, null);
			g.setColor(Color.BLACK);
			g.setFont(new Font("", Font.TYPE1_FONT,14));
			g.drawString(i.getNome(), panel2.getX()+i.getIcon().getWidth(), panel2.getY()+y+(i.getIcon().getHeight()*3/4)-3);
			y +=40;
		}
		if (player1.getItems().size()==0) {
			g.setColor(Color.black);
			g.setFont(new Font("", Font.TYPE1_FONT,14));
			g.drawString("Inventário vazio", panel2.getX()+5, panel2.getY()+15);
		}
		
		if (player2!=null) {
			for (Item i: player2.getItems()) {
				g.drawImage(i.getIcon(), panel2.getX()+(panel2.getWidth()/2), panel2.getY()+y, null);
				g.setColor(Color.BLACK);
				g.setFont(new Font("", Font.TYPE1_FONT,14));
				g.drawString(i.getNome(), panel2.getX()+i.getIcon().getWidth()+(panel2.getWidth()/2), panel2.getY()+y+(i.getIcon().getHeight()*3/4)-3);
				y +=40;
			}
			if (player2.getItems().size()==0) {
				g.setColor(Color.black);
				g.setFont(new Font("", Font.TYPE1_FONT,14));
				g.drawString("Inventário vazio", panel2.getX()+5+(panel2.getWidth()/2), panel2.getY()+15);
			}
			
		}
		
	}
	

	public JButton getVoltarButton() {
		return voltarButton;
	}

	public void setVoltarButton(JButton voltarButton) {
		this.voltarButton = voltarButton;
	}


	
	
}
