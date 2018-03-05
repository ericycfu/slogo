package model.state;

/**
 * Holds attributes of turtle object
 * 
 * @author Katherine Van Dyk
 *
 */
public class State {
    private double xLocation;
    private double yLocation;
    private boolean penDown;
    private double headAngle;
    private boolean showing;
    private boolean clear;
    private int id;

    public State() {
		this.xLocation = 0;
		this.yLocation = 0;
		this.penDown = true;
		this.showing = true;
		this.headAngle = -90;
		this.clear = false;
		this.id = 1;
    }
    
    public State(int id) {
		this.xLocation = 0;
		this.yLocation = 0;
		this.penDown = true;
		this.showing = true;
		this.headAngle = -90;
		this.clear = false;
		this.id = id;
    }

    public State(State s) {
		this.xLocation = s.xLocation;
		this.yLocation = s.yLocation;
		this.penDown = s.penDown;
		this.headAngle = s.headAngle;
		this.showing = s.showing;
		this.clear = false;
		this.id = s.id;
    }

    public double getX() {
    	return this.xLocation;
    }

    public double getY() {
    	return this.yLocation;
    }

    public boolean getPen() {
    	return this.penDown;
    }

    public boolean getShowing() {
    	return this.showing;
    }
    
    public boolean getClear() {
    	return this.clear;
    }

    public double getAngle() {
    	return this.headAngle;
    }
    
    public int getID() {
    	return id;
    }
    
    public void setID(int id) {
    	this.id = id;
    }

    public void setPen(boolean penState) {
    	penDown = penState;
    }

    public void setShowing(boolean showState) {
    	showing = showState;
    }
    
    public void clearScreen() {
    	clear = true;
    }
    
    public double setAngle(double angle) {
    	double change = angle-headAngle;
    	headAngle = angle;
    	normalizeAngle();
		return change;
    }

    public void addAngle(double angle) {
		headAngle += angle;
		normalizeAngle();
    }

    private void normalizeAngle() {
    	if (headAngle >= 360) {
    		headAngle -= 360;
		}
    	else if (headAngle <= 0) {
    		headAngle += 360;
    	}
    }

    public void move(double magnitude) {
		xLocation += Math.cos(Math.toRadians(headAngle)) * magnitude;
		yLocation += Math.sin(Math.toRadians(headAngle)) * magnitude;
    }

    public String toString() {
    	return "<x="+xLocation+", y="+yLocation+", angle="+headAngle+", penUp="+penDown+", showing="+showing+", clear="+clear+">";
    }

    public void setXY(double x, double y) {
		xLocation = x;
		yLocation = y;
    }

}
