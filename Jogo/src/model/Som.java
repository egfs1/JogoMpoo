package model;

import java.applet.Applet;
import java.applet.AudioClip;

public class Som {
	
	private AudioClip atacar;
	
	public Som(){
		atacar = Applet.newAudioClip(this.getClass().getClassLoader().getResource("resources/swing.wav"));
	}

	public void atacarSom() {atacar.play();}
	
}