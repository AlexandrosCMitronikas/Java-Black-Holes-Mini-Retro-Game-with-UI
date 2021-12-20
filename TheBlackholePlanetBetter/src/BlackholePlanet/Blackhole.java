package BlackholePlanet;

public class Blackhole extends GameObject{
	
	boolean exists;
	
	public Blackhole(int x, int y) {
		super(x, y);
		exists=true;
	}
	
	public void removeBlackhole() {
		exists=false;
	}
	
	public boolean doesItExist() {
		return exists;
	}
	
	public static boolean isBlackholeThere(Blackhole [] blackholeArray, int x, int y, boolean isStarting) {
		for (int i = 0; i < blackholeArray.length; i++) {
			if(blackholeArray[i] != null) {	
				if(!isStarting && blackholeArray[i].doesItExist() && blackholeArray[i].getPosX()==x && blackholeArray[i].getPosY()==y) {
					blackholeArray[i].removeBlackhole();
					return true;
				}
				else if(isStarting && blackholeArray[i].getPosX()==x && blackholeArray[i].getPosY()==y)
					return true;
			}
		}
		return false;
	}
}
