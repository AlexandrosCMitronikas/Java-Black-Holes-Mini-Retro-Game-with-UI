package BlackholePlanet;

import java.util.Random;

public class TheGame {
	
	private static Blackhole[] blackholeArray = new Blackhole[60]; //array of active blackholes
	private static Player player; //declaring player for using coordinates
	private static HomePlanet homePlanet;
	private static Random random = new Random();
	private static String msg="";
	private static int stepCount;
	private static double oldDistance=0;
	
	public static StepItems begin() {
		
		stepCount=0;
		int x = random.nextInt(19), y = random.nextInt(29);
		homePlanet = new HomePlanet(x,y);
	
		
		while (x==homePlanet.getPosX() && y==homePlanet.getPosY()) {
			x = random.nextInt(19);
			y = random.nextInt(29);
		}
		player = new Player(x,y);
		
		for (int i=0; i<60; i++) {
			while (x==homePlanet.getPosX() && y==homePlanet.getPosY() || x==player.getPosX() && y==player.getPosY() || Blackhole.isBlackholeThere(blackholeArray, x, y, true)) {
				x = random.nextInt(19);
				y = random.nextInt(29);
			}
			blackholeArray[i] = new Blackhole(x,y);	
			//System.out.println(x + "-" + y);
		}
		System.out.println("|=== The game has begun. ===|");
		getStatusMsg(); // to initialize the distance of the player.
		return new StepItems("Time is ticking!", new Victory (false, "Here you'll find valuable information.") ,player.getPosX(), player.getPosY(), stepCount);
	}
	
	public static StepItems MovingUp() {
		stepCount++;
		if(player.getPosY()==29) {
			return new StepItems("Reached the top of this Universe.", getStatusMsg() , player.getPosX(), player.getPosY(),stepCount);
		}
		player.changeY(player.getPosY()+1);
		return new StepItems("", getStatusMsg(),player.getPosX(), player.getPosY(), stepCount);
	}
	public static StepItems MovingDown() {
		stepCount++;
		if(player.getPosY()==0) {
			return new StepItems("Reached the bottom of this Universe.", getStatusMsg() , player.getPosX(), player.getPosY(), stepCount);
		}
		player.changeY(player.getPosY()-1);
		return new StepItems("", getStatusMsg(),player.getPosX(), player.getPosY(), stepCount);
	}
	public static StepItems MovingRight() {
		stepCount++;
		if(player.getPosX()==19) {
			return new StepItems("Reached the end of this Universe.", getStatusMsg() , player.getPosX(), player.getPosY(), stepCount);
		}
		player.changeX(player.getPosX()+1);
		return new StepItems("", getStatusMsg(),player.getPosX(), player.getPosY(), stepCount);
	}
	public static StepItems MovingLeft() {
		stepCount++;
		if(player.getPosX()==0) {
			return new StepItems("Reached the begining of this Universe.", getStatusMsg() , player.getPosX(), player.getPosY(), stepCount);
		}
		player.changeX(player.getPosX()-1);
		return new StepItems("", getStatusMsg(),player.getPosX(), player.getPosY(), stepCount);
	}
	public static StepItems MovingDownRight() {
		stepCount++;
		msg="";
		if(player.getPosX()==19) {
			msg += "Reached the end of this Universe. \n";
		}	
		else player.changeX(player.getPosX()+1);
		
		if(player.getPosY()==0) {
			msg += "Reached the bottom of this Universe.";
		}
		else player.changeY(player.getPosY()-1);
		return new StepItems(msg, getStatusMsg() , player.getPosX(), player.getPosY(), stepCount); 
	}
	public static StepItems MovingDownLeft() {
		stepCount++;
		msg="";
		if(player.getPosX()==0) {
			msg += "Reached the begining of this Universe. \n";
		}
		else player.changeX(player.getPosX()-1);
		if(player.getPosY()==0) {
			msg += "Reached the bottom of this Universe.";
		}
		else player.changeY(player.getPosY()-1);
		return new StepItems(msg, getStatusMsg() , player.getPosX(), player.getPosY(), stepCount); 
	}	
	public static StepItems MovingUpRight() {
		stepCount++;
		msg="";
		if(player.getPosX()==19) {
			msg += "Reached the end of this Universe. \n";
		}
		else player.changeX(player.getPosX()+1);
		if(player.getPosY()==29) {
			msg += "Reached the top of this Universe.";
		}
		else player.changeY(player.getPosY()+1);
		return new StepItems(msg, getStatusMsg() , player.getPosX(), player.getPosY(), stepCount);
	}
	public static StepItems MovingUpLeft() {
		stepCount++;
		msg="";
		if(player.getPosX()==0) {
			msg += "Reached the beggining of this Universe. \n";
		}
		else player.changeX(player.getPosX()-1);
		if(player.getPosY()==29) {
			msg += "Reached the top of this Universe.";
		}
		else player.changeY(player.getPosY()+1);
		return new StepItems(msg, getStatusMsg() , player.getPosX(), player.getPosY(), stepCount);
	}

	private static Victory getStatusMsg() {
		if(homePlanet.getPosX() == player.getPosX() && homePlanet.getPosY() == player.getPosY()) {
			
			return new Victory(true,"You've reached your homeplanet!!!");
		}
	
		else if(Blackhole.isBlackholeThere(blackholeArray, player.getPosX(), player.getPosY(),false)) {
			player.changeX(player.getLastX());
			player.changeY(player.getLastY());
			return new Victory (false, "Hold up! Destroying the black hole!");
		}
		String distMessage="";
		double distance = Math.sqrt(Math.pow(Math.abs(player.getPosX() - homePlanet.getPosX()), 2) + Math.pow(Math.abs(player.getPosY() - homePlanet.getPosY()), 2));
		if (distance > oldDistance) {
			distMessage = "Moving further from homeplanet.\n";
        }
        else if (distance < oldDistance) {
        	distMessage = "Moving closer to homeplanet.\n";
        }
        else if (distance == oldDistance) {
        	distMessage = "Not even moving! Just wasting gas.\n";
        }
		oldDistance = distance;
		return new Victory (false, distMessage);
	}
	
	
}
