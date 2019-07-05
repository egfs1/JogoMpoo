package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaInventario;

public class ControllerInventario implements ActionListener {
	
	TelaInventario ti;
	
	public ControllerInventario(TelaInventario ti) {
		this.ti = ti;
		
		this.ti.getVoltarButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ti.dispose();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
