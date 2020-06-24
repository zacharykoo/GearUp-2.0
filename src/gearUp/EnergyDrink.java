package gearUp;

public class EnergyDrink extends Item{
	
	public void obtainEnergyDrink(int attack, int level) {
		this.attack = attack;
		this.level = level;
		System.out.println("Obtained BedRull!");
	}
	
	@Override
	public void levelUp() {
	}
}
