package adventureGame;

//	This class is controlling the "Safe House".

public class SafeHouse extends NormalLoc{

	SafeHouse(Player player) {
		super(player, "Safe House");
	}

	//	Here, if boolean corrects the dead/live control, safehouse features are implemented.
	public boolean getLocation() {
		player.setHealth(player.getrHealth());
		System.out.println("You are in Safe House right now.");
		System.out.println("Your health is renewed = "+player.getrHealth());
		return true;
	}
	
}