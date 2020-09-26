package App;

import controller.ControllerMenu;
import view.TelaMenu;

public class App {

	public static void main(String[] args) {
		TelaMenu tm = new TelaMenu();
		ControllerMenu cm = new ControllerMenu(tm);
		
	}
}
