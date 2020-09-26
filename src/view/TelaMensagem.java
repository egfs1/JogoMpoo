package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TelaMensagem extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JButton voltarButton;
	private JTextArea textArea;
	private JPanel panel;
	
	public TelaMensagem(String string) {
		
		setSize(400, 250);
		setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		panel.setSize(getWidth(), getHeight());
		
		textArea = new JTextArea();
		textArea.setBounds(15, 15, 370, 150);
		textArea.setEditable(false);
		textArea.setFont(new Font("", Font.TYPE1_FONT,14));
		textArea.setBackground(Color.white);
		
		textArea.setText(string);
		
		voltarButton = new JButton("Voltar");
		voltarButton.setBounds(125, 190, 150, 50);
		voltarButton.setBackground(Color.WHITE);
		
		
		panel.add(textArea);
		panel.add(voltarButton);
		
		add(panel);
		
		setVisible(true);
	}

	public JButton getVoltarButton() {
		return voltarButton;
	}

	public void setVoltarButton(JButton voltarButton) {
		this.voltarButton = voltarButton;
	}
}
