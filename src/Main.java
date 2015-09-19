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
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	
	public static final int windowSizeX = 800;
	public static final int windowSizeY = 800;
	private int FRAMES_PER_SECOND = 1;
	private double SECOND_DELAY = 0.1 / FRAMES_PER_SECOND;
	private Timeline animation;
	
	private Fire simul;
	private Group root;
	private BorderPane bp;
	
	@Override
    public void start (Stage s) throws SAXException, IOException, ParserConfigurationException {
		
		Buttons myButtons = new Buttons();
		Grid myGrid = new Grid();
		root = new Group();
		bp = new BorderPane();
		ArrayList<String> param = new ArrayList<String>();
        param.add("0.0");
        param.add("0.0");
        param.add("1.0");
      
        double[] square= {(double) windowSizeX, (double) windowSizeY};
        Segregation sim = new Segregation();
		s.setTitle(myButtons.getSimName());
        // attach game to the stage and display it
       Scene scene = myGrid.initGrid(sim, root, bp, s, "English", windowSizeX, windowSizeY);
       
       
        
        s.setScene(scene);
        s.show();
        
        simul = new Fire();
        simul.setScene(scene);
        animation = new Timeline();
        simul.setRoot(myGrid.getGroup());
        System.out.println("hi");
		KeyFrame frame = new KeyFrame(Duration.seconds(FRAMES_PER_SECOND),
				e -> step(s, windowSizeX, windowSizeY, SECOND_DELAY));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
    }
	
	public void step(Stage s, int width, int height, Double elapsedTime){

		System.out.println("step");
		String[][] colors = simul.segStep(s, Grid.cells);
		
		GridLayout updateGrid = new GridLayout();
//		int i = s.getScene().getRoot().getChildrenUnmodifiable().indexOf("grid");

		

		GridPane grid2 = new GridPane();
//		Node grid = s.getScene().getRoot().getChildrenUnmodifiable().get(i);
		grid2 = updateGrid.gridMaker(width/2, height/2, Grid.gridRows, Grid.gridColumns, colors);
		grid2.setLayoutY(62);
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
