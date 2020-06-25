package gearUp;

public class Metal extends Item {
	
	public void obtainMetal (int attack, int level) {
		this.attack = attack;
		this.level = level;
		System.out.println("Obtained a piece of metal!");
	}
	
	@Override
	public void levelUp() {
		if (level == 1) {
			System.out.println("Metal Upgraded! Bronze sword created from Metal.");
		}
		else if (level == 2) {
			System.out.println("Metal Upgraded! Silver sword created from Metal.");
		}
		else if (level == 3) {
			System.out.println("Metal Upgraded! Diamond sword created from Metal.");
		}
		
		if (level < 4) {
			level++;
			attack += 20;
		}
	}
}

