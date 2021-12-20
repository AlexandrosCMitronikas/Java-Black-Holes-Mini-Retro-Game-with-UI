package BlackholePlanet;

public class Victory {
	//This class includes a boolean giving signal whether player has won. If so, the intended message will be displayed.
	
	private boolean hasWon=false;
	private String winMsg;
	
	
	public Victory (boolean hasWon, String winMsg) {
		this.hasWon=hasWon;
		this.winMsg=winMsg;
	}
	
	public boolean checkHasWon() {
		return hasWon;
	}
	
	public String getWinMsg() {
		return winMsg;
	}
}
