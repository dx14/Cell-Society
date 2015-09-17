package simulations;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private int windowX = 550;
	private int windowY = 450;
    
	@Override
    public void start (Stage s) {
    	GridMaker myGrid = new GridMaker();
        // attach game to the stage and display it
        Scene scene = myGrid.initGrid(windowX, windowY);
        s.setScene(scene);
        s.show();
    }

    /**
     * Start the program.
     */
    public static void main (String[] args) {
        launch(args);
    }
}
