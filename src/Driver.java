import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewController;

/** 
 * Use the driver JavaFX program to start a SLogo IDE
 *
 * @author Katherine Van Dyk
 * @date 1/30/18
 *
 * 
 */
public class Driver extends Application {  
    private ViewController view = new ViewController();

    /**
     * Initialize the program and begin the animation loop 
     * 
     * @param stage: Primary stage to attach all scenes
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
	view.initialize(primaryStage);
	primaryStage.show();		
    }

    /**
     * Start the program
     */
    public static void main (String[] args) {
	launch(args);
    }
}