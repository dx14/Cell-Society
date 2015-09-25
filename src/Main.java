
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
	
	public static final int windowSizeX = 700;
	public static final int windowSizeY = 500;
	public String XML;
	
	Scene myScene;
	GUI myGUI = new GUI();
	
	@Override
	public void start (Stage s) throws SAXException, IOException, ParserConfigurationException {
		Scene scene = myGUI.initGUI();	
        s.setScene(scene);
		s.show();
    }
	
//	public Simulation chooseSim(int i, double[] square, ArrayList<String> param) throws SAXException, IOException, ParserConfigurationException{
//		Simulation[] myPossibleSims = {
//				new WatorWorld(square, param),
//				new Segregation(square, param),
//				new Life(square, param),
//				new Fire(square, param)
//		};
//		return myPossibleSims[i];
//	}
    /**
     * Start the program.
     */
    public static void main (String[] args) {
        launch(args);
    }
}