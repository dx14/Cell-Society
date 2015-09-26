import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Step {

	private int FRAMES_PER_SECOND = 60;
	private int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	private double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	private Timeline animation;
	int two = 2;
	
	
	Grid myGrid = new Grid();
	
	public void step(String xml, String shape) throws SAXException, IOException, ParserConfigurationException {
		double[] square = {Main.windowSizeX, Main.windowSizeY};
		Simulation mySim = simFactory(xml, square);	
		animation = new Timeline();
		KeyFrame frame = new KeyFrame(Duration.seconds(SECOND_DELAY),
				e -> mySim.simStep(null, shape));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
	
	public Simulation simFactory(String xml, double[] square){
		String[] simName = {"Segregation", "Life", "Fire", "WatorWorld"};
		int last = 0;
		for (int i=0; i<simName.length; i++){
			if (xml.equals(simName[i])){
				last = i;
			}
		}		
		Simulation[] mySims = {new Segregation(square, Dom.params),
								new Life(square, Dom.params),
								new Fire(square, Dom.params),
								new WatorWorld(square, Dom.params)};
		return mySims[last];
	}
}
