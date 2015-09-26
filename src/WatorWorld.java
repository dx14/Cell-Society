import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sun.prism.paint.Color;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WatorWorld extends Simulation{
	
	//private List<Integer> myDimensions = new List<Integer>();  USE THIS IF WE EVER HAVE MORE THAN 2D

	Scene myScene;
	private Group root;
	
	public double[] myDimensions = new double[2];
	
	//protected List<Cell> myEmptyCells;;
	public Grid iGrid = new Grid();
	protected Cell[][] myGrid = iGrid.getCells();
	public WatorWorld(double[] dimensions, List<String> parameters) throws SAXException, IOException, ParserConfigurationException {
		super(dimensions, parameters);
		// TODO Auto-generated constructor stub
	}

	




	
	@Override
	public void loopThroughCells(){
		
		
		for(int i = 0; i < Dom.dimensionX; i++){
			for(int j = 0; j < Dom.dimensionY; j++){
				
				if(myGrid[i][j].checkForMove(myGrid)  && !myGrid[i][j].checkIfBlockedIn(myGrid)){
					
					myGrid[i][j].moveCell( myGrid);

				}
				else if(myGrid[i][j].checkIfBlockedIn(myGrid)){
					myGrid[i][j].updateIfBlocked(myGrid);
					
				}
				else{
					
					myGrid[i][j].changeCellType(myGrid);
				}
					
			}
		}
	
		
	}
	
	
}