package view.panels;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ResourceBundle;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class StatePanel {

    private final String TURTLE_IMAGE = "resources/turtles/defaultTurtle.png";
    private final String WEBSITE = "https://www2.cs.duke.edu/courses/compsci308/spring18/assign/03_slogo/commands.php";   
    private final ResourceBundle COLOR_RESOURCES = ResourceBundle.getBundle("resources/settings/colors");
    private Text COLOR;
    private Text xPOS;
    private Text yPOS;
    private Rectangle LINE;
    private Image IMAGE;
    private HBox pane;
    
    public StatePanel() {
	xPOS = posText((int) 0);
	yPOS = posText((int) 0);
	LINE = makeLine(Color.BLACK);
	COLOR = colorText(Color.BLACK);
	IMAGE = makeImage(TURTLE_IMAGE);
    }

    public HBox construct() {
	HBox buttons = new HBox(12, makePaletteButton(), makePenButton(), createHelpButton(), makeOpenButton());
	HBox save = new HBox(12, getFileName(), makeSaveButton());
	VBox rightSide = new VBox(12, save, buttons);
	HBox currState = new HBox(24, turtleInfo(), penColor(), xPosition(),yPosition());
	currState.setId("bottompane");
	pane = new HBox(12, currState, rightSide);
	return pane;
    }

    public void updatePane(String img, Color pC, double xPos, double yPos) {
	xPOS = posText((int) xPos);
	yPOS = posText((int) yPos);
	LINE = makeLine(pC);
	COLOR = colorText(pC);
	IMAGE = makeImage(img);
	construct();
	System.out.println(pane.getChildren().indexOf(yPOS));
    }
    
    private Button makePaletteButton() {
	return buttonFactory("/resources/images/palette.png");
    }

    private Button makePenButton() {
	return buttonFactory("/resources/images/pen.png");
    }

    private Button makeOpenButton() {
	return buttonFactory("/resources/images/open.png");
    }

    private TextField getFileName() {
	TextField file = new TextField();
	file.setPromptText("Workspace name...");
	file.setId("fileLine");
	return file;
    }

    private Button makeSaveButton() {
	return buttonFactory("/resources/images/save.png");
    }

    private VBox turtleInfo() {
	Text text = new Text("ID: " + "1");
	text.setId("label");
	return new VBox(12, new ImageView(IMAGE), text);
    }
    
    private Image makeImage(String img) {
	return new Image(getClass().getClassLoader().getResourceAsStream((img)));
    }

    private VBox penColor() {
	VBox res = new VBox(12, LINE, COLOR);
	VBox.setMargin(LINE, new Insets(0, 40, 0, 40));
	return res;
    }
    
    private Rectangle makeLine(Color c) {
	Rectangle l =  createLine(1, c);
	return l;
    }
    
    private Text colorText(Color c) {
	String color = getColor(c);
	Text text = new Text("Pen: " + color + " " + "1 pt");
	text.setId("label");
	return text;
    }

    private VBox xPosition() {
	Text text = new Text("X-Pos");
	text.setId("label");
	Text pos = new Text(xPOS.toString());
	pos.setId("position");
	return new VBox(12, xPOS, text);
    }
    
    private Text posText(int x) {
	Text pos = new Text(Integer.toString(x));
	pos.setId("position");
	return pos;
    }

    private VBox yPosition() {
	Text text = new Text("Y-Pos");
	text.setId("label");
	return new VBox(12, yPOS, text);
    }

    private String getColor(Color c) {
	String hex = String.format( "#%02X%02X%02X",
		(int)( c.getRed() * 255 ),
		(int)( c.getGreen() * 255 ),
		(int)( c.getBlue() * 255 ) );
	for(String key : COLOR_RESOURCES.keySet()) {
	    if(COLOR_RESOURCES.getString(key).equals(hex)) {
		return key;
	    }
	}
	return null;
    }

    private Rectangle createLine(int thickness, Color c) {
	Rectangle pen = new Rectangle(thickness, 45);
	pen.setFill(c);
	return pen;
    }

    private Button buttonFactory(String stringImage) {
	Button button = new Button();
	Image img = new Image(getClass().getResourceAsStream(stringImage));
	button.setGraphic(new ImageView(img));
	return button;
    }

    private Button createHelpButton() {
	Button HelpButton = buttonFactory("/resources/images/help.png");
	HelpButton.setOnAction(click->{try {
	    java.awt.Desktop.getDesktop().browse(new URI(WEBSITE));
	} catch (IOException e) {
	    //   viewController.sendError("IOException");
	    e.printStackTrace();
	} catch (URISyntaxException e) {
	    //   controller.sendError("URISyntaxException");
	    e.printStackTrace();
	}});
	return HelpButton;
    }


}
