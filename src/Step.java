import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class Step {
	private int FRAMES_PER_SECOND = 60;
	private int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	private double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	private Timeline animation;
	private Simulation mySim;
	public Timeline getAnimation() {
		return animation;
	}
	private Cell[][] cells;

	public void setAnimation(Timeline animation) {
		this.animation = animation;
	}

	int two = 2;
	Grid myGrid = new Grid();
	
	public Timeline initLoop(Cell[][] myCells, String xml, String sim, String shape, BorderPane bd)  { 
		int FRAMES_PER_SECOND = 1;
		double[] square = {Main.windowSizeX, Main.windowSizeY};
		ArrayList<String> params = getParams();
		mySim =  simFactory(xml, square, params);
		animation =  new Timeline();			
		KeyFrame frame = new KeyFrame(Duration.seconds(FRAMES_PER_SECOND),
				e -> mySim.simStep (myCells, shape, bd));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		return animation;	
	}
	
	public void getStatus(Cell[][] cells){
		 this.cells = cells;
		 for (int i=0; i<cells.length; i++) {
			 for (int j=0; j<cells.length; j++) {
				 cells[i][j] = cells[i][j];
			 }
		 }
	}
	
	public Timeline changeLoop(String shape, BorderPane bd, int fps){
		animation =  new Timeline();			
		KeyFrame frame = new KeyFrame(Duration.seconds(fps),
				e -> mySim.simStep (this.cells, shape, bd));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
//		myButtons.setAnimation(animation);
		return animation;
	}
	
	
	public ArrayList<String> getParams(){
		ArrayList<String> parameters = new ArrayList<String>();
		for (int i=0; i<Dom.params.size(); i++){
			parameters.add(Dom.params.get(i));
		}
		return parameters;
	}
	
	public Simulation simFactory(String xml, double[] square, ArrayList<String> params) {
		String[] simName = {"src/Segregation.xml", "src/GameOfLife.xml", "src/Fire.xml", "src/Wator.xml"};

		int last = 0;
		
		for (int i=0; i<simName.length; i++){
			if (xml.equals(simName[i])){
				last = i;
			}
		}		
		Simulation[] mySims = {new Segregation(square, params),
								new Life(square, params),
								new Fire(square, params),
								new WatorWorld(square, params)};
		return mySims[last];
	}
}
