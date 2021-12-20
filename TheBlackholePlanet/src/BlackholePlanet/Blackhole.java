package BlackholePlanet;

public class Blackhole extends GameObject{
	
	// Class made for checking blackhole existance and its removal after player position is identical.
	
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
	
	public static boolean isBlackholeThere(Blackhole [] blackholeArray, int x, int y, boolean isStarting) { //Method checking each blackhole in the array.
		for (int i = 0; i < blackholeArray.length; i++) { 
			if(blackholeArray[i] != null) {	
				if(!isStarting && blackholeArray[i].doesItExist() && blackholeArray[i].getPosX()==x && blackholeArray[i].getPosY()==y) { //Outcome if blackhole is met
					blackholeArray[i].removeBlackhole();
					return true;
				}
				else if(isStarting && blackholeArray[i].getPosX()==x && blackholeArray[i].getPosY()==y) //Outcome if blackhole is not met
					return true;
			}
		}
		return false;
	}
}
