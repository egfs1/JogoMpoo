package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TelaPergunta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton simButton, naoButton;
	private JTextArea textArea;
	private JPanel panel;
	boolean resposta;

	public TelaPergunta(String string) {
		
		setSize(300, 300);
		setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		panel.setSize(getWidth(), getHeight());
		
		textArea = new JTextArea();
		textArea.setBounds(15, 15, 270, 220);
		textArea.setEditable(false);
		textArea.setFont(new Font("", Font.TYPE1_FONT,14));
		
		textArea.setText(string);
		
		simButton = new JButton("Sim");
		simButton.setBounds(15, 242, 100, 50);
		simButton.setBackground(Color.WHITE);
		
		naoButton = new JButton("Não");
		naoButton.setBounds(250, 242, 100, 50);
		naoButton.setBackground(Color.WHITE);
		
		
		panel.add(textArea);
		panel.add(simButton);
		panel.add(naoButton);
		
		add(panel);
		
		setVisible(true);
	}

	public JButton getSimButton() {
		return simButton;
	}

	public void setSimButton(JButton simButton) {
		this.simButton = simButton;
	}

	public JButton getNaoButton() {
		return naoButton;
	}

	public void setNaoButton(JButton naoButton) {
		this.naoButton = naoButton;
	}

	public boolean isResposta() {
		return resposta;
	}

	public void setResposta(boolean resposta) {
		this.resposta = resposta;
	}
	
}
