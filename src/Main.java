
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	
	public static final int windowSizeX = 800;
	public static final int windowSizeY = 800;
	public static int FRAMES_PER_SECOND = 1;
	private double SECOND_DELAY = 0.1 / FRAMES_PER_SECOND;
	private Timeline animation;
	private Simulation simul;
	private Group root;
	private BorderPane bp;
	private boolean isRunning = true;
	Buttons myButtons;
	
	@Override
    public void start (Stage s) throws SAXException, IOException, ParserConfigurationException {
		
		myButtons = new Buttons();
		Grid myGrid = new Grid();
		root = new Group();
		bp = new BorderPane();
		ArrayList<String> param = new ArrayList<String>();
        param.add("0.0");
        param.add("0.0");
        param.add("1.0");
      
        double[] square= {(double) windowSizeX, (double) windowSizeY};

        //WatorWorld sim = new WatorWorld(square, param);
        
		s.setTitle(myButtons.getSimName());
        // attach game to the stage and display it
        Scene scene = myGrid.initGrid(root, bp, s, "English", windowSizeX, windowSizeY);
       
       
        
        s.setScene(scene);
        s.show();
       
        simul = chooseSim(0, square, param);
        simul.setScene(scene);
        animation = new Timeline();
        simul.setRoot(myGrid.getGroup());
      
		KeyFrame frame = new KeyFrame(Duration.seconds(FRAMES_PER_SECOND),
				e -> step(s, windowSizeX, windowSizeY, SECOND_DELAY));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
    }
	
	public void step(Stage s, int width, int height, Double elapsedTime){

		String[][] colors = simul.segStep(s, Grid.cells);
		
		GridLayout updateGrid = new GridLayout();
		Pane grid2 = new Pane();
		grid2 = updateGrid.gridMaker(width/2, height/2, Grid.gridRows, Grid.gridColumns, colors);
		grid2.setLayoutY(62);
		root.getChildren().add(grid2);
	}
	
//	public void checkButtonClick () {
//		myButtons.pauseButton.setOnMouseClicked(e -> pauseSim());
//		myButtons.resumeButton.setOnMouseClicked(e -> resumeSim());
//		myButtons.forwardButton.setOnMouseClicked(e -> fwdSim());
//		myButtons.speedButton.setOnMouseClicked(e -> speedSim());
//		myButtons.slowButton.setOnMouseClicked(e -> slowSim());
//	}
	
//	public void pauseSim() {
//		if (isRunning) animation.stop();
//		isRunning = false;
//	}
//
//	public void resumeSim(Stage s, int width, int height, double timeElapsed) {
//		if (!isRunning) {
//			Timeline newTm = new Timeline();
//			FRAMES_PER_SECOND = FRAMES_PER_SECOND - 2;
//			KeyFrame frame = new KeyFrame(Duration.seconds(FRAMES_PER_SECOND),
//					e -> step(s, width, height, timeElapsed));
//			newTm.setCycleCount(Timeline.INDEFINITE);
//			newTm.getKeyFrames().add(frame);
//			newTm.play();
//			isRunning = true;
//		}
//	}
//	
//	public void slowSim(Stage s, int width, int height, double timeElapsed) {
//		if (isRunning && FRAMES_PER_SECOND >= 10) {
//			animation.stop();
//	        Timeline newTm = new Timeline();
//	        FRAMES_PER_SECOND = FRAMES_PER_SECOND - 2;
//			KeyFrame frame = new KeyFrame(Duration.seconds(FRAMES_PER_SECOND),
//					e -> step(s, width, height, timeElapsed));
//			newTm.setCycleCount(Timeline.INDEFINITE);
//			newTm.getKeyFrames().add(frame);
//			newTm.play();
//		}
//	}
//	
//	public void speedSim(Stage s, int width, int height, double timeElapsed) {
//		if (isRunning && FRAMES_PER_SECOND <= 10) {
//			animation.stop();
//	        Timeline newTm = new Timeline();
//	        FRAMES_PER_SECOND = FRAMES_PER_SECOND + 10;
//			KeyFrame frame = new KeyFrame(Duration.seconds(FRAMES_PER_SECOND),
//					e -> step(s, width, height, timeElapsed));
//			newTm.setCycleCount(Timeline.INDEFINITE);
//			newTm.getKeyFrames().add(frame);
//			newTm.play();
//		}
//	} 
//	
//	public void fwdSim() {
//
//	}
	public Simulation chooseSim(int i, double[] square, ArrayList<String> param) throws SAXException, IOException, ParserConfigurationException{
		Simulation[] myPossibleSims = {
				new WatorWorld(square, param),
				new Segregation(square, param),
				new Life(square, param),
				new Fire(square, param)
		};
		return myPossibleSims[i];
	}
    /**
     * Start the program.
     */
    public static void main (String[] args) {
        launch(args);
    }
}