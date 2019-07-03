package App;

import model.Player;
import view.Game;

public class App {

	public static void main(String[] args) {
		Player player = new Player("Eduardo");
		
		Game game = new Game(player);
		new Thread(game).start();
		game.run();

		
	}

}
