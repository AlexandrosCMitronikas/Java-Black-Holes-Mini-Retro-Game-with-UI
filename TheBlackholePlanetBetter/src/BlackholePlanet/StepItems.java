package BlackholePlanet;

public class StepItems {
	private String hitBoundary; 
	private Victory currentStatus;
	private int newX;
	private int newY;
	private int stepCount;
	
	public StepItems(String hitBoundary, Victory currentStatus,int newX, int newY, int stepCount) {
		this.hitBoundary=hitBoundary;
		this.currentStatus=currentStatus;
		this.newX=newX;
		this.newY=newY;
		this.stepCount=stepCount;
	}
	public Victory getCurrentStatus() {
		return currentStatus;
	}
	
	public int getStepCount() {
		return stepCount;
	}
	public String getHitBoundary() {
		return hitBoundary;
	}
	
	public int getNewX() {
		return newX;
	}
	
	public int getNewY() {
		return newY;
	}
	
	
	

}
