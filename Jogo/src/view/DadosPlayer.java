package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import model.Player;

public class DadosPlayer extends JFrame {
	
	JFrame frame;
	Player player;
	JTextPane pane;
	
	public DadosPlayer(JFrame frame, Player player) {
		
        setSize(70, 70);
        setUndecorated(true);
        setLocationRelativeTo(frame);
        
        
        pane = new JTextPane();
        add(pane, BorderLayout.CENTER);
        pane.setEditable(false);
        

        pane.setText(player.getVida()+ "\n" +
        			 player.getXp() + "\n"  +
        			 (player.getLevel()));
        
   
        setVisible(false);

	}
	
}