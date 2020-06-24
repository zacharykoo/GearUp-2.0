package gearUp;

import java.util.ArrayList;
import java.util.Scanner;

public class GameProgression {
	
	public Hero setStartGame(Hero hero) {
//		Make and set items to hero
		EnergyDrink energyDrink = new EnergyDrink();
		Armor armor = new Armor();
		Fans fans = new Fans();
		Metal metal = new Metal();
		Weights weights = new Weights();
		hero.setArmor(armor);
		hero.setEnergyDrink(energyDrink);
		hero.setFans(fans);
		hero.setMetal(metal);
		hero.setWeights(weights);
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter player's name: ");
		String name = input.nextLine();
		hero.setName(name);
		System.out.println("King: Hero "+ hero.getName() + ", please save us! The Demon King will attack us in 6 days. \nKing: Please gather up some materials, upgrade them and prepare for the battle! (Enter)");
		input.nextLine();
		System.out.println("You can obtain 1 thing/item a day, those items will level up everyday until MAX level is reached. MAX all items to beat Demon King.");
		System.out.println("\nItems: \n1.Fans \n2.Metal \n3.Armor \n4.EnergyDrink \n5.Weights \n");
		System.out.println("Type the number to get the item you want.");
		
		return hero;
	}
	
	public Hero gearUpPhase(Hero hero) {
		int itemChoose = getInput();
		
		int daysPassed = 0;
		ArrayList<Integer> pickedItems = new ArrayList<Integer>(5);
		while (daysPassed != 5) {
			pickedItems.add(itemChoose);
			UpdateAll(hero , itemChoose);
			daysPassed++;
			System.out.println("\nDay " + (daysPassed + 1)+ ": ");
			boolean isDuplicate;
			if (daysPassed != 5) {
				System.out.println("\nPick another item to Obtain, do not choose the same item.");
				printList(pickedItems);
				isDuplicate = true;
				while (isDuplicate == true) {
					itemChoose = getInput();
					isDuplicate = checkDuplicate(pickedItems, itemChoose);
				}
			}
		}
		return hero;
	}
	
	public void endingPhase(Hero hero) {
		DKing DKing = new DKing();
		Scanner input = new Scanner(System.in);
		printItemLV(hero);
		System.out.println("(Enter)");
		input.nextLine();
		System.out.println("\nThe time has come! The Demon King shows up, and it is time to fight.");
		hero.updateStats();
		printADHP(hero);
		System.out.println("(Enter)");
		input.nextLine();
		Battle(hero, DKing);
		input.close();
	}
	
	public static void printADHP (Hero hero) {
		System.out.println("\nYour Current Stats after preparing: \nAttack - " + hero.getAttack() + "\nDefense - " + hero.getDefense() + "\nHP - " + hero.HP);
	}
	
	public static void printItemLV(Hero hero) {
		
		System.out.println("\nFinal items Levels: ");
		
		if (hero.getFans().getLevel() == 3) {
			String FansMAX = "MAX";
			System.out.println("Fans - " + FansMAX);
		}
		else {
			System.out.println("Fans - " + hero.getFans().getLevel());
		}
		
		if (hero.getMetal().getLevel() == 4) {
			String MetalMAX = "MAX";
			System.out.println("Metal - " + MetalMAX);
		}
		else {
			System.out.println("Metal - " + hero.getMetal().getLevel());
		}
		
		if (hero.getArmor().getLevel()== 2) {
			String ArmorMAX = "MAX";
			System.out.println("Armor - " + ArmorMAX);
		}
		else {
			System.out.println("Armor - " + hero.getArmor().getLevel());
		}
		
		if (hero.getEnergyDrink().getLevel()== 1) {
			String EnergyDrinkMAX = "MAX";
			System.out.println("EnergyDrink - " + EnergyDrinkMAX);
		}
		else {
			System.out.println("EnergyDrink - " + hero.getEnergyDrink().getLevel());
		}
		
		if (hero.getWeight().getLevel() == 5) {
			String TrainMAX = "MAX";
			System.out.println("Weights - " + TrainMAX);
		}
		else {
			System.out.println("Weights - " + hero.getWeight().getLevel());
		}
	}
	
	public static int getInput () {
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        int userInput;
        while (true) {
            try {
                userInput = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid integer.");
                input.nextLine();
            }
        }
        while (userInput < 1 || userInput > 5) {
        	System.out.println("Please enter a number between 1-5");
        	input.nextLine();
        	userInput = input.nextInt();
        }
        return userInput;
    }
	
	
	
	public static boolean checkDuplicate (ArrayList<Integer> list, int userInput) {
		for (int num : list) {
			if (userInput == num) {
				System.out.println("Please enter a different item. You already obtained this item before.");
				return true;
			}
		}
		return false;
	}
	
