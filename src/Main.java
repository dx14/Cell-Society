import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	
	public static final int windowSizeX = 500;
	public static final int windowSizeY = 600;
	
	Scene myScene;
	BorderPane border = new BorderPane();
	
	@Override
	public void start (Stage s) throws SAXException, IOException, ParserConfigurationException {
		GUI myGUI = new GUI();
		Scene myScene = myGUI.initGUI();
		s.setScene(myScene);
		s.setTitle(Dom.title);
		s.show();
    }
	
    /**
     * Start the program.
     */
    public static void main (String[] args) {
        launch(args);
    }
}