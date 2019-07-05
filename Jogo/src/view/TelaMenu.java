package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControllerMenu;

public class TelaMenu extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JButton comecarButton;
	JTextField nomeField;
	JLabel nomeLabel;
	
	
	public TelaMenu() {
		
		setSize(250,70);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		nomeField = new JTextField(10);
		nomeLabel = new JLabel("Insira o nome do personagem");
		comecarButton = new JButton("Começar");
		comecarButton.setBackground(Color.WHITE);
		
		add(nomeLabel);
		add(nomeField);
		add(comecarButton);
		
		ControllerMenu cm = new ControllerMenu(this);
		
		setVisible(true);
	}

	public JButton getComecarButton() {
		return comecarButton;
	}

	public void setComecarButton(JButton comecarButton) {
		this.comecarButton = comecarButton;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}
	
}
