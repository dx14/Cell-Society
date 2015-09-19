

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	
	public static final int windowSizeX = 500;
	public static final int windowSizeY = 500;
	
	private int FRAMES_PER_SECOND = 1;
	private int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	private double SECOND_DELAY = 0.1 / FRAMES_PER_SECOND;
	private Timeline animation;
	
	private Segregation simul;
	private Group root;
	
	@Override
    public void start (Stage s) throws SAXException, IOException, ParserConfigurationException {
		
		Buttons myButtons = new Buttons();
		Grid myGrid = new Grid();
		root = new Group();
		ArrayList<String> param = new ArrayList<String>();
        param.add("0.0");
        param.add("0.0");
        param.add("1.0");
      
        double[] square= {(double) windowSizeX, (double) windowSizeY};
        Simulation sim = new WatorWorld(square, param);
		s.setTitle(myButtons.getSimName());
        // attach game to the stage and display it
       Scene scene = myGrid.initGrid(sim, root, s, "English", windowSizeX, windowSizeY);
       
       
        
        s.setScene(scene);
        s.show();
        
        simul = new Segregation();
        simul.setScene(scene);
        animation = new Timeline();
        simul.setRoot(myGrid.getGroup());
        System.out.println("hi");
		KeyFrame frame = new KeyFrame(Duration.seconds(FRAMES_PER_SECOND),
				e -> step(s, windowSizeX, windowSizeY, SECOND_DELAY));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
        
        //call specific simulation here
       
       
        
    }
	
	public void step(Stage s, int width, int height, Double elapsedTime){
		System.out.println("step");
		String[][] colors = simul.segStep(s, Grid.cells);
		
		GridLayout updateGrid = new GridLayout();
		int i = s.getScene().getRoot().getChildrenUnmodifiable().indexOf("grid");
		GridPane grid2 = new GridPane();
//		Node grid = s.getScene().getRoot().getChildrenUnmodifiable().get(i);
		grid2 = updateGrid.gridMaker(width, height, Grid.gridRows, Grid.gridColumns, colors);
//		s.getScene().getRoot().getChildren().add(grid2);
		root.getChildren().add(grid2);
	}
	

    /**
     * Start the program.
     */
    public static void main (String[] args) {
        launch(args);
    }
}
