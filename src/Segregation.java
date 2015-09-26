
import java.util.List;

import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;


import javafx.scene.paint.Color;


import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
public class Segregation extends Simulation {

	private int FRAMES_PER_SECOND = 2;
	//		private Cell[][] newCells;
	double minRate = .3;
	Scene myScene;
	
	public Segregation(double[] dimensions, List<String> parameters )
	{
		super(dimensions, parameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void loopThroughCells(Cell[][] cells){
		for (int row = 0; row < cells.length; row++) {
			for (int col = 0; col < cells[0].length; col++) {
				
				if (cells[row][col].checkForMove(cells)) {
					cells[row][col].moveCell(cells);
				}
			}
		}

		
	}
}