package gearUp;

public class Armor extends Item {
	
	public void obtainArmor(int defense, int level) {
		System.out.println("Obtained platnum armor!");
		this.defense = defense;
		this.level = level;
	}
	
	@Override
	public void levelUp() {
		if (level < 2) {
			defense += 10;
			level ++;
			System.out.println("Armor Upgraded! Armor now have a cape.");
		}	
	}
}