
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
<<<<<<< HEAD
        s.show();
        
//        simul = new Life();
//        simul.setScene(scene);
//        animation = new Timeline();
//        simul.setRoot(myGrid.getGroup());
//		KeyFrame frame = new KeyFrame(Duration.seconds(FRAMES_PER_SECOND),
//				e -> step(s, windowSizeX, windowSizeY, SECOND_DELAY));
//		animation.setCycleCount(Timeline.INDEFINITE);
//		animation.getKeyFrames().add(frame);
//		animation.play();

        double[] square= {(double) windowSizeX, (double) windowSizeY};

        //WatorWorld sim = new WatorWorld(square, param);
        

        // attach game to the stage and display it

       
       
        
        s.setScene(scene);
        s.show();
       
//        simul = chooseSim(0, square, param);
//        simul.setScene(scene);
//        animation = new Timeline();
//        simul.setRoot(myGrid.getGroup());
//      
//		KeyFrame frame = new KeyFrame(Duration.seconds(FRAMES_PER_SECOND),
//				e -> step(s, windowSizeX, windowSizeY, SECOND_DELAY));
//		animation.setCycleCount(Timeline.INDEFINITE);
//		animation.getKeyFrames().add(frame);
//		animation.play();
=======
		s.show();
>>>>>>> bb623b71f8a4f6cda123fe43a0a8db4005840247
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