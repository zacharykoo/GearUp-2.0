package gearUp;

public class Weights extends Item {
	
	public void obtainWeights(int attack, int defense, int level) {
		this.attack = attack;
		this.defense = defense;
		this.level = level;
		System.out.println("Obtained Weights, you can now train with 5kg weights.");
	}

	@Override
	public void levelUp() {
		if (level == 1) {
			System.out.println("Weights Upgrade! You can now train with 10kg weights.");
		}
		if (level == 2) {
			System.out.println("Weights Upgrade! You can now train with 50kg weights.");
		}
		if (level == 3) {
			System.out.println("Weights Upgrade! You can now train with 100kg weights.");
		}
		if (level == 4) {
			System.out.println("Weights Upgrade! You can now train with 999kg weights.");
		}
		
		if (level < 5) {
			level++;
			attack += 5;
			defense += 5;
		}
	}
}
