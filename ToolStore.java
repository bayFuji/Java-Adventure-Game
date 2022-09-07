
package adventureGame;

//	 This class is controlling "Tool Store".	

public class ToolStore extends NormalLoc{
	
	ToolStore(Player player) {
		super(player, "Tool Store");
	}

	//	First, user chooses the Weapons or Armors.
	public boolean getLocation() {
		System.out.println("Money you have: "+player.getMoney());
		System.out.println("1- Weapons");
		System.out.println("2- Armors");
		System.out.println("3- EXIT");
		
		int selItemID;
		boolean control = false;
		
		do {
			control = false;
			int selTool = scan.nextInt();
			switch(selTool) {
			case 1:
				buyWeapon();
				break;
			case 2:
				buyArmor();
				break;
			case 3:
				break;
			default:
				System.out.println("Please enter a valid number !!");
				control = true;
				break;
			}
			
		}while (control);
	
		return true;
	}
/*
	public int weaponMenu() {
		System.out.println("1- Weapon Tier.1 :\t<damage=2,  price=25>");
		System.out.println("2- Weapon Tier.2 :\t<damage=3,  price=35>");
		System.out.println("3- Weapon Tier.3 :\t<damage=5,  price=45>");
		System.out.println("4- EXIT");
		int selWeaponID = scan.nextInt();
		
		return selWeaponID;
	}
*/
	//	If user chooses "weapons", this function runs.
	public void buyWeapon() {
		int damage=0, price=0;
		String wName=null;
		boolean control1 = false;
		boolean control2 = false;
		
		System.out.println("1- Weapon Tier.1 :\t<damage = 2,  price = 25>");
		System.out.println("2- Weapon Tier.2 :\t<damage = 3,  price = 35>");
		System.out.println("3- Weapon Tier.3 :\t<damage = 5,  price = 45>");
		System.out.println("4- EXIT");
		
		do {
			control1 = false;
			int selWeaponID = scan.nextInt();

			switch(selWeaponID) {
			case 1:
				damage = 2;
				wName = "Weapon Tier.1";
				price = 25;
				break;
			case 2:
				damage = 3;
				wName = "Weapon Tier.2";
				price = 35;
				break;
			case 3:
				damage = 7;
				wName = "Weapon Tier.3";
				price = 45;
				break;
			case 4:
				System.out.println("");
				control2= true;
				break;
			default:
				System.out.println("Invalid choice !!");
				control1 = true;
				break;
			}
			
			if(price != 0 && !control1 && !control2) {
				if(player.getMoney()>=price) {
					player.getInv().setDamage(damage);
					player.getInv().setwName(wName);
					player.setMoney(player.getMoney()-price);
					System.out.println("Congrats warrior! You bought '"+wName+"'. Your new damage is: "+player.getDamage());
					System.out.println("Your curent money: "+player.getMoney());
				}
				else {
					control1 = true;
					System.out.println("Insufficient balance !!");
				}
			}
	
		} while (control1);
	}
/*	
	public int armorMenu() {
		System.out.println("1- Light Armor :\t<protection=1,  price=15>");
		System.out.println("2- Medium Armor :\t<protection=3,  price=25>");
		System.out.println("3- Heavy Armor :\t<protection=5,  price=40>");
		System.out.println("4- EXIT");
		int selWeaponID = scan.nextInt();
		
		return selWeaponID;
	}
*/	
	//	If user chooses "armors", this function runs.
	public void buyArmor() {
		int avoid=0, price=0;
		String aName=null;
		boolean control1 = false;
		boolean control2 = false;
		
		System.out.println("1- Light Armor :\t<protection = 1,  price = 15>");
		System.out.println("2- Medium Armor :\t<protection = 3,  price = 25>");
		System.out.println("3- Heavy Armor :\t<protection = 5,  price = 40>");
		System.out.println("4- EXIT");
		
		do {
			control1 = false;
			int selArmorID = scan.nextInt();
			
			switch(selArmorID) {
			case 1:
				avoid = 1;
				aName = "Light Armor";
				price = 15;
				break;
			case 2:
				avoid = 3;
				aName = "Medium Armor";
				price = 25;
				break;
			case 3:
				avoid = 5;
				aName = "Heavy Armor";
				price = 40;
				break;
			case 4:
				System.out.println("");
				control2= true;
				break;
			default:
				System.out.println("Invalid choice !!");
				control1 = true;
				break;
			}
			
			if(price != 0 && !control1 && !control2) {
				if(player.getMoney()>=price) {
					player.getInv().setArmor(avoid);
					player.getInv().setaName(aName);
					player.setMoney(player.getMoney()-price);
					System.out.println("Congrats warrior! You bought '"+aName+"'. Your new protection is: "+player.getInv().getArmor());
					System.out.println("Your curent money: "+player.getMoney());
				}
				else {
					control1 = true;
					System.out.println("Insufficient balance !!");
				}
			}
	
		} while (control1);
	}
	
}








