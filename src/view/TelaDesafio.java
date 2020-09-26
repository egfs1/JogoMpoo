package view;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaDesafio extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Random random = new Random();
	private JButton alternativa1, alternativa2;
	private JLabel pergunta1, pergunta2, pergunta3;
	private JPanel panel1, panel2, panel3;
	private String p1, resultado1, p2, resultado2, p3, resultado3;
	private int n_pergunta=0;
	
	public TelaDesafio() {
		
		ArrayList<String> linhas = new ArrayList<>();
		InputStream input = getClass().getClassLoader().getResourceAsStream("Questoes.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		String linha="";
			
		try {
			while ((linha = br.readLine()) != null)
				linhas.add(linha);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int x = random.nextInt(linhas.size());
		
		StringTokenizer token1 = new StringTokenizer(linhas.get(x), ",");
		p1 = token1.nextToken();
		resultado1 = token1.nextToken();
		
		int y = random.nextInt(linhas.size());
		
		StringTokenizer token2 = new StringTokenizer(linhas.get(y), ",");
		p2 = token2.nextToken();
		resultado2 = token2.nextToken();
		
		int z = random.nextInt(linhas.size());
		
		StringTokenizer token3 = new StringTokenizer(linhas.get(z), ",");
		p3 = token3.nextToken();
		resultado3 = token3.nextToken();
		
		setSize(300, 300);
		setLocationRelativeTo(null);
		setLayout(null);
		setUndecorated(true);
		setResizable(false);
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(Color.GRAY);
		panel1.setSize(getWidth(), getHeight());
		
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(Color.GRAY);
		panel2.setSize(getWidth(), getHeight());
		panel2.setVisible(false);
		
		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBackground(Color.GRAY);
		panel3.setSize(getWidth(), getHeight());
		panel3.setVisible(false);
		
		this.pergunta1 = new JLabel(p1);
		this.pergunta1.setFont(new Font("", Font.TYPE1_FONT,30));
		this.pergunta1.setBounds((getWidth()/2)-(18*p1.length()/2), 120, 20*p1.length(), 30);
		
		this.pergunta2 = new JLabel(p2);
		this.pergunta2.setFont(new Font("", Font.TYPE1_FONT,30));
		this.pergunta2.setBounds((getWidth()/2)-(18*p2.length()/2), 120, 20*p2.length(), 30);
		
		this.pergunta3 = new JLabel(p3);
		this.pergunta3.setFont(new Font("", Font.TYPE1_FONT,30));
		this.pergunta3.setBounds((getWidth()/2)-(18*p3.length()/2), 120, 20*p3.length(), 30);
		
		alternativa1 = new JButton("True");
		alternativa1.setBounds(30, 230, 100, 50);
		alternativa1.setBackground(Color.white);
		
		alternativa2 = new JButton("False");
		alternativa2.setBounds(170, 230, 100, 50);
		alternativa2.setBackground(Color.white);
		
		panel1.add(this.pergunta1);
		
		panel2.add(this.pergunta2);
		
		panel3.add(this.pergunta3);
		
		add(alternativa1);
		add(alternativa2);
		add(panel1);
		add(panel2);
		add(panel3);
		
		setVisible(true);
	}

	public JButton getAlternativa1() {
		return alternativa1;
	}

	public void setAlternativa1(JButton alternativa1) {
		this.alternativa1 = alternativa1;
	}

	public JButton getAlternativa2() {
		return alternativa2;
	}

	public void setAlternativa2(JButton alternativa2) {
		this.alternativa2 = alternativa2;
	}
	
	public String getResultado1() {
		return resultado1;
	}

	public String getResultado2() {
		return resultado2;
	}

	public String getResultado3() {
		return resultado3;
	}

	public int getN_pergunta() {
		return n_pergunta;
	}

	public JPanel getPanel1() {
		return panel1;
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public JPanel getPanel3() {
		return panel3;
	}

	public void setN_pergunta(int n_pergunta) {
		this.n_pergunta = n_pergunta;
	}
	
}
