package BlackholePlanet;

public abstract class GameObject {
	
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
