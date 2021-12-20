package BlackholePlanet;

public class Player extends GameObject{
	
	private int lastX, lastY;

	public Player(int x, int y) {
		super(x, y);
		lastX=posX;
		lastY=posY;
	}
	
	public void changeX(int x) {
		lastX=posX;
		lastY=posY;
		posX = x;
	}
	public void changeY(int y) {
		lastX=posX;
		lastY=posY;
		posY = y;
	}
	public boolean playerOnBlackhole (Blackhole [] blackholeArray) {
		for (int i=0; i<blackholeArray.length; i++) {
			if (blackholeArray[i].doesItExist() && posX==blackholeArray[i].getPosX() && posY==blackholeArray[i].getPosY()) {
				blackholeArray[i].removeBlackhole();
				return true;
			}
		}
		return false;
	}
	public int getLastX() {
		return lastX;
	}

	public int getLastY() {
		return lastY;
	}
}
