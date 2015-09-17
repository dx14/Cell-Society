

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private final int windowSizeX = 500;
	private final int windowSizeY = 650;
	
	@Override
    public void start (Stage s) throws SAXException, IOException, ParserConfigurationException {
		Grid myGrid = new Grid();
		s.setTitle(myGrid.getSimAuthor());
        // attach game to the stage and display it
        Scene scene = myGrid.initGrid(windowSizeX, windowSizeY);
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
