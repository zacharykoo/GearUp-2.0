package gearUp;

public class Hero {
	
	int defense;
	int attack;
	int HP = 100;
	String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
// Energy Drink related
	EnergyDrink energyDrink;
	
	public void setEnergyDrink (EnergyDrink energyDrink) {
		this.energyDrink = energyDrink;
	}
	
	public EnergyDrink getEnergyDrink() {
		return energyDrink;
	}
	
//	Armor related
	
	Armor armor;
	
	public void setArmor(Armor armor) {
		this.armor = armor;
	}
	
	public Armor getArmor() {
		return armor;
	}
	
// Fans related
	Fans fans;
	
	public void setFans(Fans fans) {
		this.fans = fans;
	}
	
	public Fans getFans() {
		return fans;
	}
	
// Metal related
	Metal metal;
	
	public void setMetal(Metal metal) {
		this.metal = metal;
	}
	
	public Metal getMetal() {
		return metal;
	}

// Weights related
	Weights weights;
	
	public void setWeights(Weights weights) {
		this.weights = weights;
	}
	
	public Weights getWeight() {
		return weights;
	}
	
	public void updateStats() {
		this.defense = (this.getArmor().getDefense() + this.getWeight().getDefense());
		this.attack = (this.getEnergyDrink().getAttack() + this.getFans().getAttack() + this.getMetal().getAttack() + this.getWeight().getAttack());
	}
	
	public int getAttack() {
		return attack;
	}
	
	public int getDefense() {
		return defense;
	}
}
