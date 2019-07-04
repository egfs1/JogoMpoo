package App;

import model.Player;
import view.TelaGame;

public class App {

	public static void main(String[] args) {
		
		
		Player player = new Player("Eduardo");
		
		TelaGame game = new TelaGame(player);
		new Thread(game).start();
		game.run();
	}

}
