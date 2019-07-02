package App;

import view.Game;

public class App {

	public static void main(String[] args) {
		Game game = new Game();
		new Thread(game).start();
		game.run();
		
	}

}
