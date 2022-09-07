package adventureGame;

//	This class is controlling Inventory.

public class Inventory {

	private boolean water,food,wood;
	private String wName, aName;
	private int damage, armor;
	
	Inventory(){
		this.water=false;
		this.food=false;
		this.wood=false;
		this.armor=0;
		this.damage=0;
		this.wName=null;
		this.aName=null;
	}

	public boolean isWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}

	public boolean isFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public boolean isWood() {
		return wood;
	}

	public void setWood(boolean wood) {
		this.wood = wood;
	}

	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	
	
}
