package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.ControllerInventario;
import model.Item;
import model.Player;

public class TelaInventario extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JButton voltarButton;
	private JTextArea textAreaItems;
	private JPanel panel;
	
	public TelaInventario(Player player) {		
		setSize(512,512);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		
		panel = new JPanel();
		panel.setSize(520,520);
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		
		voltarButton = new JButton("Voltar");
		voltarButton.setFont(new Font("", Font.TYPE1_FONT,15));
		voltarButton.setBackground(Color.WHITE);
		textAreaItems = new JTextArea();
		textAreaItems.setFont(new Font("", Font.TYPE1_FONT,15));
//		textAreaItems.setBackground(Color.WHITE);
		
		textAreaItems.setEditable(false);
		String s="";
		for (Item i: player.items) {
			s += "\n      ";
			s += i.getNome();
		}
		if (s=="") {s = "\n      Você não possui nenhum Item";}
		textAreaItems.setText(s);
		
		voltarButton.setBounds(206, getWidth()-50, 100, 30);
		textAreaItems.setBounds(20, 20, getWidth()-40, getHeight()-100);
		
		panel.add(voltarButton);
		panel.add(textAreaItems);
		
		getContentPane().add(panel);
		
		ControllerInventario ci = new ControllerInventario(this);
		
		setVisible(true);
	}

	public JButton getVoltarButton() {
		return voltarButton;
	}

	public void setVoltarButton(JButton voltarButton) {
		this.voltarButton = voltarButton;
	}


	
	
}
