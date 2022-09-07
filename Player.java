package adventureGame;

import java.util.Scanner;

public class Player {

	private int damage,healthy,money,rHealth;
	private String name,cName;
	private Inventory inv;

	Scanner scan = new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
		this.inv = new Inventory();
	}

	

	//	Here, we are asking the player which character he would like to choose.
	public int chaMenu() { 				
		System.out.println("Select your characther '"+ this.name +"' :");
		System.out.println("1- Samurai :\t<damage = 5,  health = 21,  money = 15>");
		System.out.println("2- Archer :\t<damage = 7,  health = 18,  money = 20>");
		System.out.println("3- Knight :\t<damage = 8,  health = 24,  money = 5 >");
		int chaID = scan.nextInt();
		
		while(chaID<1 || chaID>3) {
			System.out.println("Plesae enter a valid number!");
			chaID = scan.nextInt();
		}
		return chaID;
	}
	
	//	Here, we are setting the "Cha" status.
	public void selectCha() {
		switch(chaMenu()) {		
		case 1:
			initPlayer("Samurai",5,21,15);
			break;
		case 2:
			initPlayer("Archer",7,18,20);
			break;
		case 3:
			initPlayer("Knight",8,24,5);
			break;
		default:	//	If player does not change anything or a bug happen, "Cha" will be automatically set "Samurai". 
			initPlayer("Samurai",5,21,15);
			break;
		}
		
		System.out.println("Vov! "+this.cName+" is a excellant choice "+this.name+". Now, we can start the journey.");
		
	}
	
	// Here, we are updating damage. (After buying some weapons.)
	public int getTotalDamage() {
		return this.getDamage()+this.getInv().getDamage();
	}
	
	//	Also here, we are setting the "Cha" status.
	public void initPlayer(String cName, int damage, int health, int money) {
		setcName(cName);
		setDamage(damage);
		setHealth(health);
		setMoney(money);
		setrHealth(health);
	}
	
//	Getter-Setter methods:
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return healthy;
	}

	public void setHealth(int healthy) {
		this.healthy = healthy;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}
	
	public int getrHealth() {
		return rHealth;
	}

	public void setrHealth(int rHealth) {
		this.rHealth = rHealth;
	}
	
	
	
	
	
}
