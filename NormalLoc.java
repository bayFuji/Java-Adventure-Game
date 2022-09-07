package adventureGame;

//	This class is controlling safety locations like "Safe House".

public abstract class NormalLoc extends Location {

	NormalLoc(Player player, String name) {
		super(player);
		this.name = name;
	}

	public boolean getLocation() {
		return true;
	}
	
}
