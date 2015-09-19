

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	public static final int FRAMES_PER_SECOND = 600;
	private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	private final int windowSizeX = 500;
	private final int windowSizeY = 500;
	
	
	@Override
    public void start (Stage s) throws SAXException, IOException, ParserConfigurationException {
		Buttons myButtons = new Buttons();
		Grid myGrid = new Grid();
		
		ArrayList<String> param = new ArrayList<String>();
        param.add("0.0");
        param.add("0.0");
        param.add("1.0");
      
        double[] square= {(double) windowSizeX, (double) windowSizeY};
        Simulation sim = new WatorWorld(square, param);
		s.setTitle(myButtons.getSimName());
        // attach game to the stage and display it
        Scene scene = myGrid.initGrid(sim, s, "English", windowSizeX, windowSizeY);
       
        
        s.setScene(scene);
        s.show();
        KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
                e -> sim.step(SECOND_DELAY));
        Timeline animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
       
        
    }

    /**
     * Start the program.
     */
    public static void main (String[] args) {
        launch(args);
    }
}
