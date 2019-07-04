package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import model.Player;

public class TelaDadosPlayer extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JFrame frame;
	Player player;
	JTextPane pane;
	
	public TelaDadosPlayer(JFrame frame, Player player) {
		
        setSize(70, 80);
        setUndecorated(true);
        setLocationRelativeTo(frame);
        
        pane = new JTextPane();
        add(pane, BorderLayout.CENTER);
        pane.setEditable(false);
        
        pane.setBackground(Color.GRAY);

        pane.setText(player.getVida()+ "");
        
        setVisible(false);

	}
	
}