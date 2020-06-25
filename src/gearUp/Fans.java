package gearUp;

public class Fans extends Item {
	
	public void obtainFans(int attack, int level) {
		this.attack = attack;
		this.level = level;
		System.out.println("You got popular! You now have 50 Fans!");
	}

	@Override
	public void levelUp() {
		if (level == 1) {
			System.out.println("Fans Upgrade! You became more popular! You now have 100 Fans!");
		}
		else if (level == 2) {
			System.out.println("Fans Upgrade! You became more popular! You now have 500 Fans!");
		}
		if (level < 3) {
			level ++;
			attack += 10;	
		}
	}
}
