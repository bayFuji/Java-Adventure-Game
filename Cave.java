package adventureGame;

//	This class is controlling the 'Cave' location.
public class Cave extends BattleLoc{

	Cave(Player player) {
		super(player, "Cave", new Zombie(),"Food");
	}

}
