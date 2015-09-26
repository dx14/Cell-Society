import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

//Any live cell with fewer than two live neighbours dies, as if caused by under-population.
//Any live cell with two or three live neighbours lives on to the next generation.
//Any live cell with more than three live neighbours dies, as if by overcrowding.
//Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

public class Life extends Simulation{
	

	Scene myScene;
	private Group root;
	public Grid iGrid = new Grid();
	protected Cell[][] myGrid = iGrid.getCells();
	public void setScene(Scene ss){
		myScene = ss;
	}
	public Life(double[] dimensions, ArrayList<String> parameters)
			throws SAXException, IOException, ParserConfigurationException {
		super(dimensions, parameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void loopThroughCells(){
		for (int col = 0; col < Grid.gridColumns; col++) {
			for (int row = 0; row < Grid.gridRows; row++) {
				int cellwidth = myGrid[row][col].getMyWidth();
				int cellheight = myGrid[row][col].getMyHeight();
				String cellshape = myGrid[row][col].getMyShape();
				if (myGrid[row][col].checkForMove(myGrid)) {
						
					myGrid[row][col] = new LifePerson(row, col, cellwidth, cellheight, "BLACK", cellshape );
//					
				}
				else{
					myGrid[row][col] = new EmptyLife(row, col, cellwidth, cellheight, "WHITE", cellshape );
//					
				}
				
			}
		}
	}
	

	

	
	

}
