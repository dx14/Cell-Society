

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
    public void start (Stage s) {
		Grid myGrid = new Grid();
		s.setTitle(Grid.simName);
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
