package view.turtle;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Encapsulates line drawing for turtle object
 * 
 * @author Katherine Van Dyk
 *
 */
public class TurtlePen {
    
    private Color COLOR;
    private int TURTLE_WIDTH;
    private int TURTLE_HEIGHT;
    private double previousX;
    private double previousY;
    
    public TurtlePen(Color color, int turtleWidth, int turtleHeight) {
	COLOR = color;
	TURTLE_WIDTH = turtleWidth;
	TURTLE_HEIGHT = turtleHeight;
	
    }
    
    public void setLocation(double x, double y) {
	previousX = x + TURTLE_WIDTH / 2;
	previousY = y + TURTLE_HEIGHT / 2;
    }
    
    public Line addLine(double x2, double y2) {
	Line l = new Line();
	l.setStartX(previousX); 
	l.setStartY(previousY); 
	l.setEndX(x2 + TURTLE_WIDTH/2); 
	l.setEndY(y2 + TURTLE_HEIGHT/2);
	l.setFill(COLOR);
	setLocation(x2, y2);
	return l;
    }

}