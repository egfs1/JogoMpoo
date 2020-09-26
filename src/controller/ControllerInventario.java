package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaInventario;

public class ControllerInventario implements ActionListener {
	
	private TelaInventario ti;
	
	public ControllerInventario(TelaInventario ti) {
		this.ti = ti;
		
		this.ti.getVoltarButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ti.dispose();
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		
	}
	
	
}
