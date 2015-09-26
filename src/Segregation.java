
import java.util.ArrayList;

import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;


import javafx.scene.paint.Color;


import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
public class Segregation extends Simulation{

	Grid iGrid = new Grid();
	protected Cell[][] myGrid = iGrid.getCells();
	private int FRAMES_PER_SECOND = 2;
	private int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	//		private double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	private Timeline animation;
	private Group root;
	//		private Cell[][] newCells;
	double minRate = .3;
	Scene myScene;
	
	public Segregation(double[] dimensions, ArrayList<String> parameters)
			throws SAXException, IOException, ParserConfigurationException {
		super(dimensions, parameters);
		// TODO Auto-generated constructor stub
	}

	


	@Override
	public void loopThroughCells(){
		
		for (int row = 0; row < myGrid.length; row++) {
			for (int col = 0; col < myGrid[0].length; col++) {
				
				if (myGrid[row][col].checkForMove(myGrid)) {
					myGrid[row][col].moveCell(myGrid);
				}
			}
		}

		
	}

	
	

}