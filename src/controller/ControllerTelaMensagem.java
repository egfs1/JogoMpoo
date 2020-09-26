package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaMensagem;

public class ControllerTelaMensagem implements ActionListener {
	
	public ControllerTelaMensagem(TelaMensagem tm) {
		
		tm.getVoltarButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				tm.dispose();
			}
		});
		
	}

	public void actionPerformed(ActionEvent arg0) {
		
	}
}
