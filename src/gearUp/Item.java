package gearUp;

public abstract class Item {
	
	int defense;
	int attack;
	int level;
	
	public abstract void levelUp();
	
	public int getAttack() {
		return attack;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public int getLevel() {
		return level;
	}
}
