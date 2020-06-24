package gearUp;

public class Main {

	public static void main(String[] args) {
		
		Hero hero = new Hero();
		
		GameProgression gameProgress = new GameProgression();
		
		hero = gameProgress.setStartGame(hero);
		
		hero = gameProgress.gearUpPhase(hero);
		
		gameProgress.endingPhase(hero);
	}
}