	public static void UpdateAll (Hero hero, int choseItem) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		updateFans(hero, choseItem);
		updateMetal(hero, choseItem);
		updateArmor(hero, choseItem);
		updateEnergyDrink(hero, choseItem);
		updateWeights(hero, choseItem);
		System.out.println("(Enter)");
		scan.nextLine();
	}
	
	public static void updateFans(Hero hero, int choseItem) {
		if (hero.getFans().getLevel() == 0 && choseItem == 1) {
			hero.getFans().obtainFans(10, 1);
		}
		else if (hero.getFans().getLevel() != 0) {
			hero.getFans().levelUp();
		}
	}
	
	public static void updateMetal(Hero hero, int choseItem) {
		if (hero.getMetal().getLevel() ==0 && choseItem == 2) {
			hero.getMetal().obtainMetal(0, 1);
		}
		else if (hero.getMetal().getLevel() != 0) {
			hero.getMetal().levelUp();
		}
	}
	
	public static void updateArmor(Hero hero, int choseItem) {
		if (hero.getArmor().getLevel() == 0 && choseItem == 3) {
			hero.getArmor().obtainArmor(10, 1);
		}
		else if (hero.getArmor().getLevel() != 0) {
			hero.getArmor().levelUp();
		}
	}
	
	public static void updateEnergyDrink(Hero hero, int choseItem) {
		if (hero.getEnergyDrink().getLevel() == 0 && choseItem == 4) {
			hero.getEnergyDrink().obtainEnergyDrink(10, 1);
		}
		else if (hero.getEnergyDrink().getLevel() != 0) {
			hero.getEnergyDrink().levelUp();
		}
	}
	
	public static void updateWeights(Hero hero, int choseItem) {
		if (hero.getWeight().getLevel() == 0 && choseItem == 5) {
			hero.getWeight().obtainWeights(5, 5, 1);
		}
		else if (hero.getWeight().getLevel() != 0) {
			hero.getWeight().levelUp();
		}
	}
	
	public static void printList (ArrayList<Integer> list) {
		boolean fans, metal, armor, energyDrink, weights;
		fans = metal = armor = energyDrink = weights = false;
		for (int chose:list) {
			if (chose==1) {
				System.out.println("1. Fans - Obtained");
				fans = true;
			}
			else if (chose ==2) {
				System.out.println("2. Metal - Obtained");
				metal = true;
			}
			else if (chose == 3) {
				System.out.println("3. Armor - Obtained");
				armor = true;
			}
			else if (chose == 4) {
				System.out.println("4. EnergyDrink - Obtained");
				energyDrink = true;
			}
			else if (chose ==5 ) {
				System.out.println("5. Weight - Obtained");
				weights = true;
			}
		}
		System.out.println(" ");
		if (fans == false) {
			System.out.println("1. Fans");
		}
		if (metal == false) {
			System.out.println("2. Metal");
		}
		if (armor == false) {
			System.out.println("3. Armor");
		}
		if (energyDrink == false) {
			System.out.println("4. EnergyDrink");
		}
		if (weights == false) {
			System.out.println("5. Weight");
		}
	}
	
	public static void Battle (Hero hero, DKing DKing) {
		int DKingDamageDeal = (DKing.attack - hero.defense);
		int nowHeroHP = (hero.HP - DKingDamageDeal);
		int HeroDamageDeal = (hero.attack - DKing.defense);
		int nowDKingHP = (DKing.HP - HeroDamageDeal);
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nDemon King attacked you by surprise, dealing " + DKingDamageDeal + " damage. \nYou now have " + nowHeroHP + " HP left. (Enter)");
		scan.nextLine();
		if (nowHeroHP > 0) {
			System.out.println("\nYou strikes back with all your might, dealing " + HeroDamageDeal + " damage. \nYou are not sure how much HP the Demon King have, but it seems like your attack worked. (Enter)");
			scan.nextLine();
		}
		while (nowHeroHP > 0 && nowDKingHP > 0) {
			nowHeroHP -= DKingDamageDeal;
			System.out.println("\nDemon King attacks again, dealing " + DKingDamageDeal + " damage. \nYou now have " + nowHeroHP + " HP left. (Enter)");
			scan.nextLine();
			
			if (nowHeroHP > 0) {
				nowDKingHP -= HeroDamageDeal;
				System.out.println("\nYou strikes back with all your might, dealing " + HeroDamageDeal + " damage. (Enter)");
				scan.nextLine();
			}
		}
		
		if (nowHeroHP <= 0) {
			System.out.println("\nThe Demon King crushes you.");
			System.out.println("\nDemon King is too strong, you failed to beat him. GAME OVER");
			System.out.println("\n(Try obtaining the items in different order.)");
		}
		else {
			System.out.println("\nYou notice the Demon King is now very weak. You unleashed your last power; EXCALIBUR");
			System.out.println("The Demon King let out his final breathe and dropped.");
			System.out.println("\nYou have defeated the Demon King! You brought peace to the Kingdom. CONGRATULATION!!!");
		}
		
	}
	
}
