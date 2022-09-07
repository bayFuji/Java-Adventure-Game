package adventureGame;

//	This class is controlling dangerous locations like "Cave".

public abstract class BattleLoc extends Location{
	
	protected Obstacle obstacle;
	protected String award;
	
	BattleLoc(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		this.name = name;
		this.obstacle = obstacle;
		this.award = award;
	}
	
	//	Here, we are controlling the fight. 
	public boolean getLocation() {
		int obsCount = obstacle.obstacleCount();
		boolean control = false;
		
		System.out.println("You are in the '"+this.getName()+"' right now.");
		System.out.println("Be carefull warrior! There is '"+obsCount+"' "+obstacle.getName()+"'s living in the "+this.getName()+".");
		System.out.println("\n1- Fight!");
		System.out.println("2- Run!");
		
		do {
			int selCase = scan.nextInt();
		
			if(selCase==1) {
				if(combat(obsCount)) {
					System.out.println("You cleared all enemies in the '"+this.getName()+"' "+player.getName()+"!");
					if(this.award.equals("Food") && player.getInv().isFood()==false) {
						System.out.println("Also earned "+this.award+".");
						player.getInv().setFood(true);
					}else if (this.award.equals("Wood") && player.getInv().isWood()==false) {
						System.out.println("Also earned "+this.award+".");
						player.getInv().setWood(true);
					}else if (this.award.equals("Water") && player.getInv().isWater()==false) {
						System.out.println("Also earned "+this.award+".");
						player.getInv().setWater(true);
					}
					return true;
				}
				else if(!combat(obsCount)) {
					System.out.println("!! You Died !!");
					return false;
				}
					
			
			}
			else if(selCase==2) {
				System.out.println("You are running away from '"+this.getName()+"'.");
			}
			else {
				System.out.println("Please write a valid number!!");
				control = true;
			}	
		}while(control);
		
		return true;
	}
	
	
	//	This function is controlling the combat system.
	public boolean combat(int obsCount) {
		for(int i=0; i<obsCount ; i++) {
		int defultObsHealth = obstacle.getHealth();
		
			playerStats();
			enemyStats();
			
			while(player.getHealth()>0 && obstacle.getHealth()>0) {
				System.out.println("1- Hit!\n2- Run!");
				int selCase = scan.nextInt();
				
				if(selCase==1) {
					System.out.println("You hit '"+player.getDamage()+"' damage to "+obstacle.getName());
					obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());
					
					if(obstacle.getHealth()>0) {
						System.out.println(obstacle.getName()+" hit '"+obstacle.getDamage()+"-"+player.getInv().getArmor()+"' damage to you!\n");
						player.setHealth(player.getHealth()-(obstacle.getDamage()-player.getInv().getArmor()));
					}
					playerStats();
					enemyStats();
				}
				else {
					break;
				}
			}
			
			if(obstacle.getHealth()<=0 && player.getHealth()>0) {
				System.out.println();
				System.out.println("You earned "+obstacle.getAward()+" money from "+obstacle.getName()+".");
				player.setMoney(player.getMoney()+obstacle.getAward());
				System.out.println("Your actual budget: "+player.getMoney()+"\n");
				obstacle.setHealth(defultObsHealth);
			}
		
			else {
				return false;
			}
		}
		
		
		return true;
	}

	public void playerStats() {
		System.out.println("Your stats:\r\nHealth = "+player.getHealth()+",  Damage = "+player.getTotalDamage());
		System.out.println("-------------------------");
	}

	public void enemyStats() {
		System.out.println(obstacle.getName()+"'s stats:\r\nHealth = "+obstacle.getHealth()+",  Damage = "+obstacle.getDamage()+"\n");
	}
	
	
	
	
	
	
}

