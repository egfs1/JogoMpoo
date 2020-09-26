package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class TelaMenu extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JButton singleplayerButton, multiplayerButton, continuarButton, instrucoesButton, sairButton, creditosButton;
	private JTextField nome1Field, nome2Field;
	private JLabel nome1Label, nome2Label;
	
	
	public TelaMenu() {
		
		setSize(512,512);
		setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		nome1Field = new JTextField(10);
		nome1Label = new JLabel("Player 1:");
		nome1Label.setBounds(15, 15, 60, 20);
		nome1Field.setBounds(75, 15, 100, 20);
		
		nome2Field = new JTextField(10);
		nome2Label = new JLabel("Player 2:");
		nome2Label.setBounds(200, 15, 60, 20);
		nome2Field.setBounds(260, 15, 100, 20);
		
		singleplayerButton = new JButton("Singleplayer");
		singleplayerButton.setBounds(380, 10, 120, 30);
		singleplayerButton.setBackground(Color.WHITE);
		
		multiplayerButton = new JButton("Multiplayer");
		multiplayerButton.setBounds(380, 60, 120, 30);
		multiplayerButton.setBackground(Color.white);
		
		continuarButton = new JButton("Continuar");
		continuarButton.setBounds(181, 150, 150, 50);
		continuarButton.setBackground(Color.WHITE);
		
		instrucoesButton = new JButton("Instruções");
		instrucoesButton.setBounds(181, 250, 150, 50);
		instrucoesButton.setBackground(Color.WHITE);
		
		creditosButton = new JButton("Créditos");
		creditosButton.setBounds(181, 350, 150, 50);
		creditosButton.setBackground(Color.WHITE);
		
		sairButton = new JButton("Sair");
		sairButton.setBounds(181, 450, 150, 50);
		sairButton.setBackground(Color.white);
		
		add(nome1Label);
		add(nome1Field);
		add(nome2Label);
		add(nome2Field);
		add(singleplayerButton);
		add(multiplayerButton);
		add(continuarButton);
		add(instrucoesButton);
		add(sairButton);
		add(creditosButton);
		
		setVisible(true);
	}

	public JButton getMultiplayerButton() {
		return multiplayerButton;
	}

	public void setMultiplayerButton(JButton multiplayerButton) {
		this.multiplayerButton = multiplayerButton;
	}

	public JButton getContinuarButton() {
		return continuarButton;
	}

	public void setContinuarButton(JButton continuarButton) {
		this.continuarButton = continuarButton;
	}

	public JButton getCreditosButton() {
		return creditosButton;
	}

	public void setCreditosButton(JButton creditosButton) {
		this.creditosButton = creditosButton;
	}

	public JButton getInstrucoesButton() {
		return instrucoesButton;
	}

	public void setInstrucoesButton(JButton instrucoesButton) {
		this.instrucoesButton = instrucoesButton;
	}

	public JButton getSairButton() {
		return sairButton;
	}

	public void setSairButton(JButton sairButton) {
		this.sairButton = sairButton;
	}

	public JTextField getNome2Field() {
		return nome2Field;
	}

	public void setNome2Field(JTextField nome2Field) {
		this.nome2Field = nome2Field;
	}

	public JButton getSingleplayerButton() {
		return singleplayerButton;
	}

	public void setSingleplayerButton(JButton singleplayerButton) {
		this.singleplayerButton = singleplayerButton;
	}

	public JTextField getNomeField() {
		return nome1Field;
	}

	public void setNomeField(JTextField nomeField) {
		this.nome1Field = nomeField;
	}
	
}
