

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static final int windowSizeX = 500;
	private static final int windowSizeY = 500;
	
	@Override
    public void start (Stage s) throws SAXException, IOException, ParserConfigurationException {
		
		Buttons myButtons = new Buttons();
		System.out.println(myButtons.getSimName());
		s.setTitle(myButtons.getSimName());
        // attach game to the stage and display it
        Scene scene = myButtons.initButtons(s, "English", windowSizeX, windowSizeY);
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
