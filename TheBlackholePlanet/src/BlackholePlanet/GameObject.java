package BlackholePlanet;

public abstract class GameObject {
	
	// Class made to represent x and y position coordinates of each object of the programm.
	
	int posX, posY;

	public GameObject(int x, int y) {
		
		posX=x;
		posY=y;
		
	}
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
}
