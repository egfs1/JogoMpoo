package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaPergunta;

public class ControllerTelaPergunta implements ActionListener {
	
	public ControllerTelaPergunta(TelaPergunta tp) {
		
		tp.getSimButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tp.setResposta(true);
				tp.setVisible(false);
			}
		});
		
		tp.getNaoButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tp.setResposta(false);
				tp.setVisible(false);
			}
		});
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
