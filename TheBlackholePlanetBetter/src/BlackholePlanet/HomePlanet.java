package BlackholePlanet;

public class HomePlanet extends GameObject{

	public HomePlanet(int x, int y) {
		super(x, y);
	}
	
	public boolean isHomePlanetThere(Player player) {
		if (player.getPosX() == posX && player.getPosY() == posY) 
			return true;
		else 
			return false;
	}
}
