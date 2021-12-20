package BlackholePlanet;

public class Victory {

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
