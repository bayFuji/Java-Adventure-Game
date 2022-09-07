package adventureGame;

import java.util.Scanner;

public class Game {

	Player player;
	Location location;
	
	public void login() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to 'Adventure Game' !");
		System.out.println("Please enter your name, warrior: ");
		
		String playerName = scan.nextLine();
		player = new Player(playerName);
		
		player.selectCha();
		
		start();
	
	}
	
	//	Here, player selects his location to go.
	public void start() {
		Scanner scan = new Scanner(System.in);

		while(true) {
			System.out.println("\r===========================================================================\r");
			System.out.println("Where you wanna go right now? :");
			System.out.println("1- Safe House --> Your safety place. No enemies.");
			System.out.println("2- Cave --> You may found some 'food' in here. But be carefull for 'zombies' !");
			System.out.println("3- Forest --> Yo may found some 'wood' in here. But be carefull for 'vampires' !");
			System.out.println("4- Lake --> Yo may found some 'water' in here. But be carefull for 'bears' !");
			System.out.println("5- Tool Store --> You can buy some tools in here.");
		
			int selLoc = scan.nextInt();
			
			while (selLoc<0 || selLoc>5) {
				System.out.println("Pleas select a valid place to go!");
				selLoc = scan.nextInt();
			}
		
			switch(selLoc) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new Lake(player);
				break;
			case 5:
				location = new ToolStore(player);
			break;
			default:
				location = new SafeHouse(player);
				break;
				
			}
			
			String needed ="";
			
			if(selLoc==1) {
				
				if(!player.getInv().isFood()) {
					needed = needed + ", food ";
				}
				if(!player.getInv().isWood()) {
					needed = needed + ", wood ";
			
				}
				if(!player.getInv().isWater()) {
					needed = needed + ", water ";
				}
				
				else if(player.getInv().isFood() && player.getInv().isWater() && player.getInv().isWood()) {
					System.out.println("!! Congrulations "+ player.getName() +". You collect all the rewards to won the game. !!");
					System.out.println("!! You Won !!");
					break;
				}
				
				needed = needed.substring(1);
				System.out.println("You need '"+needed+"' to won the game.");
			}
			
			if(!location.getLocation()){
				System.out.println("!! Game Over !!");
				break;
			}	
		}
	}
		
}
