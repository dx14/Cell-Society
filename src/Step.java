import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class Step {

	Timeline animation =  new Timeline();	
	Grid myGrid = new Grid();
	
	
	
	public void initLoop(String xml, String sim, String shape, BorderPane bd)  { 
		Buttons myButtons = new Buttons();
		int FRAMES_PER_SECOND = 1;
		double[] square = {Main.windowSizeX, Main.windowSizeY};
		Cell[][] myCells = myGrid.initCells(xml, shape);		
		ArrayList<String> params = getParams();
		Simulation mySim =  simFactory(xml, square, params);
			
		KeyFrame frame = new KeyFrame(Duration.seconds(FRAMES_PER_SECOND),
				e -> mySim.simStep (myCells, shape, bd));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		myButtons.setAnimation(animation);	
	}
	
	public void startLoop(){
		animation.play();
	}

	public void stopLoop(){
		animation.stop();
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
